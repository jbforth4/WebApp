package hello;

import org.h2.tools.Server;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class FormController {

    private Person person;

    @RequestMapping(value = "/signup.html/form", method = RequestMethod.POST)
    public ResponseEntity<Person> signUpForm(@ModelAttribute Person person) throws SQLException, ClassNotFoundException {
        this.person = person;

        System.out.println(person.toString());

        Connection conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");

        String query = "INSERT INTO REGISTRATION (firstname,lastname,email_addr)"
                + " VALUES (?, ?, ?)";

        try {
            // set all the preparedstatement parameters
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, person.getFirstName());
            st.setString(2, person.getLastName());
            st.setString(3, person.getEmail());

            // execute the preparedstatement insert
            st.executeUpdate();
            st.close();
        } catch (SQLException se) {
            // log exception
            throw se;
        }
        conn.close();
        return new ResponseEntity<>(person, HttpStatus.OK);
    }



}
