package hello;

import org.h2.engine.User;

import java.sql.*;

public class DataBase {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public void addUser(User user, Connection conn)
            throws SQLException {
        String query = "INSERT INTO REGISTRATION ("
                + " user_id,"
                + " firstname,"
                + " lastname,"
                + " email_addr,"
                + " VALUES ("
                + "null, ?, ?, ?)";

        try {
            // set all the preparedstatement parameters
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, user.getName());
            st.setString(2, user.getFirstName());
            st.setString(3, user.getLastName());
            st.setString(4, user.getCompanyName());
            st.setString(5, user.getEmail());

            // execute the preparedstatement insert
            st.executeUpdate();
            st.close();
        } catch (SQLException se) {
            // log exception
            throw se;
        }
    }
}
