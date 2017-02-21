package cz.herain.tutorial.repository.impl;

import cz.herain.tutorial.entity.Invoice;
import cz.herain.tutorial.repository.InvoiceRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * This implementation uses Map as a storage under the hood,
 * so it is not persistent!
 */
@Repository
public class FakeInvoiceRepository implements InvoiceRepository {

    private long ids;
    private Map<Long, Invoice> customers = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Invoice save(final Invoice invoice) {
        if (invoice != null) {
            invoice.setId(this.getNextId());
            customers.put(invoice.getId(), invoice);

            return invoice;
        }
        return null;
    }

    private long getNextId() {
        return ids++;
    }
}
