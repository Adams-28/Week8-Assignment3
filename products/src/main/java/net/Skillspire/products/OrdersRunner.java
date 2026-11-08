package net.Skillspire.products;

import jakarta.persistence.EntityManager;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;


//@Component
public class OrdersRunner implements org.springframework.boot.CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final EntityManager entityManager;
    private final TransactionTemplate transactionTemplate;

    public OrdersRunner(CustomerRepository customerRepository,
                        ProductRepository productRepository, EntityManager entityManager,
                        PlatformTransactionManager transactionManager)
    {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.entityManager = entityManager;
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }


    @Override
    public void run(String...args) {

        // Bundling the operations within a transaction
        transactionTemplate.executeWithoutResult(status -> {

            // Creating the customer, address, products, and orders and saving them to the repositories and customer.
            Customer bob = new Customer("Bob");
            Address address1 = new Address("232 Wallaby Way");
            bob.setAddress(address1);
            Product pringles = new Product("Pringles", "Chips", 5, 16);
            Product donuts = new Product("Donuts", "Deserts", 4, 30);
            productRepository.save(pringles);
            productRepository.save(donuts);
            Order order1 = new Order("Chips order");
            Order order2 = new Order(("Deserts order"));
            order1.addProduct(pringles);
            order2.addProduct(donuts);
            bob.addOrder(order1);
            bob.addOrder(order2);

            //Saving the created customer
            customerRepository.save(bob);

            Long customerId = bob.getId();

            entityManager.flush();
            entityManager.clear();


            Customer savedCustomer = customerRepository
                    .findById(customerId)
                    .orElseThrow();

            //Printing the Customer info and their orders
            System.out.println("------Customer Info------");
            System.out.println("Customer: " + savedCustomer.getName());
            System.out.println(savedCustomer.getAddress());

            System.out.println("------Customer Orders------");
            for (Order order : savedCustomer.getOrders()) {
                System.out.println("\n" + order.getDescription());

            for (Product product : order.getProducts())
                System.out.println(" - " + product.getName() + ": $" + product.getPrice());;
            }
        });





        
    }
}
