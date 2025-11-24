package Odevler;

import java.sql.*;

public class MainPrepared {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test_db";
        String user = "root";
        String password = "123456";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Veritabanına bağlandı!");

            // INSERT
            String insertSQL = "INSERT INTO deniz_yazici (ad, soyad, pozisyon, maas) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, "Nehir");
            pstmt.setString(2, "Yazıcı");
            pstmt.setString(3, "QA Engineer");
            pstmt.setDouble(4, 18000.00);
            pstmt.executeUpdate();

            // SELECT
            String selectSQL = "SELECT * FROM deniz_yazici";
            ResultSet rs = conn.createStatement().executeQuery(selectSQL);
            System.out.println("---- Personel Tablosu ----");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("ad") + " " +
                                rs.getString("soyad") + " | " +
                                rs.getString("pozisyon") + " | " +
                                rs.getDouble("maas")
                );
            }

            // DELETE
            String deleteSQL = "DELETE FROM deniz_yazici WHERE ad = ?";
            PreparedStatement delPstmt = conn.prepareStatement(deleteSQL);
            delPstmt.setString(1, "Nehir");
            delPstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
