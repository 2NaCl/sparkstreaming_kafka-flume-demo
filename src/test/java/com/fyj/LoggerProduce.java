package com.fyj;

import org.apache.log4j.Logger;

public class LoggerProduce {

    private static Logger logger = Logger.getLogger(LoggerProduce.class.getName());

    public static void main(String[] args) throws InterruptedException {
        int index = 0;
        while (true) {
            Thread.sleep(1000);
            logger.info("value : "+index++);
        }

    }
}
