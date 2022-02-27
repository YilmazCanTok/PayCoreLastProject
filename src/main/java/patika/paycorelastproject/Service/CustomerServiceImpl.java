package patika.paycorelastproject.Service;

import patika.paycorelastproject.Entity.Customer;
import patika.paycorelastproject.Handler.NotFoundException;
import patika.paycorelastproject.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(Integer id) {
        Optional<Customer> byID = customerRepository.findById(id);
        return byID.orElseThrow(()-> new NotFoundException("Customer"));
    }

    @Override
    public void addCustomer(Customer customer) {customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Integer id, Customer customer) {
        getCustomer(id);
        customer.setId(id);
        return customerRepository.save(customer);
    }


    @Override
    public boolean deleteCustomer(Integer id) {
        customerRepository.delete(getCustomer(id));
        return true;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Integer getMoneyById(Integer id) {
        Customer customer = customerRepository.getById(id);
        Integer maxGiveaway;
        if(customer.getCredit_Point()<500){
            maxGiveaway = 0;
            return maxGiveaway;
        }
        else if (customer.getCredit_Point()>=500 && customer.getCredit_Point()<1000){
            if (customer.getSalary()<5000){
                maxGiveaway = 10000;
            }
            else{
                maxGiveaway =20000;
            }
            return maxGiveaway;
        }
        else {
            maxGiveaway = customer.getSalary()*4;
            return maxGiveaway;
        }
    }
}
