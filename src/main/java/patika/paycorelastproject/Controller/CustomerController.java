package patika.paycorelastproject.Controller;

import io.swagger.annotations.Api;
import patika.paycorelastproject.Entity.Customer;
import patika.paycorelastproject.Mapper.CustomerDTO;
import patika.paycorelastproject.Mapper.CustomerMapper;
import patika.paycorelastproject.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/customer")
@Api(value = "CustomerController")
public class CustomerController {

    private final CustomerService customerService;
    @GetMapping(path = "/hello")
    public String hello() {
        return "Welcome to Customer Service!";
    }

    @PostMapping(path = "/create")
    public void saveCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        customerService.addCustomer(CustomerMapper.toEntity(customerDTO));
    }

    @DeleteMapping(path = "/delete")
    public boolean deleteCustomer(@RequestBody @Min(1) Integer id){
        return customerService.deleteCustomer(id);
    }

    @PutMapping(path = "/update")
    public CustomerDTO updateCustomer(@PathVariable @Min(1) Integer id, @RequestBody CustomerDTO customerDTO){
        return CustomerMapper.toDto(customerService.updateCustomer(id, CustomerMapper.toEntity(customerDTO)));
    }

    @GetMapping(path = "/get")
    public ResponseEntity<?> getCustomer(@PathVariable @Min(1) Integer id) {
        ResponseEntity<?> response = null;
        CustomerDTO customerDTO = null;
        Customer customer = customerService.getCustomer(id);
        customerDTO = CustomerMapper.toDto(customer);
        response = new ResponseEntity<>(customerDTO, HttpStatus.OK);
        return response;
    }

    @GetMapping(value = "/all")
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        List<CustomerDTO> collect = allCustomers.stream().map(CustomerMapper::toDto).collect(Collectors.toList());
        return collect;
    }

    @GetMapping(value = "/id/{by-id}")
    public Integer getMoneyById(@PathVariable @Min(1) Integer id){
        Customer customer = customerService.getCustomer(id);
        return customerService.getMoneyById(id);
    }
}
