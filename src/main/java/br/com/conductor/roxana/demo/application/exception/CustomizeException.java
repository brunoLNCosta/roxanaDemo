package br.com.conductor.roxana.demo.application.exception;

import br.com.rooting.roxana.exception.mapper.BusinessException;
import br.com.rooting.roxana.message.MessageSeverity;
import org.springframework.http.HttpStatus;

@BusinessException(message = "{customizedException}, esta parte é fixa, {customizedException}.",
                   severity = MessageSeverity.INFO,
                    responseCode = HttpStatus.CONFLICT)
public class CustomizeException extends RuntimeException {

}
