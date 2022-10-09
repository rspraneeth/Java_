import java.sql.*;

public class postgresex {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection("jdbc:postgresql://rosie.db.elephantsql.com/ockuwjkc", "ockuwjkc", "e2Ktbku8wNh9WXjZg-oLIqJ1Go6OOD6Q");
            System.out.println("DB connection is success "+c);
//            Statement st = c.createStatement();
//            String sql = "CREATE TABLE COMPANY " +
//                    "(ID INT PRIMARY KEY NOT NULL," +
//                    "NAME TEXT NOT NULL," +
//                    "AGE INT NOT NULL," +
//                    "ADDRESS CHAR(50)," +
//                    "SALARY REAL)";
//            st.executeUpdate(sql);
//            String sql = "INSERT INTO COMPANY values(1, 'RSP', 25, 'mmd', 150000)";
//            st.executeUpdate(sql);
//            st.close();
            DatabaseMetaData dmd = c.getMetaData();
            System.out.println(dmd.getDriverName()+" "+dmd.getDriverVersion()+" "+dmd.getDatabaseProductName());
            String[] type = {"TABLE"};
            ResultSet rs = dmd.getTables(null, null, null, type);
            while (rs.next())
                System.out.println("table: "+rs.getString(3));
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
