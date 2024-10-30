package com.demoqa.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Getter
@Setter

public class TextBoxEntity {

    private String fullName;
    private String email;
    private String currentAddress;
    private String permanentAddress;
    private String picturePath;
}
