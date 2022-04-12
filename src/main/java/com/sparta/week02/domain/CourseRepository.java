package com.sparta.week02.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// SQL 역할을 대신 해주는 인터페이스 클래스
// interface : 클래스에서 멤버가 빠진, 메소드 모음집
public interface CourseRepository extends JpaRepository<Course, Long> { //  <Course, Long> : Course 클래스의 Id 형식이 Long
}
//  CourseRepository : sql을 대신하는 역할, Course에 관한 Repository이다
//  extends : 클래스의 상속 [뒤에 있는 다른 기능을 가져와서 사용] (이미 있는거 가져다 쓰자의 의미)
//  JpaRepository<클래스명, 식별자 자료형>

//  interface : 클래스에서 멤버가 빠진, 메소드 모음집