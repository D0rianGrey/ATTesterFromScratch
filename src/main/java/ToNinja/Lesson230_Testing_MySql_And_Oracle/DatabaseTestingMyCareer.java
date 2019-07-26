package ToNinja.Lesson230_Testing_MySql_And_Oracle;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.sql.*;

public class DatabaseTestingMyCareer {
    static Connection conn = null;
    private static Statement stmt;
    private static ResultSet results = null;
    public static String DB_URL = "jdbc:mysql://admin.vmdcs.cistest.local/ss_ps_db?autoReconnect=true&useSSL=false";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "Install_new!";
    public static String driver = "com.mysql.jdbc.Driver";

    @BeforeClass
    public void beforeClass() {

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connected database successfully...");
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws SQLException {
        String query = "SELECT * FROM users WHERE id = 24053";

        try {
            results = stmt.executeQuery(query);
            while (results.next()) {
                int id = results.getInt("id");
                String userName = results.getString("user_name");
                String firstName = results.getString("first_name");
                String lastName = results.getString("last_name");
                System.out.println("ID: " + id);
                System.out.println("User Name: " + userName);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                Assert.assertEquals(userName,"ovezd");
            }
            results.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void afterClass() {
        try {
            if (results != null)
                results.close();
            if (stmt != null)
                conn.close();
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}