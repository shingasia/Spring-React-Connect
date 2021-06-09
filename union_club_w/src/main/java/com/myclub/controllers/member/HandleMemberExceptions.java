package com.myclub.controllers.member;

import com.myclub.exceptions.member.EmailRegexNotMatchException;
import com.myclub.exceptions.member.IdAndPasswordNotMatchException;
import com.myclub.exceptions.member.MemberAlreadyExistException;
import com.myclub.exceptions.member.MemberNotFoundException;
import com.myclub.exceptions.member.PasswordAndPasswordConfirmDifferentException;
import com.myclub.exceptions.member.PreviousInformationIsInaccurateException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Component 스캔 대상에 포함 될까?? -> Yes
public class HandleMemberExceptions {
    
    // 회원 가입시 Exceptions 체크
    @ExceptionHandler(MemberAlreadyExistException.class)
    public ErrorMessage handleJoinException1(){
        ErrorMessage msg = new ErrorMessage();
        msg.setMessage("이미 존재하는 아이디입니다.");
        return msg;
    }

    @ExceptionHandler(PasswordAndPasswordConfirmDifferentException.class)
    public ErrorMessage handleJoinException2(){
        ErrorMessage msg = new ErrorMessage();
        msg.setMessage("비밀번호와 비밀번호확인이 다릅니다.");
        return msg;
    }

    @ExceptionHandler(EmailRegexNotMatchException.class)
    public ErrorMessage handleJoinException3(){
        ErrorMessage msg = new ErrorMessage();
        msg.setMessage("이메일이 정규표현식에 어긋납니다.");
        return msg;
    }

    // 로그인, 회원 탈퇴시 Exceptions 체크
    @ExceptionHandler({MemberNotFoundException.class, IdAndPasswordNotMatchException.class})
    public ErrorMessage handleLoginException(){
        ErrorMessage msg = new ErrorMessage();
        msg.setMessage("아이디와 비밀번호를 다시 입력하세요.");
        return msg;
    }

    // 회원 정보 변경시 Exceptions 체크
    @ExceptionHandler({PreviousInformationIsInaccurateException.class})
    public ErrorMessage handleModifyException(){
        ErrorMessage msg = new ErrorMessage();
        msg.setMessage("기존 정보를 다시 입력하세요.");
        return msg;
    }

}
class ErrorMessage {
    
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}