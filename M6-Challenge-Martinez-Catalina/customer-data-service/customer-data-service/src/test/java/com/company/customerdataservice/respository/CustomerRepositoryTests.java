package com.company.customerdataservice.respository;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class CustomerRepositoryTests {
    @Autowired
    CustomerRepository customerRepo;

    @BeforeEach
    public void setUp() throws Exception {
        customerRepo.deleteAll();
    }

    @Test
    public void shouldAddCustomer(){
        Customer test = new Customer();
        test.setFirstName("Catalina");
        test.setLastName("Martinez");
        test.setEmail("catamtz3@gmail.com");
        test.setCompany("Netflix");
        test.setPhone("509-686-2020");
        test.setAddress1("4738 22nd Ave NE");
        test.setAddress2("1636 Douglas Ave");
        test.setCity("Seattle");
        test.setState("Washington");
        test.setPostalCode("98105");
        test.setCountry("USA");

        test = customerRepo.save(test);
        Optional<Customer> retrieve = customerRepo.findById(test.getId());
        assertEquals(retrieve.get(), test);
    }


    @Test
    public void shouldGetCustomerByID(){
        Customer test = new Customer();
        test.setFirstName("Catalina");
        test.setLastName("Martinez");
        test.setEmail("catamtz3@gmail.com");
        test.setCompany("Netflix");
        test.setPhone("509-686-2020");
        test.setAddress1("4738 22nd Ave NE");
        test.setAddress2("1636 Dougles Ave");
        test.setCity("Seattle");
        test.setState("Washington");
        test.setPostalCode("98105");
        test.setCountry("USA");
        test = customerRepo.save(test);


        Customer test2 = new Customer();
        test2.setFirstName("Carson");
        test2.setLastName("Essabhoy");
        test2.setEmail("carsonj@gmail.com");
        test2.setCompany("Costco");
        test2.setPhone("203-277-2121");
        test2.setAddress1("4636 22nd Ave NE");
        test2.setAddress2("1111 Peaches Drive");
        test2.setCity("Orinda");
        test2.setState("California");
        test2.setPostalCode("99999");
        test2.setCountry("USA");
        test2 = customerRepo.save(test2);
        Optional<Customer> retrieve = customerRepo.findById(test2.getId());
        assertEquals(retrieve.get(), test2);
    }

    @Test
    public void shouldUpdateCustomer() {
        Customer test = new Customer();
        test.setFirstName("Catalina");
        test.setLastName("Martinez");
        test.setEmail("catamtz3@gmail.com");
        test.setCompany("Netflix");
        test.setPhone("509-686-2020");
        test.setAddress1("4738 22nd Ave NE");
        test.setAddress2("1636 Dougles Ave");
        test.setCity("Seattle");
        test.setState("Washington");
        test.setPostalCode("98105");
        test.setCountry("USA");
        test = customerRepo.save(test);

        test.setFirstName("Cleo");
        test.setCompany("Aqueon");
        customerRepo.save(test);

        //Assert...
        Optional<Customer> test1 = customerRepo.findById(test.getId());
        assertEquals(test1.get(), test);
    }

    @Test
    public void ShouldFindByState(){
        Customer test = new Customer();
        test.setFirstName("Catalina");
        test.setLastName("Martinez");
        test.setEmail("catamtz3@gmail.com");
        test.setCompany("Netflix");
        test.setPhone("509-686-2020");
        test.setAddress1("4738 22nd Ave NE");
        test.setAddress2("1636 Dougles Ave");
        test.setCity("Seattle");
        test.setState("Washington");
        test.setPostalCode("98105");
        test.setCountry("USA");
        test = customerRepo.save(test);


        Customer test2 = new Customer();
        test2.setFirstName("Carson");
        test2.setLastName("Essabhoy");
        test2.setEmail("carsonj@gmail.com");
        test2.setCompany("Costco");
        test2.setPhone("203-277-2121");
        test2.setAddress1("4636 22nd Ave NE");
        test2.setAddress2("1111 Peaches Drive");
        test2.setCity("Orinda");
        test2.setState("Washington");
        test2.setPostalCode("99999");
        test2.setCountry("USA");
        test2 = customerRepo.save(test2);

        //Assert...
        List<Customer> cList = customerRepo.findByState("Washington");

        assertEquals(cList.size(), 2);
    }

    @Test
    public void shouldDeleteCustomerById() {
        Customer test = new Customer();
        test.setFirstName("Catalina");
        test.setLastName("Martinez");
        test.setEmail("catamtz3@gmail.com");
        test.setCompany("Netflix");
        test.setPhone("509-686-2020");
        test.setAddress1("4738 22nd Ave NE");
        test.setAddress2("1636 Dougles Ave");
        test.setCity("Seattle");
        test.setState("Washington");
        test.setPostalCode("98105");
        test.setCountry("USA");
        test = customerRepo.save(test);
        //Assert...
        Optional<Customer> test1 = customerRepo.findById(test.getId());
        assertEquals(test1.get(), test);
        customerRepo.deleteById(test.getId());
        test1 = customerRepo.findById(test.getId());
        assertFalse(test1.isPresent());
    }


}
