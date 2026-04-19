package haruto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetStatus {

    public static List<DailyTotal> loadDailyTotals(DbConfig config, String userId) {
        List<DailyTotal> list = new ArrayList<>();

        String sql = """
            SELECT DATE(created_at) AS day, SUM(amount) AS total
            FROM records
            WHERE user_id = ?
            GROUP BY day
            ORDER BY day
        """;
        try (Connection conn = DriverManager.getConnection(config.jdbcUrl(),config.username(),config.password());
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new DailyTotal(
                            rs.getString("day"),   
                            rs.getInt("total")
                    ));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("日別合計の取得に失敗", e);
        }

        return list;
    }
}
