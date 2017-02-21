package cz.herain.tutorial.service.impl;

import cz.herain.tutorial.entity.Customer;
import cz.herain.tutorial.entity.Invoice;
import cz.herain.tutorial.repository.InvoiceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceServiceImplUnitTest {

    private static final int DUE_INTERVAL_IN_DAYS = 30;
    private static final BigDecimal AMOUNT = BigDecimal.TEN;
    private static final BigDecimal NULL_AMOUNT = null;
    private static final String CUSTOMER_NAME = "ABCD a.s.";

    @InjectMocks
    private InvoiceServiceImpl invoiceService;

    @Mock
    private InvoiceRepository invoiceRepositoryMock;

    @Captor
    private ArgumentCaptor<Invoice> invoiceCaptor;

    private Customer customer;

    @Before
    public void prepareData() {
        customer = Customer.CustomerBuilder.aCustomer()
                .name(CUSTOMER_NAME)
                .build();
    }

    @Test
    public void invoiceShouldBeSavedProperly() {
        // mock behaviour
        doReturn(null).when(invoiceRepositoryMock).save(invoiceCaptor.capture());

        // tested method
        invoiceService.generateInvoice(customer, DUE_INTERVAL_IN_DAYS, AMOUNT);

        // verification
        final Invoice savedInvoice = invoiceCaptor.getValue();
        assertThat(savedInvoice,                notNullValue());
        assertThat(savedInvoice.getDueDate(),   is(LocalDate.now().plusDays(DUE_INTERVAL_IN_DAYS)));
        assertThat(savedInvoice.getAmount(),    is(AMOUNT));
        assertThat(savedInvoice.getCustomer(),  is(customer));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ifCustomerIsNullItShouldThrowException() {
        invoiceService.generateInvoice(null, DUE_INTERVAL_IN_DAYS, AMOUNT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ifAmountIsNullItShouldThrowException() {
        invoiceService.generateInvoice(customer, DUE_INTERVAL_IN_DAYS, NULL_AMOUNT);
    }
}
