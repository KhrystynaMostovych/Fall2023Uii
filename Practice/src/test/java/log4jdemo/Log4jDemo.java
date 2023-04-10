package log4jdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
    private static final Logger LOGGER = LogManager.getLogger(Log4jDemo.class);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            LOGGER.info("Running loop " + i);
        }

        calculateTax(123456 , true);
        calculateTax(-123,true);
    }

     static double calculateTax(double salary, boolean isMarried) {
        LOGGER.info("Receive request for calculating tax ");
        LOGGER.debug("Personal name salary " + salary + isMarried);
        if (salary < 35000 && isMarried) {

            LOGGER.debug("tax:" + (salary * 0.1));
        } else {
            LOGGER.error("Salary can't be negative");
        }
        return 0;
    }}
