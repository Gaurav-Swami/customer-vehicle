package vehicles;

import java.sql.*;
import static printing.Printing.*;

public class AddVehicle {

    public static void main(String args[]) {
        String databasePath = "C:/Users/gaura/VM/VM/javadatabase.mdb";
        String url = "jdbc:ucanaccess://" + databasePath;

        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement checkCustomer = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url);

            int vid = inputInt("Enter the id");
            String v_no = input("Enter the vehicle number");
            int customerId = inputInt("Enter the CustomerId");
            String make = input("Enter the make");
            String model = input("Enter the model");
            int year = inputInt("Enter the year");

            checkCustomer = conn.prepareStatement("select count(*) from customers where customerid = ?");
            checkCustomer.setInt(1, customerId);
            rs = checkCustomer.executeQuery();
            rs.next();
            int customerCount = rs.getInt(1);

            if (customerCount == 0) {
                println("Customer Id does not exist");
                return;
            }

            pstmt = conn
                    .prepareStatement("insert into vehicle(vid,v_no,customerid,make,model,year) values (?,?,?,?,?,?);");

            pstmt.setInt(1, vid);
            pstmt.setString(2, v_no);
            pstmt.setInt(3, customerId);
            pstmt.setString(4, make);
            pstmt.setString(5, model);
            pstmt.setInt(6, year);

            int val = pstmt.executeUpdate();
            if (val > 0) {
                println("Rows Inserted");
            } else {
                println("An error occured");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (checkCustomer != null) {
                    checkCustomer.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}