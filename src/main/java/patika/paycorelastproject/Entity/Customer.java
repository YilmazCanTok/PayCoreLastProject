package patika.paycorelastproject.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Customer")

public class Customer {
    @Id
    @NotBlank
    private Integer id;

    @NotNull(message = "The validation of Customer's id must be typed")
    @Size(min = 11, max = 11)
    private String citizen_No;

    @Size(min = 5, max = 30, message = "username length should be between 5 and 25 characters")
    @NotNull(message = "The validation of Customer's name must be entered")
    private String name;

    @NotNull(message = "The validation of Customer's lastname must be entered")
    @Size(min = 2, max = 20, message = "user lastname length should be between 2 and 20 characters")
    private String surname;

    @NotNull(message = "The validation of Customer's age must be entered")
    private Integer age;

    @NotNull(message = "Please type the gender of the customer")
    @Size(min = 4, max = 6)
    private String gender;

    @NotNull(message = "The validation of Customer's address must be entered")
    private String address;

    @NotBlank
    @Email(message = "E-mail not valid")
    private String email;

    @NotNull(message = "Please type Customer's profession")
    private String profession;

    @NotNull(message = "Please enter the salary of Customer")
    private Integer salary;

    @NotNull(message = "Please enter the credit point of Customer")
    private Integer credit_Point;
}
