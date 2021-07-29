package utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HelperClass {
	
	public static Logger logJ;
	
	public static String genRandomString() {
		String strRandom = RandomStringUtils.randomAlphabetic(3);
		return strRandom;
	}
	
	public static Logger getLogJ() {
		logJ = LogManager.getLogger();
		return logJ;
	}
}
