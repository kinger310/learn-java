package com.wd.demo.logging;


import org.apache.log4j.Logger;


/**
 * @Author: wangdi
 * @Date: 2022/1/14 0:18
 */
public class LearnLog4j {

    private static final Logger logger = Logger.getLogger(LearnLog4j.class);

    public static void main(String[] args) {
        String name = "log4j";
        logger.debug("i am using log4j DEBUG");
        logger.info("i am using log4j INFO");
        logger.warn("i am using log4j WARN");
        logger.error("i am using log4j ERROR");
    }
}
