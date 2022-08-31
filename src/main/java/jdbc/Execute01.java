package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1. Adim Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        // 2. Database'e baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "$3dA+Kurnal1");

        // 3. Statement olustur.
        Statement st = con.createStatement();

        // 4. Query calistir.
        //1. Ornek: "workers" adinda bir table olusturup "worker_id,worker_name, worker_salary" sutunlarını ekleyin.
        String sql1 = "CREATE TABLE workers (worker_id VARCHAR(50),worker_name VARCHAR(50), worker_salary INT)";

        boolean result = st.execute(sql1);

        System.out.println(result); // false veririr. Cunku data cagirmadi

    }

}
