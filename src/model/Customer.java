package model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "surname")
	private String surname;
	@Column(name = "patronymic")
	private String patronymic;
	@Column(name = "address")
	private String address;
	@Column(name = "phone")
	private String phone;


	public Integer getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getSurname() {
		return surname;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
