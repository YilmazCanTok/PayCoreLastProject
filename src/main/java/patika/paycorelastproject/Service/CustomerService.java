package patika.paycorelastproject.Service;

import patika.paycorelastproject.Entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(Integer id);

    void addCustomer(Customer customer);

    Customer updateCustomer(Integer id, Customer customer);

    boolean deleteCustomer(Integer id);

    List<Customer> getAllCustomers();

    Integer getMoneyById(Integer id);
}
