package com.springs.demo.common.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@ResponseBody
public class WebExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(WebExceptionHandler.class);

    @ExceptionHandler
    public ErrorResult unknownAccount(InvalidUsernameOrPasswordException e, HttpServletRequest request, HttpServletResponse response) {
        log.error("账号名或密码错误", e);
//        request.setAttribute("javax.servlet.error.status_code",401);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return ErrorResult.error(1, "账号名或密码错误");
    }

//    @ExceptionHandler
//    public ResultBean incorrectCredentials(IncorrectCredentialsException e) {
//        log.error("密码错误", e);
//        return ResultBean.error(-2, "密码错误");
//    }
//
//    @ExceptionHandler
//    public ResultBean unknownException(Exception e) {
//        log.error("发生了未知异常", e);
//        // 发送邮件通知技术人员.
//        return ResultBean.error(-99, "系统出现错误, 请联系网站管理员!");
//    }
}