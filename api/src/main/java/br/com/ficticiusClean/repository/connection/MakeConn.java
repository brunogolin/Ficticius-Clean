package br.com.ficticiusClean.repository.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("CONEXAO")
public class MakeConn {

	@Autowired
	@Qualifier("systemProperties")
	protected Properties systemProperties;

	@Value("${connection.server}")
	private String server;

	@Value("${connection.port}")
	private String port;

	@Value("${connection.database}")
	private String database;

	@Value("${connection.userid}")
	private String userid;

	@Value("${connection.password}")
	private String password;

	public Connection getLocalConnection() {

		Connection conn = null;

		try {

			if (server != null && !server.equals("")) {

				String contextLoc = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				String jdbc = "jdbc:sqlserver";
				String ds = jdbc + "://" + server + ":" + port + ";databaseName=" + database + ";user=" + userid + ";password=" + password;

				try {
					Class.forName(contextLoc);
					conn = DriverManager.getConnection(ds, userid, password);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				return conn;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

}
