package model;





import javax.persistence.*;

@Entity
@Table(name = "copy")
public class Copy {

	@Id @GeneratedValue
	@Column(name = "copy_id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "film_id")
	private Film film;
	@Column(name = "type")
	private boolean isCd;

	
	public Integer getId (){
		return id;
	}
	public Film getFilm() {
		return film;
	}
	public boolean isCd() {
		return isCd;
	}

	public void setId(Integer id){
		this.id = id;
	}
	public void setType(boolean type) {
		this.isCd = type;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
}

