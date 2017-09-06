package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import hello.service.PersonService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class FormController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/signup.html/form", method = RequestMethod.POST)
    public ResponseEntity<Person> signUpForm(@ModelAttribute Person person) throws SQLException, ClassNotFoundException {

        Person person1 = new Person();
        person1.setFirstName(person.getFirstName());
        person1.setLastName(person.getLastName());
        person1.setEmail(person.getEmail());
        personService.save(person1);

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @RequestMapping(value = "/print")
    public List<Person> printPersons(){
        return personService.findAllPersons();
    }

}
