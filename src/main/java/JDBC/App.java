package JDBC;

/**
 * Hello world!
 *
 */
import java.sql.*;

import static java.lang.Class.forName;

public class App
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/JdbcDemo";
        String userName="root";
        String password="Sonu";

        String query="select * from users";
        String query1="insert into users values(4,'radha','radha@gmail.com')";
        String query3="insert into users values(?,?,?)";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, userName, password);
                // using Statement
//            Statement smt = con.createStatement();
//           // ResultSet rs = smt.executeQuery(query); for fetching the users
//            int rs=smt.executeUpdate(query1);
//            while (rs.next()) {
//                System.out.println(rs.getInt("id") +" "+ rs.getString("username") +" "+ rs.getString("email"));
//            }
//            System.out.println(rs);
            //prepared statement for inserting
//            PreparedStatement smt=con.prepareStatement(query3);
//            smt.setInt(1,5);
//            smt.setString(2,"Laxmi");
//            smt.setString(3,"laxmi@gmail.com");
//            int rs=smt.executeUpdate();
            //prepare statement for deleting particular row
            String delte="delete from users where username='ramu'";
            PreparedStatement smt=con.prepareStatement(delte);
            int rs=smt.executeUpdate();
            System.out.println(rs);
            smt.close();
            con.close();
        } 
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
