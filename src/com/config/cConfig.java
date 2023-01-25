package com.config;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class cConfig {
    // untuk mendefinisikan koneksi database kita
    private static final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final String DB_URL ="jdbc:mysql://localhost:3306/dbbarang2";
    private static final String USER = "root";
    private static final String PASS = ""; // untuk instalasi object dari class DriverManager dan Connection

    private static Connection connect;
    private static Statement statement;
    private static ResultSet resultData;

    private static void connection(){
        try {
            Class.forName(JDBC_DRIVER); // registrasi driver yang dipakai
            connect = DriverManager.getConnection(DB_URL,USER,PASS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getAllData(){
        cConfig.connection();
        String data ="Maaf data tidak ada"; // isi nilai default
        try {
            statement = connect.createStatement(); // buat objek statement yang ambil dari koneksi
            String query = "SELECT idBarang, namaBarang FROM tbl_barang"; // query nya
            resultData = statement.executeQuery(query); // eksekusi query nya
            data = ""; // set variable data jadi null

            // looping pengisian variable data
            while (resultData.next()){
                data += "ID Barang : "+resultData.getInt("idBarang")+"" +
                        ", Nama Barang : "+resultData.getString("namaBarang")+"\n";
            }
            statement.close();
            connect.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


}
