package com.carlosli.sudoker.user.handler;

import com.carlosli.common.exc.AuthenticateException;
import com.carlosli.common.exc.UserNotFoundException;
import com.carlosli.common.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 李健成
 * @date 2021/12/29
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResultVO<Void> handle(Throwable e) {
        return new ResultVO<Void>().fail().message(e.getMessage());
    }

}
