package br.com.conductor.roxana.demo.application.controller;

import br.com.conductor.roxana.demo.application.exception.CustomizeException;
import br.com.conductor.roxana.demo.application.exception.NegocioException;
import br.com.conductor.roxana.demo.application.exception.SaldoInsuficienteException;
import br.com.conductor.roxana.demo.application.exception.SemInternacionalizacaoException;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path = "/api/demo")
@Api(tags = "Exception Magic")
public class ExceptionResource {

	@ResponseStatus(code = OK)
	@RequestMapping(method = GET, path = "/erro-interno")
	public void getErroInterno() {
		throw new ArrayIndexOutOfBoundsException();
	}

    @ResponseStatus(code = OK)
    @RequestMapping(method = GET, path = "/negocio-exception")
	public void getNegocioException() {
        throw new NegocioException();
    }

    @ResponseStatus(code = OK)
    @RequestMapping(method = GET, path = "/saldo-insuficiente-exception")
    public void getSaldoInsuficiente() {
        throw new SaldoInsuficienteException(LocalDateTime.now(), BigDecimal.valueOf(13.50), "Bruno Costa");
    }

    @ResponseStatus(code = OK)
    @RequestMapping(method = GET, path = "/customize-exception")
    public void getCustomizeException() {
        throw new CustomizeException();
    }

    @ResponseStatus(code = OK)
    @RequestMapping(method = GET, path = "/sem-internacionalizacao-exception")
    public void getSemInternacionalizacaoException() {
        throw new SemInternacionalizacaoException("Bruno Costa");
    }

}