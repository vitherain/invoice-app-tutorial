package cz.herain.tutorial.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface TimeService {

    /**
     * Returns current local date-time represented by
     * <code>java.time.LocalDateTime</code> instance.
     * @return current local date-time
     */
    LocalDateTime getCurrentDateTime();

    /**
     * Returns current local date represented by
     * <code>java.time.LocalDate</code> instance.
     * @return current local date
     */
    LocalDate getCurrentDate();

    /**
     * Returns current local time represented by
     * <code>java.time.LocalTime</code> instance.
     * @return current local time
     */
    LocalTime getCurrentTime();
}
