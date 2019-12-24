import java.util.zip.CRC32;

public class class250
{

	public static class157 NetCache_socket;
	public static int field3197;
	public static long field3203;
	public static HashTable NetCache_pendingPriorityWrites;
	public static int NetCache_pendingPriorityWritesCount;
	public static HashTable NetCache_pendingPriorityResponses;
	public static int NetCache_pendingPriorityResponsesCount;
	public static Node2LinkedList NetCache_pendingWritesQueue;
	static HashTable NetCache_pendingWrites;
	public static int NetCache_pendingWritesCount;
	public static HashTable NetCache_pendingResponses;
	public static int NetCache_pendingResponsesCount;
	public static FileRequest currentRequest;
	public static Buffer NetCache_responseHeaderBuffer;
	public static int field3210;
	public static CRC32 NetCache_crc;
	public static IndexData[] NetCache_indexCaches;
	public static byte field3213;
	public static int field3214;
	public static int field3215;

	static
	{
		field3197 = 0;
		NetCache_pendingPriorityWrites = new HashTable(4096);
		NetCache_pendingPriorityWritesCount = 0;
		NetCache_pendingPriorityResponses = new HashTable(32);
		NetCache_pendingPriorityResponsesCount = 0;
		NetCache_pendingWritesQueue = new Node2LinkedList();
		NetCache_pendingWrites = new HashTable(4096);
		NetCache_pendingWritesCount = 0;
		NetCache_pendingResponses = new HashTable(4096);
		NetCache_pendingResponsesCount = 0;
		NetCache_responseHeaderBuffer = new Buffer(8);
		field3210 = 0;
		NetCache_crc = new CRC32();
		NetCache_indexCaches = new IndexData[256];
		field3213 = 0;
		field3214 = 0;
		field3215 = 0;
	}

	public static void method4766(final IndexDataBase indexdatabase_0, final IndexDataBase indexdatabase_1,
	        final IndexDataBase indexdatabase_2)
	{
		class267.field3367 = indexdatabase_0;
		class267.field3348 = indexdatabase_1;
		class139.field1877 = indexdatabase_2;
	}

	public static char method4770(final char char_0)
	{
		switch (char_0)
		{
			case ' ':
			case '-':
			case '_':
			case ' ':
				return '_';
			case '#':
			case '[':
			case ']':
				return char_0;
			case 'À':
			case 'Á':
			case 'Â':
			case 'Ã':
			case 'Ä':
			case 'à':
			case 'á':
			case 'â':
			case 'ã':
			case 'ä':
				return 'a';
			case 'Ç':
			case 'ç':
				return 'c';
			case 'È':
			case 'É':
			case 'Ê':
			case 'Ë':
			case 'è':
			case 'é':
			case 'ê':
			case 'ë':
				return 'e';
			case 'Í':
			case 'Î':
			case 'Ï':
			case 'í':
			case 'î':
			case 'ï':
				return 'i';
			case 'Ñ':
			case 'ñ':
				return 'n';
			case 'Ò':
			case 'Ó':
			case 'Ô':
			case 'Õ':
			case 'Ö':
			case 'ò':
			case 'ó':
			case 'ô':
			case 'õ':
			case 'ö':
				return 'o';
			case 'Ù':
			case 'Ú':
			case 'Û':
			case 'Ü':
			case 'ù':
			case 'ú':
			case 'û':
			case 'ü':
				return 'u';
			case 'ß':
				return 'b';
			case 'ÿ':
			case 'Ÿ':
				return 'y';
			default:
				return Character.toLowerCase(char_0);
		}
	}

}
