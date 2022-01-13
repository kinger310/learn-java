package com.wd.demo.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: wangdi
 * @Date: 2022/1/14 0:17
 */
public class LearnLogback {
    private static final Logger logger = LoggerFactory.getLogger(LearnLogback.class);

    public static void main(String[] args) {
        String name = "logback";
        logger.debug("i am using {} DEBUG", name);
        logger.info("i am using {} INFO", name);
        logger.warn("i am using {} WARN", name);
        logger.error("i am using {} ERROR", name);    }
}
