package hello;

import hello.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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
    public List<Person> printPersons() {
        return personService.findAllPersons();
    }


    @RequestMapping(value = "/freePorn", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage1() throws IOException {
        ClassPathResource imgFile = new ClassPathResource("freePorn.jpg");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }

    @RequestMapping(value = "/MilaKunis", method = RequestMethod.GET, produces = MediaType.IMAGE_GIF_VALUE)
    public ResponseEntity<byte[]> getImage2() throws IOException {
        ClassPathResource imgFile = new ClassPathResource("milakunis.gif");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_GIF)
                .body(bytes);
    }
}
