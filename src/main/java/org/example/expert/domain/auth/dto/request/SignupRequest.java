package org.example.expert.domain.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    @NotBlank @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String userRole;

    // nickname 조건
    // 최소 1자에서 최대 16자
    // 한글, 영어, 숫자, 하나의 공백만 허용
    // 연속된 공백 두 개 이상은 비허용
    @NotBlank   // null 과 ""(초기화된 String), " "(공백) 모두 비허용
    @Pattern(regexp = "^(?!.*\\s{2,})[a-zA-Z0-9가-힣\\s]{1,16}$", message = "닉네임 형식이 올바르지 않습니다.")
    private String nickname;
}
