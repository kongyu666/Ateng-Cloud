package io.github.kongyu666.common.lock4j.exception;

import com.baomidou.lock.exception.LockFailureException;
import io.github.kongyu666.common.core.utils.Result;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 捕获分布式锁异常
 *
 * @author 孔余
 * @email 2385569970@qq.com
 * @date 2024-06-17 15:59:59
 */
@RestControllerAdvice
@Order(99)
@Slf4j
public class GlobalExceptionAdvice {

    /**
     * 处理自定义的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(LockFailureException.class)
    public Result handlerLockFailureException(LockFailureException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("获取锁失败了'{}',发生Lock4j异常.", requestURI, e);
        return Result.error("-1", "业务处理中，请稍后再试");
    }

}
