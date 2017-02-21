package cz.herain.tutorial.service.impl;

import cz.herain.tutorial.service.TimeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class TimeServiceImpl implements TimeService {

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }
}
