package MyDatabase;
//1  ນຳເຂົ້າ package sql

import java.sql.*;

public class ConnectDB {

    //2 ສ້າງ Method ທີ່ໄວນຳໃຊ້ເຊື່ອມຕໍ່ກັບຖານຂໍ້ມນູ (getDB)
    public static Connection getDB() {
        // 3 ດັກຈັບຂໍ້ຜິດພາດ try catch 
        try {
            // 4 ສ້າງຕົວປ່ຽນເກັບຂໍ້ມູນການເຊື່ອມຕໍ່
            // 4.1 ເກັບຮູບແບບການເຊື່ອມຕໍ່ Driver
            String driver = "com.mysql.jdbc.Driver";
            // 4.2 ເກັບ host ຂອງເຄື່ອງ server (IP)
            String server = "localhost";
            // 4.3 ເກັບ User ຂອງເຄື່ອງ Server
            String user = "root";
            //4.4 ເກັບ Password ຂອງເຄື່ອງ Server
            String password = "@min2020";
            //4.5 ເກັບ ຊື່ Database ທີ່ຕ້ອງການເຊື່ອມຕໍ່
            String database = "db_user";
            //4.6 ເກັບຮູບແບບການຮັບສົ່ງຮອງຮັບພາສາລາວ
            String utf8 = "?useUnicode=yes&charactorEncoding=UTF-8";
            //4.7 ສ້າງ url ໃນການເຊື່ອມຕໍ່ຖານຂໍ້ມູນ
            String url = "jdbc:mysql://" + server + "/" + database + utf8;
            //5 ກຳນົດ Driver
            Class.forName(driver);
            //6 ສ້າງການເຊື່ອມຕໍ່ກັບຖານຂໍ້ມູນ
            Connection con = DriverManager.getConnection(url, user, password);
            //7 ສົ່ງອອກການເຊື່ອມຕໍ່
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ສ້າງ Method ກວດສອບຖານເຊື່ອມຕໍ່
    public static boolean checkDB() {
        if (ConnectDB.getDB() == null) {
            System.out.println("Connect Lose");
            return false;
        } else {
            System.out.println("Connected");
            return true;
        }
    }
    
    //ໝາຍເຫດ: ຕ້ອງເພີ່ມ Library (mysql-connector) 
    // 1.ຄິກຂວາໃສ່ Libraries > add JAR/Folder
    // 2. ເລືອກເອົາ mysql-connector.jar ກົດ OK
}
