package kr.co.starlabs.study.jpa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CommentDto {

	@Data
	@AllArgsConstructor
	public static class ListInfo {
		
		private Long id;

		private String title;

		private Long postId;

		private String postTitle;
		
	}

}
