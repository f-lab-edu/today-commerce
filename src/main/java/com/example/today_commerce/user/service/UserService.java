package com.example.today_commerce.user.service;

import com.example.today_commerce.security.Encryptor;
import com.example.today_commerce.user.domain.User;
import com.example.today_commerce.user.dto.UserSignUpRequestDto;
import com.example.today_commerce.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final Encryptor encryptor;

    /**
     * 회원 가입
     * @param userSignUpRequestDto
     * @return
     */
    @Transactional
    public Long signUp(UserSignUpRequestDto userSignUpRequestDto) {
        // 이메일 중복 검사
        if (isExistEmail(userSignUpRequestDto.getEmail())) {
            throw new IllegalStateException("이미 존재하는 사용자입니다.");
        }
        String encryptedPassword = encryptor.encrypt(userSignUpRequestDto.getPassword());
        User newUser = userSignUpRequestDto.toEntity(encryptedPassword);

        userRepository.save(newUser);
        return newUser.getId();
    }

    /**
     * 이메일 중복 여부 확인
     * @param email
     * @return
     */
    private boolean isExistEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
