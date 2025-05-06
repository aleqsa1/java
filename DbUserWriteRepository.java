package Exercise1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUserWriteRepository implements UserWriteRepository{
	 String url = "jdbc:sqlserver://ALEQSA;databaseName=student;encrypt=true;trustServerCertificate=true";
	 String userW = "sa";
	 String password = "aleqsi2003";

	public void save(User user) {
		try (Connection con = DriverManager.getConnection(url, userW, password);
				Statement st = con.createStatement()) {
				String userName = user.getName();
				String email = user.getEmail();
				String sql = "INSERT INTO newUser (name, email) VALUES" + '(' + "'" + userName +"'" + ',' +"'" + email + "'" +')';
				st.executeUpdate(sql);
				System.out.println("Record inserted successfully.");
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

	public void update(User user) {
	    try (Connection con = DriverManager.getConnection(url, userW, password);
	         Statement st = con.createStatement()) {

	        Long id = user.getId();
	        String userName = user.getName();
	        String email = user.getEmail();
 
	        String sql = "UPDATE newUser SET name = '" + userName +"', email = '" + email + "' WHERE id = " + id;
	        st.executeUpdate(sql);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void delete(Long id) {
	    try (Connection con = DriverManager.getConnection(url, userW, password);
	         Statement st = con.createStatement()) {

	        String sql = "DELETE FROM newUser WHERE id = " + id;
	        st.executeUpdate(sql);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
