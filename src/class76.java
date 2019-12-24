import java.math.BigInteger;

public class class76
{

	static final BigInteger LOGIN_EXPONENT, LOGIN_MODULUS;
	//static final BigInteger LOGIN_EXPONENT = new BigInteger("65537");
	//static final BigInteger LOGIN_MODULUS = new BigInteger(
	//		"94210824259843347324509385276594109263523823612210415282840685497179394322370180677069205378760490069724955139827325518162089726630921395369270393801925644637806226306156731189625154078707248525519618118185550146216513714101970726787284175941436804270501308516733103597242337227056455402809871503542425244523");

	static {
		if(Loader.CONNECT_TO_OSRS) {
			LOGIN_EXPONENT = new BigInteger("10001", 16);
			LOGIN_MODULUS = new BigInteger("97e13ef453eef11c2e2b108891d256c90098b9da343c760762cdc2ccb5b9cc01552ee1f17fef7e9ad45cce00f378db17ae8f17c43fa4bdab098e5022b17175b147560d10c86658c7a471514e0bdce6c95f1b0ba8ceb5322e09b64b6bb30b1f88d2a879f88b871b4519717800df32d7f3e55f492af08025ab7ccd747491e82fe5", 16);
		} else {
			LOGIN_EXPONENT = new BigInteger("65537");
			LOGIN_MODULUS = new BigInteger("94210824259843347324509385276594109263523823612210415282840685497179394322370180677069205378760490069724955139827325518162089726630921395369270393801925644637806226306156731189625154078707248525519618118185550146216513714101970726787284175941436804270501308516733103597242337227056455402809871503542425244523");
		}
	}

	public static CacheFile[] idxFiles;
	static int[] field1073;

	public static Enumerated forOrdinal(final Enumerated[] enumerateds_0, final int int_0)
	{
		final Enumerated[] enumerateds_1 = enumerateds_0;

		for (int int_1 = 0; int_1 < enumerateds_1.length; int_1++)
		{
			final Enumerated enumerated_0 = enumerateds_1[int_1];
			if (int_0 == enumerated_0.vmethod5815())
			{
				return enumerated_0;
			}
		}

		return null;
	}

	public static long method1804(final int int_0, final int int_1, final int int_2, final boolean bool_0,
	        final int int_3)
	{
		long long_0 = ((int_0 & 0x7F) << 0) | ((int_1 & 0x7F) << 7) | ((int_2 & 0x3) << 14)
		        | ((int_3 & 0xFFFFFFFFL) << 17);
		if (bool_0)
		{
			long_0 |= 0x10000L;
		}

		return long_0;
	}

}
