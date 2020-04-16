package guru.springframework.spring5webapp.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String mane;
	private String addressLine1;
	private String city;
	private String state;
	private String zip;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "publisher_id")
	private Set<Book> books = new HashSet<>();
	
	public Publisher() {
		// TODO Auto-generated constructor stub
	}
	public Publisher(String mane, String addressLine1, String city, String state, String zip) {
		super();
		this.mane = mane;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMane() {
		return mane;
	}
	public void setMane(String mane) {
		this.mane = mane;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	@Override
	public int hashCode() {
		
		return id !=null?id.hashCode():0;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Publisher))
			return false;
		Publisher other = (Publisher) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
