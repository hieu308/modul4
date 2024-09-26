package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@AllArgsConstructor
@Setter
@Getter
public class UserDto implements Validator {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private int age;

    public UserDto() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        UserDto usersDto = (UserDto) target;

        if (usersDto.getFirstName() == null || usersDto.getFirstName().trim().isEmpty()) {
            errors.rejectValue("firstName", null, "First name is required");
        } else if (!usersDto.getFirstName().matches("[a-z]{4,45}$")) {
            errors.rejectValue("firstName", null,
                    "First name minimum 5 characters maximum 45 ");
        }
        if (usersDto.getLastName() == null || usersDto.getLastName().trim().isEmpty()) {
            errors.rejectValue("lastName", null, "Last name is required");
        } else if (!usersDto.getLastName().matches("[a-z]{4,45}$")) {
            errors.rejectValue("lastName", null, "Last name minimum 5 characters maximum 45");

        }
        if (usersDto.getEmail() == null || usersDto.getEmail().trim().isEmpty()) {
            errors.rejectValue("email", null, "Email is required");
        } else if (!usersDto.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            errors.rejectValue("email", null, "Email is not match");
        }


        if (usersDto.getPhone() == null || usersDto.getPhone().trim().isEmpty()) {
            errors.rejectValue("phone", null, "Phone number is required");
        } else if (!usersDto.getPhone().matches("^[0-9]{10}$")) {
            errors.rejectValue("phone", null, "Phone number must be 10 digits");
        }
        if (usersDto.getAge() < 18) {
            errors.rejectValue("age", null, "Age must be greater than 18");
        } else if (usersDto.getAge() > 90) {
            errors.rejectValue("age", null, "Age must be less than or equal to 90");
        }

    }


}
