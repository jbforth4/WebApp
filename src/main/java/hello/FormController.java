package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FormController {

    private Person person;

    @RequestMapping(value = "/signup.html/form", method = RequestMethod.POST)
    public ResponseEntity<Person> signUpForm(@ModelAttribute Person person) {
        this.person = person;

        System.out.println(person.toString());
        return new ResponseEntity<>(person, HttpStatus.OK);
    }



}
