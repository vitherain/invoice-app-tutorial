package cz.herain.tutorial.entity;

public class Customer {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Customer customer = (Customer) o;

        return name != null ? name.equals(customer.name) : customer.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }

    public static final class CustomerBuilder {
        private String name;

        private CustomerBuilder() {
        }

        public static CustomerBuilder aCustomer() {
            return new CustomerBuilder();
        }

        public CustomerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Customer build() {
            Customer customer = new Customer();
            customer.setName(name);
            return customer;
        }
    }
}
