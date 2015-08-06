import java.sql.*;

public class Pretest {

    public static void main(String args[])
            throws SQLException, ClassNotFoundException {
        String jdbcdriver = "org.opencloudb.jdbc.mongodb.MongoDriver";
        String jdbcurl = "mongodb://localhost:27017/events";
        String username = "";
        String password = "";
        Class.forName(jdbcdriver);
        Connection c = DriverManager.getConnection(jdbcurl, username, password);
        Statement st = c.createStatement();
        print(st.executeQuery("select restaurant_id, name as restaurant_name from restaurants LIMIT 10"));
    }

    static void print(ResultSet res)
            throws SQLException {
        ResultSetMetaData meta = res.getMetaData();
        String str = "";
        for (int i = 1; i <= meta.getColumnCount(); i++) {
            str += meta.getColumnName(i) + "   ";
        }
        System.out.println("\t" + str);
        str = "";
        while (res.next()) {
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                str += res.getString(i) + "   ";
            }
            System.out.println("\t" + str);
            str = "";
        }
    }
}
