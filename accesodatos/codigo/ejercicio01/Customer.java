package practicaAccesoDatos.ejercicio01;

import java.sql.Date;

public class Customer {

	private int customerId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private int active;
	private Date createDate;
	public Customer(int customerId, String firstName, String lastName, String phoneNumber, int active,
			Date createDate) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.active = active;
		this.createDate = createDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public int getActive() {
		return active;
	}
	public Date getCreateDate() {
		return createDate;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Customer [customerId=%s, firstName=%s, lastName=%s, phoneNumber=%s, active=%s, createDate=%s]",
				customerId, firstName, lastName, phoneNumber, active, createDate);
	}
	
	
	
}
