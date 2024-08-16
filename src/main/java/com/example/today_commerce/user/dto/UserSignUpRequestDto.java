package com.example.today_commerce.user.dto;

import com.example.today_commerce.user.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class UserSignUpRequestDto {

    @Email(message = "올바른 이메일 형식이 아닙니다.")
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(message = "올바른 휴대폰 번호 양식이 아닙니다.",
        regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$")
    private String phone;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    private String userType;

    public User toEntity(String encryptedPassword) {
        return User.builder()
                .email(email)
                .name(name)
                .phone(phone)
                .password(encryptedPassword)
                .userType(userType)
                .build();
    }
}
