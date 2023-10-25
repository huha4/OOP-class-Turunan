/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mahasiswa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mahasiswa {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/Pbo_keempat";
    static final String USER = "postgres";
    static final String PASS = "5432";
    static final String QUERY = "SELECT * FROM mahasiswa";

    public static void main(String[] args) {
        // TODO code application logic here
        try ( Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(QUERY);) {
            while (rs.next()) {
                //Display values
                System.out.println("NIM: " + String.valueOf(rs.getObject(1)));
                System.out.println("Nama mahasiswa: " + String.valueOf(rs.getObject(2)));
                System.out.println("Alamat: " + String.valueOf(rs.getObject(3)));
                System.out.println("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
