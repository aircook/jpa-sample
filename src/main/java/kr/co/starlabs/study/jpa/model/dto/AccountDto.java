package kr.co.starlabs.study.jpa.model.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

//@Getter
public class AccountDto {

	//@Getter
	//@Setter
	//@AllArgsConstructor
	@Data
	public static class List {

		/*
		public List() {
		
		}
		
		public List(Account account) {
			this.id = account.getId();
			this.username = account.getUsername();
			this.password = account.getPassword();
			this.age = account.getAge();
			this.street = account.getAddress().getStreet();
			this.city = account.getAddress().getCity();
			this.state = account.getAddress().getState();
			this.zipCode = account.getAddress().getZipCode();
		}
		*/

		private Long id;

		private String username;

		private String password;

		private Integer age;

		private String addressStreet;

		private String addressCity;

		private String addressState;

		private String addressZipCode;

		@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
		private LocalDateTime created;
		
	}

}
