package com.sparta.week02.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor //  생성자를 자동 생성해주는 롬복 어노테이션
public class CourseRequstDto {

    private final String title;
    private final String tutor;
}
