package com.jgxi.userpro.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice //springmvc的全局异常    自定义异常   // aop
@RestController
public class ControllerException {
    @ExceptionHandler(Exception.class)
    public JgxiData chandleExcetion(Exception e){
        return JgxiData.getErrorJgxiData(e.getMessage());
    }

}
