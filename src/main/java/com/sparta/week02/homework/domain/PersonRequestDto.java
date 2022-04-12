package com.sparta.week02.homework.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class PersonRequestDto {
    private final String name;
    private final String age;
    private final String address;
    private final String phone;
}
