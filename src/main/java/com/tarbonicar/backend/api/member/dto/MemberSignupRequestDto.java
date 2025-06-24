package com.tarbonicar.backend.api.member.dto;

import com.tarbonicar.backend.api.member.entity.Member;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberSignupRequestDto {

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$",
            message = "비밀번호는 영문 대소문자, 숫자, 특수문자를 포함해 8자 이상이어야 합니다."
    )
    private String password;

    @NotBlank(message = "비밀번호 확인을 입력해주세요.")
    private String checkedPassword;

    @NotBlank(message = "닉네임을 입력해주세요.")
    @Size(min = 2, max = 20, message = "닉네임 2-20자 사이로 입력해주세요.")
    private String nickname;

    private String profileImage;

    public Member toEntity(String encodedPassword, String imageUrl) {
        return Member.builder()
                .email(email)
                .password(encodedPassword)
                .nickname(nickname)
                .profileImage(profileImage)
                .socialType("NORMAL")
                .socialId(null)
                .build();
    }
}
