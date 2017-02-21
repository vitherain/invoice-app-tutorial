package cz.herain.tutorial.service.impl;

import cz.herain.tutorial.entity.Customer;
import cz.herain.tutorial.entity.Invoice;
import cz.herain.tutorial.repository.InvoiceRepository;
import cz.herain.tutorial.service.InvoiceService;
import cz.herain.tutorial.service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceServiceImpl.class);

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private TimeService timeService;

    /**
     * {@inheritDoc}
     */
    @Override
    public void generateInvoice(final Customer customer, final int dueIntervalInDays, final BigDecimal amount) {
        Assert.notNull(customer, "Customer should not be null!");
        Assert.notNull(amount, "Amount should not be null!");

        final LocalDate now = timeService.getCurrentDate();
        final LocalDate dueDate = now.plusDays(dueIntervalInDays);

        final BigDecimal recountedAmount = this.performComputationThatTakes10Seconds(amount);

        final Invoice invoice = Invoice.InvoiceBuilder.anInvoice()
                .customer(customer)
                .dueDate(dueDate)
                .amount(recountedAmount)
                .build();

        invoiceRepository.save(invoice);
    }

    private BigDecimal performComputationThatTakes10Seconds(final BigDecimal amount) {
        try {
            Thread.sleep(10000);
        } catch (final InterruptedException ex) {
            LOGGER.warn("Thread was interrupted");
        }

        return amount;
    }
}
