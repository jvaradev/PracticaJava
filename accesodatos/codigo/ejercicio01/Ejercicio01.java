package practicaAccesoDatos.ejercicio01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio01 {

	private static String CONEXION = "jdbc:mysql://localhost/sakila";
	private static String USER_NAME = "root";
	private static String PASSWORD = "password";
	private static String SENTENCIA_SQL = "SELECT c.customer_id, c.first_name, c.last_name, a.phone, c.active, c.create_date\r\n"
										+ "from customer c join address a on c.address_id = a.address_id;";
	
	public static void main(String[] args) {
		
		List<Customer> customerList = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(CONEXION, USER_NAME, PASSWORD)){
			
			try (Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(SENTENCIA_SQL)){
				
				while (rs.next()) {
					int customerId = rs.getInt(1);
					String customerFName = rs.getString(2);
					String customerLName = rs.getString(3);
					String phoneNumber = rs.getString(4);
					int active = rs.getInt(5);
					Date createDate = rs.getDate(6);
					
					Customer c = new Customer(customerId, customerFName, customerLName, phoneNumber, active, createDate);
					
					customerList.add(c);
					
				}
				
				for (Customer customer : customerList) {
					System.out.println(customer.toString());
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("No se ha podido realizar la sentencia.");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("No se ha podido establecer conexión");
		}
		
	}
	
}
