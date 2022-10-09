
import java.sql.*;

public class TransactionEx {
    public static void main(String[] args) throws Exception {
        String q1 = "insert into actor values(204, 'rsp', 'satya', '2022-10-09 10:17:33')";
        String q2 = "insert into actor values(205, 'praneeth', 'rsp', '2022-10-09 10:17:33')";
        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "password");
            System.out.println("Connection established . . . ");

            c.setAutoCommit(false); // false means unless you commit, no query will be executed

            Statement st = c.createStatement();
            st.executeUpdate(q1);
            st.executeUpdate(q2);
            c.commit();

            st.close();
            c.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("In catch exception... transaction will rollback");
            assert c != null;
            c.rollback();
        }

    }
}
