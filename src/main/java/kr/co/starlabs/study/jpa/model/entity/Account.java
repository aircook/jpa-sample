package kr.co.starlabs.study.jpa.model.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String username;

	private String password;

	private Integer age;

	//하이버네이트 5.2부터 hibernate-java8 의존성 추가 필요 없이 Java 8 날짜와 시간을 사용할 수 있다.
	//@Temporal(TemporalType.TIMESTAMP)
	//@LastModifiedDate
	private LocalDateTime created = LocalDateTime.now();

	@Embedded
	private Address address;

	//양방향 관계를 정의할때는 관계의 주인의 반대편인 @OneToMany에 mappedBy를 항상 정의해야 한다.
	@OneToMany(mappedBy = "owner")
	private Set<Study> studies = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Study> getStudies() {
		return studies;
	}

	public void setStudies(Set<Study> studies) {
		this.studies = studies;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", created="
				+ created + ", address=" + address + ", studies=" + studies + "]";
	}

}
