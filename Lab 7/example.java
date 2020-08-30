import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		example proj = new example();
		proj.createConnection();
	}
	
	void createConnection(){
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("exists");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ncp", "root", "root");
			Statement stmt = con.createStatement();
			
			System.out.println("Query 1");
			//q1
			ResultSet rs = stmt.executeQuery("Select name, roll from students where cgpa > 8");
			while(rs.next())
			{
				String name = rs.getString("name");
				String roll = rs.getString("roll");
				System.out.println(name + " " + roll);
			}
			
			System.out.println();
			
			System.out.println("Query 2");
			//q2
			rs = stmt.executeQuery("Select roll from students where company = 'Infosys'");
			while(rs.next())
			{
				String roll = rs.getString("roll");
				System.out.println(roll);
			}
			
			System.out.println();
			System.out.println("Query 3");
			//q3
			rs = stmt.executeQuery("Select * from students ORDER BY roll");
			while(rs.next())
			{
				String roll = rs.getString("roll");
				System.out.println(roll);
			}
		}
		catch (SQLException ex) {
			System.out.println(ex);
		}
	}

}
