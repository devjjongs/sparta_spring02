package com.sparta.week02;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.domain.CourseRequstDto;
import com.sparta.week02.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class SpartaSpring02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpartaSpring02Application.class, args);
    }

    // Week02Application.java 의 main 함수 아래에 붙여주세요.
    /*@Bean
    public CommandLineRunner demo(CourseRepository repository) {
        return (args) -> {

            //  jpa 사용법 작성
            //  생성 및 입력
            Course course1 = new Course("웹 개발의 봄 Spring", "남병관");
            repository.save(course1);

            //  조회
            List<Course> courseList = repository.findAll();
            for (int i = 0; i < courseList.size(); i++) {
                Course c = courseList.get(i);
                System.out.println(c.getTitle());   //  저장된 타이틀
                System.out.println(c.getTutor());   //  저장된 튜터
            }   //  실제로 프로젝트에서 사용하지 않음, 이해를 위해 작성된 코드

            // 데이터 저장하기
            repository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));

            // 데이터 전부 조회하기
            List<Course> courseList = repository.findAll();
            for (int i = 0; i < courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            // 데이터 하나 조회하기
            Course course = repository.findById(1L).orElseThrow(    //  .orElseThrow : 오류를 캐치해서 어떻게 할지 알려주는 역할
                    () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
                    //() -> new NullPointerException("해당 아이디가 존재하지 않습니다.") 사용 가능
            );  //  ID가 존재하지 않을 경우 ("해당 아이디가 존재하지 않습니다.")라는 메시지를 표시하도록 하는 명령
        };
    }*/     //  테이블 생성 및 등록 후 조회

    /*@Bean
    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
        return (args) -> {
            courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));  //  데이터 저장

            System.out.println("데이터 인쇄");
            List<Course> courseList = courseRepository.findAll();
            for (int i=0; i<courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }   //  저장된 데이터 출력

            Course new_course = new Course("웹개발의 봄, Spring", "임민영");
            courseService.update(1L, new_course);
            courseList = courseRepository.findAll();
            for (int i=0; i<courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }   //  기존 저장된 데이터의 코스명 수정
        };
    }*/     //  데이터 저장 및 수정

    @Bean
    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
        return (args) -> {
            courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));

            System.out.println("데이터 인쇄");
            List<Course> courseList = courseRepository.findAll();
            for (int i = 0; i < courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            CourseRequstDto requstDto = new CourseRequstDto("웹개발의 봄, Spring", "임민영");
            courseService.update(1L, requstDto);
            courseList = courseRepository.findAll();

            for (int i = 0; i < courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            courseRepository.deleteAll();   //  전체 삭제
        };
    }     //  데이터 출력 및 삭제
}
