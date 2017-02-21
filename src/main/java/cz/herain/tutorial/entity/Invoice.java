package cz.herain.tutorial.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Invoice {

    private Long id;
    private Customer customer;
    private LocalDate dueDate;
    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(final LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Invoice invoice = (Invoice) o;

        if (id != null ? !id.equals(invoice.id) : invoice.id != null) return false;
        if (customer != null ? !customer.equals(invoice.customer) : invoice.customer != null) return false;
        if (dueDate != null ? !dueDate.equals(invoice.dueDate) : invoice.dueDate != null) return false;
        return amount != null ? amount.equals(invoice.amount) : invoice.amount == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customer=" + customer +
                ", dueDate=" + dueDate +
                ", amount=" + amount +
                '}';
    }

    public static final class InvoiceBuilder {
        private Long id;
        private Customer customer;
        private LocalDate dueDate;
        private BigDecimal amount;

        private InvoiceBuilder() {
        }

        public static InvoiceBuilder anInvoice() {
            return new InvoiceBuilder();
        }

        public InvoiceBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public InvoiceBuilder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public InvoiceBuilder dueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public InvoiceBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Invoice build() {
            Invoice invoice = new Invoice();
            invoice.setId(id);
            invoice.setCustomer(customer);
            invoice.setDueDate(dueDate);
            invoice.setAmount(amount);
            return invoice;
        }
    }
}
