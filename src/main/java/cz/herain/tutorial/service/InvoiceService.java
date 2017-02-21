package cz.herain.tutorial.service;

import cz.herain.tutorial.entity.Customer;

import java.math.BigDecimal;

public interface InvoiceService {

    /**
     * Method creates and saves new {@code Invoice} with provided values.
     * @param customer to be set in the invoice
     * @param dueIntervalInDays {@code dueDate} of the {@code invoice} is going to be calculated as {@code today's date + dueIntervalInDays}
     * @param amount to be set in the invoice
     */
    void generateInvoice(Customer customer, int dueIntervalInDays, BigDecimal amount);
}
