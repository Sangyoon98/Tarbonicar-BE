package com.tarbonicar.backend.common.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)

public enum ErrorStatus {
    /**
     * 400 BAD_REQUEST
     */
    VALIDATION_REQUEST_MISSING_EXCEPTION(HttpStatus.BAD_REQUEST, "요청 값이 입력되지 않았습니다."),
    ALREADY_EMAIL_EXIST_EXCEPTION(HttpStatus.BAD_REQUEST, "이미 가입된 이메일입니다."),
    PASSWORD_MISMATCH_EXCEPTION(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
    KAKAO_LOGIN_FAILED(HttpStatus.BAD_REQUEST, "카카오 로그인에 실패했습니다."),
    KAKAO_TOKEN_REQUEST_FAILED(HttpStatus.BAD_REQUEST, "카카오 토큰 요청에 실패했습니다."),
    INTERNAL_TOKEN_PARSING_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "카카오 토큰 응답 파싱 실패"),
    KAKAO_USERINFO_REQUEST_FAILED(HttpStatus.BAD_REQUEST, "카카오 사용자 정보 요청에 실패했습니다."),
    INTERNAL_USERINFO_PARSING_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "카카오 사용자 정보 파싱에 실패했습니다."),
    MISSING_UPLOAD_IMAGE_EXCEPTION(HttpStatus.BAD_REQUEST, "업로드할 이미지가 없습니다."),
    THIS_MEMBER_IS_NOT_WRITER_EXCEPTION(HttpStatus.BAD_REQUEST,"게시글 작성자가 아닙니다."),
    THIS_MEMBER_IS_NOT_COMMENT_WRITER_EXCEPTION(HttpStatus.BAD_REQUEST,"댓글 작성자가 아닙니다."),
    ALREADY_ADD_CARAGE_EXCEPTION(HttpStatus.BAD_REQUEST, "이미 등록된 차량 연식 입니다."),

    /**
     * 401 UNAUTHORIZED
     */
    USER_UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"인증되지 않은 사용자입니다."),

    /**
     * 404 NOT_FOUND
     */

    NOT_LOGIN_EXCEPTION(HttpStatus.NOT_FOUND,"로그인이 필요합니다."),
    NOT_FOUND_CARTYPE_EXCEPTION(HttpStatus.NOT_FOUND,"존재하지 않는 차량 타입 입니다."),
    NOT_FOUND_CARNAME_EXCEPTION(HttpStatus.NOT_FOUND,"존재하지 않는 차량 이름 입니다."),
    NOT_FOUND_CARAGE_EXCEPTION(HttpStatus.NOT_FOUND,"존재하지 않는 차량 연식 입니다."),
    NOT_FOUND_MEMBERID_EXCEPTION(HttpStatus.NOT_FOUND,"존재하지 않는 사용자 입니다."),
    NOT_FOUND_ARTICLE_EXCEPTION(HttpStatus.NOT_FOUND,"존재하지 않는 게시글 입니다."),
    NOT_FOUND_COMMENT_EXCEPTION(HttpStatus.NOT_FOUND,"존재하지 않는 댓글 입니다."),

    /**
     * 500 SERVER_ERROR
     */
    FAIL_UPLOAD_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR,"파일 업로드 실패하였습니다."),

    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getStatusCode() {
        return this.httpStatus.value();
    }
}
