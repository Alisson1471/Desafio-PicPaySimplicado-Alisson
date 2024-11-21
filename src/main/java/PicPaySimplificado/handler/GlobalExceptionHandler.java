package PicPaySimplificado.handler;

import PicPaySimplificado.domain.ErrorPersonalizado;
import PicPaySimplificado.exception.FailedAuthorizator;
import PicPaySimplificado.exception.FailedSave;
import PicPaySimplificado.exception.IsNotUniqueException;
import feign.FeignException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(IsNotUniqueException.class)
    public ErrorPersonalizado handler(IsNotUniqueException ex) {
        return new ErrorPersonalizado(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(FailedAuthorizator.class)
    public ErrorPersonalizado handler(FailedAuthorizator ex) {
        return new ErrorPersonalizado(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(FailedSave.class)
    public ErrorPersonalizado handler(FailedSave ex) {
        return new ErrorPersonalizado(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(FeignException.class)
    public ErrorPersonalizado handler(FeignException ex) {return new ErrorPersonalizado(ex.getMessage());}

}
