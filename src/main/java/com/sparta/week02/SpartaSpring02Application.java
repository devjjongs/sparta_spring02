package com.sparta.week02;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpartaSpring02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpartaSpring02Application.class, args);
    }

    // Week02Application.java 의 main 함수 아래에 붙여주세요.
    @Bean
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
            }
        };
    }   //  실제로 프로젝트에서 사용하지 않음, 이해를 위해 작성된 코드
}
