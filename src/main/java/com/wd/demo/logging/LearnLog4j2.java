package com.wd.demo.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Author: wangdi
 * @Date: 2022/1/14 0:21
 */
public class LearnLog4j2 {
    private static final Logger logger = LogManager.getLogger(LearnLog4j2.class);

    public static void main(String[] args) {
        String name = "log4j2";
        logger.debug("i am using {} DEBUG", name);
        logger.info("i am using {} INFO", name);
        logger.warn("i am using {} WARN", name);
        logger.error("i am using {} ERROR", name);

    }
}
