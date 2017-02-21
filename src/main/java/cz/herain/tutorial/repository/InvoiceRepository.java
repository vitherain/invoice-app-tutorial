package cz.herain.tutorial.repository;

import cz.herain.tutorial.entity.Invoice;

public interface InvoiceRepository {

    /**
     * Saves the given {@code invoice} into the storage.
     * @param invoice to be saved
     * @return created invoice with new {@code id}
     */
    Invoice save(Invoice invoice);
}
