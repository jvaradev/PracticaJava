package practicaAccesoDatos.ejercicio02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio02 {

	private static String CONEXION = "jdbc:mysql://localhost/sakila";
	private static String USER_NAME = "root";
	private static String PASSWORD = "password";
	private static String SENTENCIA_SQL = "SELECT c.customer_id, c.first_name, c.last_name, a.phone, c.active, c.create_date\r\n"
			+ "from customer c join address a on c.address_id = a.address_id;";
	private static File FILE_CUSTOMER = new File("D:\\Practica\\mariaDb\\src\\informes\\ARRAY_CUSTOMERS.txt");

	public static void main(String[] args) throws IOException {

		List<Customer> listCustomer = new ArrayList<>();

		fileCreater();

		try (Connection conn = DriverManager.getConnection(CONEXION, USER_NAME, PASSWORD)) {

			try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(SENTENCIA_SQL)) {
				try (FileWriter fw = new FileWriter(FILE_CUSTOMER)) {

					while (rs.next()) {

						int customerId = rs.getInt(1);
						String customerFName = rs.getString(2);
						String customerLName = rs.getString(3);
						String customerPhone = rs.getString(4);
						int customerActive = rs.getInt(5);
						Date createDate = rs.getDate(6);

						Customer c = new Customer(customerId, customerFName, customerLName, customerPhone,
								customerActive, createDate);

						listCustomer.add(c);

					}
					
					for (Customer customer : listCustomer) {
						fw.write(customer.toString());
						fw.write("\n");
					}
					
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}

				System.out.println("Fichero creado.");

			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("No se pudo realizar la sentencia.");
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("No se pudo establecer la conexión.");
		}

	}

	private static void fileCreater() throws IOException {
		if (!FILE_CUSTOMER.exists()) {
			FILE_CUSTOMER.createNewFile();
		}
	}

}
