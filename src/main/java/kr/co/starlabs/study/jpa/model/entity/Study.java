package kr.co.starlabs.study.jpa.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Study {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	// 단방향에서의 관계의 주인은 명확하다. 관계를 정의한 쪽이 그 관계의 주인입니다.
	// Study가 관계의 주인
	@ManyToOne
	private Account owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getOwner() {
		return owner;
	}

	public void setOwner(Account owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Study [id=" + id + ", name=" + name + ", owner=" + owner + "]";
	}

}
