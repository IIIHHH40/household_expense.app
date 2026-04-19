package haruto;

import org.json.JSONObject;

public class JdbcUtil {
   //Secrets Managerから取ってきたJSON文字列をJavaの形に変換する
    public static DbConfig parseSecret(String secretJson) {
        JSONObject json = new JSONObject(secretJson);
        String host     = json.getString("host");
        String dbname   = json.getString("dbname");
        String username = json.getString("username");
        String password = json.getString("password");
        int port        = json.getInt("port");
        String jdbcUrl=String.format(
                "jdbc:mysql://%s:%d/%s?useSSL=false&serverTimezone=UTC",
                host,port,dbname
        );
        return new DbConfig(host, dbname, username, password, port,jdbcUrl);
    }
}
