package patika.paycorelastproject.Mapper;

import patika.paycorelastproject.Entity.Customer;

public class CustomerMapper {
    public static CustomerDTO toDto(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(customer.getName());
        customerDTO.setSurname(customer.getSurname());
        customerDTO.setAge(customer.getAge());
        customerDTO.setGender(customer.getGender());
        customerDTO.setProfession(customer.getProfession());
        customerDTO.setCitizen_No(customer.getCitizen_No());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setSalary(customer.getSalary());
        customerDTO.setCredit_Point(customer.getCredit_Point());
        return customerDTO;
    }
    public static Customer toEntity(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setAge(customerDTO.getAge());
        customer.setGender(customerDTO.getGender());
        customer.setProfession(customerDTO.getProfession());
        customer.setCitizen_No(customerDTO.getCitizen_No());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getAddress());
        customer.setSalary(customerDTO.getSalary());
        customer.setCredit_Point(customerDTO.getCredit_Point());
        return customer;
    }

}
