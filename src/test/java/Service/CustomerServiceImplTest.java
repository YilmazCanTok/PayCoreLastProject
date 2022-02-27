package Service;

import patika.paycorelastproject.Entity.Customer;
import patika.paycorelastproject.Repository.CustomerRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import patika.paycorelastproject.Service.CustomerServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerServiceimpl;


    @Test
    void getCustomer() {
        Customer customer = new Customer(1,"26534865795","Yılmaz","Tok",24,"Male","Yenimahalle/Ankara","yilmaz@gmail.com","Web Developer",10000,1000);
        Mockito.when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
        Customer customer2 = customerServiceimpl.getCustomer(1);
        Assert.assertEquals(customer.getName(), customer2.getName());
        Assert.assertEquals(customer.getAge(), customer2.getAge());
    }

    @Test
    void addCustomer() {
        Customer customer = new Customer(1,"26534865795","Yılmaz","Tok",24,"Male","Yenimahalle/Ankara","yilmaz@gmail.com","Web Developer",10000,1000);
        // stub - when
        Mockito.when(customerRepository.save(any())).thenReturn(customer);

        // then
        customerServiceimpl.addCustomer(customer);

        Mockito.verify(customerRepository, Mockito.times(1)).save(any());

    }

    @Test
    void updateCustomer() {
        /*Customer customer = new Customer(1,"26534865795","Yılmaz","Tok",24,"Male","Yenimahalle/Ankara","yilmaz@gmail.com","Web Developer",10000,1000);
        Mockito.when(customerRepository.findById(1)).thenReturn(Optional.of(customer));
        Customer customer1 = customer;
        customer.setId(2);
        Assert.assertEquals(customer.getId(),customer1.getId());*/
    }

    @Test
    void deleteCustomer() {
        Customer customer = new Customer(1,"26534865795","Yılmaz","Tok",24,"Male","Yenimahalle/Ankara","yilmaz@gmail.com","Web Developer",10000,1000);
        // stub - when


        // then
        customerServiceimpl.addCustomer(customer);

        Mockito.verify(customerRepository, Mockito.times(1)).save(any());
    }

    @Test
    void getAllCustomers() {
        //init
        Customer customer1 = new Customer(1,"26534865795","Yılmaz","Tok",24,"Male","Yenimahalle/Ankara","yilmaz@gmail.com","Web Developer",10000,1000);
        Customer customer2 = new Customer(2,"24334832695","Peker","Pekmez",35,"Male","Keçiören/Ankara","ppekmez@gmail.com","Dentist",15000,500);
        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);

        // when
        Mockito.when(customerRepository.findAll()).thenReturn(customers);

        // then
        List<Customer> allPassengers = customerServiceimpl.getAllCustomers();

        Assert.assertEquals(customers.size(), allPassengers.size());
    }

    @Test
    void getMoneyById() {
        /*Customer customer = new Customer(1,"26534865795","Yılmaz","Tok",24,"Male","Yenimahalle/Ankara","yilmaz@gmail.com","Web Developer",10000,1000);
        Mockito.when(customerRepository.save(any())).thenReturn(customer);
        customerServiceimpl.getMoneyById(1);*/
    }
}