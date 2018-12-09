package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class SqliteJdbc {

	public Connection connect() {
		String url = "jdbc:sqlite:e:/proxy.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;

	}

	public void createNewTable() {
		// SQLite connection string
		String url = "jdbc:sqlite:e:/proxy.db";

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS proxy (\n" + "	id integer PRIMARY KEY,\n"
				+ "	ip text unique NOT NULL,\n" + "	port text NOT NULL,\n" + "	priority integer Default 0,\n"
				+ "	deleteflag boolean Default false,\n" + "	updated datetime\n" + ");";
		try (Connection conn = this.connect(); Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insert(String ip, String port, LocalDateTime date) {
		String sql = "INSERT INTO proxy(ip,port,updated) VALUES(?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, ip);
			pstmt.setString(2, port);
			pstmt.setTimestamp(3, Timestamp.valueOf(date));
			int result = pstmt.executeUpdate();
			if (result > 0)
				System.out.println("insert successfully.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean update(String ip, int priority, boolean delelteFlg, LocalDateTime date) {
		String sql = "UPDATE proxy  SET priority=?, deleteFlag=?, updated=? WHERE ip=?;";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, priority);
			pstmt.setBoolean(2, delelteFlg);
			pstmt.setTimestamp(3, Timestamp.valueOf(date));
			pstmt.setString(4, "192.168.2.1");
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Timestamp showUpdated(String ip) {
		String sql = "SELECT updated from proxy where ip =?";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "192.168.2.1");
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Timestamp t = result.getTimestamp(1);
				LocalDateTime dt = LocalDateTime.ofInstant(Instant.ofEpochMilli(t.getTime()), ZoneId.systemDefault());
				System.out.println("show udpate:" + dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return Timestamp.valueOf(LocalDateTime.now());
	}

	public boolean deleteProxy(String ip) {
		String sql = "DELETE from proxy where ip =?";
		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, ip);
			int result = pstmt.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	public static void main(String[] args) {
		SqliteJdbc sqlJdbc = new SqliteJdbc();
		// sqlJdbc.connect();
		sqlJdbc.createNewTable();
		sqlJdbc.insert("192.168.2.1", "8080", LocalDateTime.now());
		System.out.println(LocalDateTime.now());
		// sqlJdbc.update("192.168.2.1", 2, false, LocalDateTime.now());
		// sqlJdbc.showUpdated("192.168.2.1");
		System.out.println(sqlJdbc.deleteProxy("192.168.2.1"));

	}
}
