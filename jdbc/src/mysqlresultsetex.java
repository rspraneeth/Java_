import java.sql.*;

public class mysqlresultsetex {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "password");
            System.out.println("Connection established");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from actor;");
            ResultSetMetaData rmd = rs.getMetaData();
            System.out.println("No of columns in table "+rmd.getTableName(1)+" are: "+rmd.getColumnCount()+".");
            for (int i = 1; i <= rmd.getColumnCount(); i++)
                System.out.println("Column name is "+rmd.getColumnName(i)+" and type is "+rmd.getColumnTypeName(i));
            while (rs.next())
                System.out.println("Actor id is "+rs.getInt("actor_id")+" and name is "+rs.getString(2));
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
