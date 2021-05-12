package io.metaloom.loom.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTest {

	public static final Logger logger = LogManager.getLogger(LoggerTest.class);

	public static void main(String[] args) {
		logger.error("Test Error");
		logger.info("Test Info");
		logger.warn("Test Warn");
		logger.debug("Test Debug");
	}

}
