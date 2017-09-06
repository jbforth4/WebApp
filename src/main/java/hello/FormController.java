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

@RestController
public class FormController {

    @Autowired
    private PersonService personService;
    //private DataBase dataBase;

//    @Autowired
//    public FormController(Person person){
//        this.person = person;
//    }

    @RequestMapping(value = "/signup.html/form", method = RequestMethod.POST)
    public ResponseEntity<Person> signUpForm(@ModelAttribute Person person) throws SQLException, ClassNotFoundException {
        //this.person = person;

        //System.out.println(person.toString());

        //dataBase.addPerson(person);
        Person person1 = new Person();
        person1.setFirstName(person.getFirstName());
        personService.save(person1);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }



}
