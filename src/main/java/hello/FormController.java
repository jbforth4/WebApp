package hello;

import org.h2.tools.Server;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
public class FormController {

    private Person person;

    @RequestMapping(value = "/signup.html/form", method = RequestMethod.POST)
    public ResponseEntity<Person> signUpForm(@ModelAttribute Person person) throws SQLException, ClassNotFoundException {
        this.person = person;

        System.out.println(person.toString());

//        Connection conn = DriverManager.getConnection ("jdbc:h2:~/form", "sa","");
//        Statement st = conn.createStatement();
//
//        String sql = ("INSERT INTO REGISTRATION ("
//                        + " person.getId() + ", " +
//                        person.getFirstName() + ", " +
//                        person.getLastName() + ", " +
//                        person.getEmail() + ")");
//
//        st.executeUpdate(sql);
//
//        conn.close();
        return new ResponseEntity<>(person, HttpStatus.OK);
    }



}
