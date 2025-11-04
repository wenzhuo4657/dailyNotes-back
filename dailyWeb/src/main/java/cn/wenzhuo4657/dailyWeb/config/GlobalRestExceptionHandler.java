package cn.wenzhuo4657.dailyWeb.config;

import cn.wenzhuo4657.dailyWeb.types.Exception.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类，
 */
@RestControllerAdvice
public class GlobalRestExceptionHandler {
    @ExceptionHandler(AppException.class)
    public ResponseEntity handleAppException(AppException e) {
        return ResponseEntity.status(e.getCode()).body(e.getInfo());
    }
}
