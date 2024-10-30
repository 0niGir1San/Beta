package com.demoqa.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter

public class PracticeFormEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String subjects;
    private String selectPicture;
    private String currentAddress;
    private String date;
    private String state;
    private String city;
}