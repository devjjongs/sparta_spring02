package com.sparta.week02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 데이터베이스 기준으로 테이블임을 나타냅니다.
public class Course extends Timestamped {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;    //  데이터베이스에서 설정하기 때문에 Getter/Setter 설정 안함

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String tutor;


    /*Getter 생성*/
//    public Long getId() {
//        return this.id;
//    }
//
//    public String getTitle() {
//        return this.title;
//    }
//
//    public String getTutor() {
//        return this.tutor;
//    }


    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    //  Course update
    public void update(CourseRequstDTO requstDTO) {
        this.title = requstDTO.getTitle();
        this.tutor = requstDTO.getTutor();
    }
}