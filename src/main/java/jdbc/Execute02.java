package jdbc;

import java.sql.*;

public class Execute02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "$3dA+Kurnal1");
        Statement st = con.createStatement();

        // 1. Ornek: region_id 'si 1 olan "county name"  degerlerini cagirin.
        String sql1 = " SELECT country_name FROM countries where region_id =1";
        boolean r1 = st.execute(sql1);
        System.out.println(r1); // true yada false veririr. Cunku data cagirma islemi yaptik

        // Recordlari gormek icin executeQuery() methodu kullaniyoruz.
        ResultSet result1 = st.executeQuery(sql1);
        while (result1.next()) {
            System.out.println(result1.getString("country_name"));
        }
        // //2.Ornek: "region_id"nin 2'den buyuk olduğu "country_id" ve "country_name" degerlerini cagırın.
        String sql2 = " SELECT country_id, country_name FROM countries where region_id > 2";
        ResultSet result2 = st.executeQuery(sql2);
        while (result2.next()) {
            System.out.println(result2.getString("country_id") + " --> " + result2.getString("country_name"));
        }
        //3.Example: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.
        String sql3 = " SELECT *  FROM companies WHERE number_of_employees = (SELECT MIN (number_of_employees)  FROM companies) ";
        ResultSet result3 = st.executeQuery(sql3);
        while (result3.next()) {
            System.out.println(result3.getString("company_id") + " -- " +
                    result3.getString("company") + " -- " +
                    result3.getString("number_of_employees"));
        }
    }
}
