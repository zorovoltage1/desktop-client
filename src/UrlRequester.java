import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;

public class UrlRequester implements Runnable {

    static ScheduledExecutorService field1855;
    static IndexData indexCache4;
    static int field1856;
    final Thread thread;
    boolean isClosed;
    Queue requests;

    public UrlRequester() {
        requests = new LinkedList();
        thread = new Thread(this);
        thread.setPriority(1);
        thread.start();
    }

    public UrlRequest request(final URL url_0) {
        final UrlRequest urlrequest_0 = new UrlRequest(url_0);
        synchronized (this) {
            requests.add(urlrequest_0);
            notify();
            return urlrequest_0;
        }
    }

    public void close() {
        isClosed = true;

        try {
            synchronized (this) {
                notify();
            }

            thread.join();
        } catch (final InterruptedException interruptedexception_0) {
        }

    }

    @Override
    public void run() {
        while (!isClosed) {
            try {
                UrlRequest urlrequest_0;
                synchronized (this) {
                    urlrequest_0 = (UrlRequest) requests.poll();
                    if (urlrequest_0 == null) {
                        try {
                            this.wait();
                        } catch (final InterruptedException interruptedexception_0) {
                        }
                        continue;
                    }
                }

                DataInputStream datainputstream_0 = null;
                URLConnection urlconnection_0 = null;

                try {
                    urlconnection_0 = urlrequest_0.url.openConnection();
                    urlconnection_0.setConnectTimeout(5000);
                    urlconnection_0.setReadTimeout(5000);
                    urlconnection_0.setUseCaches(false);
                    urlconnection_0.setRequestProperty("Connection", "close");
                    final int int_0 = urlconnection_0.getContentLength();
                    if (int_0 >= 0) {
                        final byte[] bytes_0 = new byte[int_0];
                        datainputstream_0 = new DataInputStream(urlconnection_0.getInputStream());
                        datainputstream_0.readFully(bytes_0);
                        urlrequest_0.response0 = bytes_0;
                    }

                    urlrequest_0.isDone0 = true;
                } catch (final IOException ioexception_0) {
                    urlrequest_0.isDone0 = true;
                } finally {
                    if (datainputstream_0 != null) {
                        datainputstream_0.close();
                    }

                    if ((urlconnection_0 != null) && (urlconnection_0 instanceof HttpURLConnection)) {
                        ((HttpURLConnection) urlconnection_0).disconnect();
                    }

                }
            } catch (final Exception exception_0) {
                UnitPriceComparator.processClientError(null, exception_0);
            }
        }

    }

    static void runWidgetOnLoadListener(final int int_0) {
        if (int_0 != -1) {
            if (CombatInfo2.loadWidget(int_0)) {
                final Widget[] widgets_0 = GameCanvas.widgets[int_0];

                for (int int_1 = 0; int_1 < widgets_0.length; int_1++) {
                    final Widget widget_0 = widgets_0[int_1];
                    if (widget_0.onLoadListener != null) {
                        final ScriptEvent scriptevent_0 = new ScriptEvent();
                        scriptevent_0.widget = widget_0;
                        scriptevent_0.objs = widget_0.onLoadListener;
                        class309.method5674(scriptevent_0, 5000000);
                    }
                }

            }
        }
    }

    static String method3113(final int int_0, final int int_1) {
        final int int_2 = int_1 - int_0;
        return int_2 < -9 ? class6.getColTags(16711680)
                : (int_2 < -6 ? class6.getColTags(16723968)
                : (int_2 < -3 ? class6.getColTags(16740352)
                : (int_2 < 0 ? class6.getColTags(16756736)
                : (int_2 > 9 ? class6.getColTags(65280)
                : (int_2 > 6 ? class6.getColTags(4259584)
                : (int_2 > 3 ? class6.getColTags(8453888)
                : (int_2 > 0 ? class6.getColTags(12648192)
                : class6.getColTags(16776960))))))));
    }

}
