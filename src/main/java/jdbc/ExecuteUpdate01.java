package jdbc;

import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "$3dA+Kurnal1");
        Statement st = con.createStatement();
        // 1. Ornek: number_of_employees degeri ortalama calisan sayisindan
        // az olan number_of_employees degerlerini 16000 olarak UPDATE edin.

        String sql1 = "UPDATE companies\n" +
                "SET number_of_employees = 16000\n" +
                "WHERE number_of_employees < (SELECT AVG(number_of_employees)\n" +
                "                             FROM companies);";
        int updateSatirSayisi = st.executeUpdate(sql1);
        System.out.println("updateSatirSayisi = " + updateSatirSayisi);

        String sql2 = "SELECT * FROM companies;";
        ResultSet result2 = st.executeQuery(sql2);
        int count = 1;
        while (result2.next()) {
            System.out.printf("%-2d %-4d %-15S %-10d\n",count,result2.getInt(1),result2.getString(2),result2.getInt(3));
            count++;
        }
        st.close();
        con.close();

    }
}
