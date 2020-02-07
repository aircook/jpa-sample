package kr.co.starlabs.study.jpa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

public class CommentDto {

	@Data
	@AllArgsConstructor
	public static class ListInfo {
		
		private Long id;

		private String title;

		private Long postId;

		private String postTitle;
		
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor //model mapper에서는 필요
	public static class Info {
		
		private Long id;
		
		private String title;
		
		private Long postId;
		
	}
	
	//method query의 결과를 DTO에 바로 담는다.
	//@Value사용에 주의할 것
	//@NoArgsConstructor 이건 있으면 안되고, 왜 기본생성자가 있으면 안되는가? 그것참
	//@AllArgsConstructor @Getter 둘다 있으면 정상
	@Value
	public static class Info1 {

		private Long id;

		private String title;

		private Long postId;

	}
	
	
}
