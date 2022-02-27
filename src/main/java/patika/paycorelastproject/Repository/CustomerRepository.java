package patika.paycorelastproject.Repository;

import patika.paycorelastproject.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
