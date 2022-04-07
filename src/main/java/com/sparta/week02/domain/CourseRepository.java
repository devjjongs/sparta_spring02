package com.sparta.week02.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

//  CourseRepository : sql을 대신하는 역할, Course에 관한 Repository이다
//  extends : 상속 [뒤에 있는 다른 기능을 가져와서 사용]
//  JpaRepository<클래스명, 식별자 자료형>

//  interface : 클래스에서 멤버가 빠진, 메소드 모음집