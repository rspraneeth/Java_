import java.sql.*;

public class MysqlprepStmnt {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "password");
            System.out.println("Connection established...");
//            PreparedStatement ps = c.prepareStatement("select * from actor where actor_id = ?;");
//            ps.setInt(1, 12);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next())
//                System.out.println(rs.getInt(1)+" "+rs.getString(2));
            PreparedStatement ps1 = c.prepareStatement("insert into actor values(?, ?, ?, ?)");
            ps1.setInt(1, 201);
            ps1.setString(2, "Praneeth");
            ps1.setString(3, "Reddi");
            ps1.setTimestamp(4, Timestamp.valueOf("2022-10-09 10:17:33"));
            int i = ps1.executeUpdate();
            System.out.println("Row inserted: "+i);
            ps1.close();
            c.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}

