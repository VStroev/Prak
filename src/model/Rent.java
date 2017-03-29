package model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "rent")
public class Rent {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rent_id")
	private Integer id;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	@OneToOne
	@JoinColumn(name = "copy_id")
	private Copy copy;
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@Column(name = "payed")
	private Integer payed;


	public Integer getId (){
		return id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public Copy getCopy() {
		return copy;
	}
	public Customer getCustomer() {
		return customer;
	}
	public Integer getPayed() {
		return payed;
	}

	public void setId(Integer id){
		this.id = id;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setCopy(Copy copy) {
		this.copy = copy;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setPayed(Integer payed) {
		this.payed = payed;
	}
}
