package com.advgm.aspect;

import com.advgm.model.R;
import com.baomidou.mybatisplus.extension.api.IErrorCode;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 内部API调用的异常处理
     */
    @ExceptionHandler(value = ApiException.class)
    public R handlerApiException(ApiException exception){
        IErrorCode errorCode=exception.getErrorCode();
        if(errorCode!=null){
            return R.fail(errorCode);
        }
        return R.fail(exception.getMessage());
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        BindingResult bindingResult=exception.getBindingResult();
        if(bindingResult.hasErrors()){
            FieldError fieldError=bindingResult.getFieldError();
            if(fieldError!=null){
                return R.fail(fieldError.getField()+fieldError.getDefaultMessage());
            }
        }
        return R.fail(exception.getMessage());
    }
    /**
     * 3 对象内部使用Validate 没有校验成功的异常
     */
    @ExceptionHandler(BindException.class)
    public R handlerBindException(BindException bindException){
        BindingResult bindingResult = bindException.getBindingResult();
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            if(fieldError!=null){
                return R.fail(fieldError.getField()+fieldError.getDefaultMessage()) ;
            }
        }
        return R.fail(bindException.getMessage()) ;
    }
}
