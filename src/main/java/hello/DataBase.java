package hello;

import org.h2.engine.User;
import org.springframework.context.annotation.Bean;

import java.sql.*;

public class DataBase {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public void addPerson(Person person) throws SQLException {

        Connection conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");

        String insert = "INSERT INTO REGISTRATION (firstname,lastname,email_addr)"
                + " VALUES (?, ?, ?)";

        try {
            // set all the preparedstatement parameters
            PreparedStatement st = conn.prepareStatement(insert);
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
    }

}
