package br.com.conductor.roxana.demo.application.exception;

import br.com.rooting.roxana.exception.mapper.BusinessException;
import br.com.rooting.roxana.parameter.mapper.CurrencyParam;
import br.com.rooting.roxana.parameter.mapper.DateParam;
import br.com.rooting.roxana.parameter.mapper.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@BusinessException
public class SaldoInsuficienteException extends RuntimeException {

    @DateParam // Suporte a DATE, CALENDAR, LocalDate ...
    private final LocalDateTime data;

    @CurrencyParam // Suporte a Double e Float
    private final BigDecimal valor;

    @Param("nameCliente") // Nome o parametro customizado
    private final String nome;

    public SaldoInsuficienteException(LocalDateTime data, BigDecimal valor, String nome) {
        this.data = data;
        this.valor = valor;
        this.nome = nome;
    }

    public LocalDateTime getData() {
        return data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }

}
