package tekrarlar;

import java.sql.*;

public class Ex01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/deneme", "postgres", "Yan.1qaz");

        Statement st = con.createStatement();

        String st1 = "CREATE TABLE ogrenci(ogr_no INT, ogr_sube VARCHAR(5), ogr_ad VARCHAR(50), ogr_soyad VARCHAR(50))";
        try {
            st.execute(st1);
        } catch (SQLException e) {
            System.out.println("Tablo zaten var");
        }
        //  String st2 = "INSERT INTO ogrenci VALUES(127,'10-A', 'sedat', 'kurnali')";
        //  st.execute(st2);
        //  String st3 = "INSERT INTO ogrenci VALUES(125,'10-D', 'Osman', 'Sevinc')";
        //  st.execute(st3);
        //  String st4 = "INSERT INTO ogrenci VALUES(135,'9-C', 'Recep', 'Kardes')";
        //  st.execute(st4);
        //  String st5 = "INSERT INTO ogrenci VALUES(165,'5-B', 'ismail', 'kaya')";
        //  st.execute(st5);
        //  String st6 = "INSERT INTO ogrenci VALUES(157,'6-S', 'Hakan', 'Sanli')";
        //  st.execute(st6);
        //  String st7 = "INSERT INTO  ogrenci VALUES (152,'7-C', 'Tahsin', 'Kirimli')";
        //  st.execute(st7);
        //1) Numarasi 135 olan ogrencinin tum bilgilerini getiren bir sql kodu yaziniz.
        String str1 = "select * from ogrenci where ogr_no=135 ";
        ResultSet rs1 = st.executeQuery(str1);
        while (rs1.next()) {
            System.out.println(rs1.getString("ogr_no") + " " + rs1.getString("ogr_sube") +
                    " " + rs1.getString("ogr_ad") + " " + rs1.getString("ogr_soyad"));
        }
        //2) Soyadi "kaya" olan ogrencinin numarisini 199 olarak guncelleyelim.
        String str2 = "update ogrenci set ogr_no=199 where ogr_soyad='kaya'";
        st.execute(str2);
        //3) Isminin 2.harfi "s" ve 4. harfi "a" olan ogrecinin bilgilerini getiren sorgu yaziniz.
        String str3 = "select * from ogrenci where ogr_ad ilike '_s_a%' ";
        ResultSet rs3 = st.executeQuery(str3);

        while (rs3.next()) {
            System.out.println(rs3.getString("ogr_no") + " " + rs3.getString("ogr_sube") +
                    " " + rs3.getString("ogr_ad") + " " + rs3.getString("ogr_soyad"));
        }
        con.close();
        st.close();
    }
}
