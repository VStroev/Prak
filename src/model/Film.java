package model;

import java.sql.Date;



import javax.persistence.*;

@Entity
@Table(name = "film")
public class Film {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "company")
	private String company;
	@Column(name = "producer")
	private String producer;
	@Column(name = "cd_cost")
	private Integer cdCost;
	@Column(name = "cassette_cost")
	private Integer casetteCost;
	@Column(name = "year")
	private Date date;


	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCompany() {
		return company;
	}
	public String getProdusr() {
		return producer;
	}
	public Integer getCdCost() {
		return cdCost;
	}
	public Integer getCasetteCost() {
		return casetteCost;
	}
	public Date getDate() {
		return date;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public void setCdCost(Integer cdCost) {
		this.cdCost = cdCost;
	}
	public void setCasetteCost(Integer casetteCost) {
		this.casetteCost = casetteCost;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
