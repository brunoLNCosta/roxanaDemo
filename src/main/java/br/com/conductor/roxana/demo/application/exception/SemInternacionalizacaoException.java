package br.com.conductor.roxana.demo.application.exception;

import br.com.rooting.roxana.exception.mapper.BusinessException;
import br.com.rooting.roxana.message.MessageSeverity;
import br.com.rooting.roxana.parameter.mapper.Param;
import org.springframework.http.HttpStatus;

@BusinessException(message = "Eu, [nome] não preciso de internacionalização")
public class SemInternacionalizacaoException extends RuntimeException {

    @Param
    private String nome;

    public SemInternacionalizacaoException(String nome) {
        this.nome = nome;
    }
}
