package org.example.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter // 모든 필드의 Getter 생성
@NoArgsConstructor // 기본 constructor 자동 추가 (public Post(){} 와 동일)
@Entity // 테이블과 링크될 클래스임을 나타냄
public class Posts {

    // Id: PK, GeneratedValue: PK 생성 규칙 (IDENTITY: auto increment)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Column 어노테이션을 굳이 선언하지 않더라도
    // 해당 클래스의 필드는 모두 칼럼이 된다. 옵션을 변경하고자 할 때 사용
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
