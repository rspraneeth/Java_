<<<<<<< HEAD
import java.sql.*;
public class mysqlex {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net/sql6525025", "sql6525025", "eIeAElM33L");
            System.out.println("Connection is successful "+con);
//            Statement st = con.createStatement();
//            String sql = "CREATE TABLE COMPANY " +
//                    "(ID INT PRIMARY KEY NOT NULL," +
//                    "NAME TEXT NOT NULL," +
//                    "AGE INT NOT NULL," +
//                    "ADDRESS CHAR(50)," +
//                    "SALARY REAL)";
//            st.executeUpdate(sql);
//            sql = "INSERT INTO COMPANY values(1, 'RSP', 25, 'mmd', 150000)";
//            st.executeUpdate(sql);
//            st.close();
            DatabaseMetaData dmd = con.getMetaData();
            System.out.println(dmd.getDriverName()+" "+dmd.getDriverVersion()+" "+dmd.getDatabaseProductName());
            String[] type = {"TABLE"};
            ResultSet rs = dmd.getTables(null, null, null, type);
            while(rs.next())
                System.out.println("table: "+rs.getString(3));
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
=======
import java.sql.*;
public class mysqlex {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net/sql6525025", "sql6525025", "eIeAElM33L");
            System.out.println("Connection is successful "+con);
//            Statement st = con.createStatement();
//            String sql = "CREATE TABLE COMPANY " +
//                    "(ID INT PRIMARY KEY NOT NULL," +
//                    "NAME TEXT NOT NULL," +
//                    "AGE INT NOT NULL," +
//                    "ADDRESS CHAR(50)," +
//                    "SALARY REAL)";
//            st.executeUpdate(sql);
//            sql = "INSERT INTO COMPANY values(1, 'RSP', 25, 'mmd', 150000)";
//            st.executeUpdate(sql);
//            st.close();
            DatabaseMetaData dmd = con.getMetaData();
            System.out.println(dmd.getDriverName()+" "+dmd.getDriverVersion()+" "+dmd.getDatabaseProductName());
            String[] type = {"TABLE"};
            ResultSet rs = dmd.getTables(null, null, null, type);
            while(rs.next())
                System.out.println("table: "+rs.getString(3));
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
>>>>>>> 60b1da746cb3440256dadea1bfca50f686ca69ba
