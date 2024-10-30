package com.demoqa.utils;

import com.demoqa.entities.EmployeeEntity;
import com.demoqa.entities.PracticeFormEntity;
import com.demoqa.entities.TextBoxEntity;
import com.github.javafaker.Faker;

public class RandomUtils {

    Faker faker = new Faker();

    public TextBoxEntity generateRandomTextBoxEntity(){
        TextBoxEntity textBoxEntity =  new TextBoxEntity();
        textBoxEntity.setFullName(faker.name().fullName());
        textBoxEntity.setEmail(faker.internet().emailAddress());
        textBoxEntity.setCurrentAddress(faker.address().fullAddress());
        textBoxEntity.setPermanentAddress(faker.address().secondaryAddress());
        return textBoxEntity;
    }

    public PracticeFormEntity generateRandomPracticeFormEntity(){
        PracticeFormEntity practiceFormEntity = new PracticeFormEntity();
        practiceFormEntity.setFirstName(faker.name().firstName());
        practiceFormEntity.setLastName(faker.name().lastName());
        practiceFormEntity.setEmail(faker.internet().emailAddress());
        practiceFormEntity.setMobileNumber(faker.phoneNumber().subscriberNumber(10));
        practiceFormEntity.setSubjects("Biology");
        practiceFormEntity.setSelectPicture("C:\\Users\\ннн\\OneDrive\\Изображения\\d5750d2f1cf1adc4ffdb3387f058366e.jpg");
        practiceFormEntity.setCurrentAddress(faker.address().fullAddress());
        return practiceFormEntity;
    }

    public EmployeeEntity generateRandomEmployeeEntities(){
        EmployeeEntity employee = new EmployeeEntity();
        employee.setFirstName(faker.name().firstName());
        employee.setLastName(faker.name().lastName());
        employee.setAge(faker.number().numberBetween(18,100));
        employee.setEmail(faker.internet().emailAddress());
        employee.setSalary(faker.number().numberBetween(100000,2000000));
        employee.setDepartment(faker.job().position());
        return employee;
    }

}
