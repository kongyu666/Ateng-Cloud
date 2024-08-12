package io.github.kongyu666.common.satoken.handler;

import cn.dev33.satoken.exception.SaTokenException;
import io.github.kongyu666.common.core.utils.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一处理异常
 *
 * @author 孔余
 * @since 2023-03-20 16:23:02
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理SaToken的异常
     */
    @ExceptionHandler(SaTokenException.class)
    public Result handlerSaTokenException(HttpServletRequest request, HttpServletResponse response, SaTokenException ex) {
        // https://sa-token.cc/doc.html#/fun/not-login-scene
        // https://sa-token.cc/doc.html#/fun/exception-code
        int code = ex.getCode();
        String message = ex.getMessage();
        // 自定义返回信息
        if (code == 11011) {
            message = "用户未登录";
        } else if (code == 11012) {
            message = "用户无效";
        } else if (code == 11013) {
            message = "用户登录过期";
        } else if (code == 11016) {
            message = "用户已被冻结";
        } else if (code == 11041 || code == 11051) {
            message = "用户无权限";
        }
        // 打印异常日志
        log.error("处理SaToken的异常 ==> {}", ex.getMessage());
        ex.printStackTrace();
        // 设置状态码
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        // 构建返回结果
        return Result.error(message);
    }

}
