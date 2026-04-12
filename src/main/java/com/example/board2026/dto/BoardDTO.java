// DTO(Data Transfer Object): 데이터를 전송하는 객체 (데이터를 주고 받자는 의미)
package com.example.board2026.dto;
import lombok.*;
import java.time.LocalDateTime;

@Getter // get 메서드 자동
@Setter // set 메서드 자동
@ToString
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자

public class BoardDTO {
    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits; // 조회수
    private LocalDateTime boardCreatedTime; // 게시글 생성
    private LocalDateTime boardUpdatedTime; // 게시글 수정


}
