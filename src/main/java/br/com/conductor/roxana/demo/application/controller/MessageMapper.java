package br.com.conductor.roxana.demo.application.controller;

import br.com.rooting.roxana.message.MessageSeverity;
import br.com.rooting.roxana.message.mapper.MessageMapperEnum;
import br.com.rooting.roxana.parameter.mapper.Param;

import static br.com.rooting.roxana.message.MessageSeverity.SUCCESS;

public enum MessageMapper implements MessageMapperEnum {

    @Param("id")
    CLIENT_CREATED(SUCCESS),

    @Param("id")
    CLIENT_ALTERED(SUCCESS);

    private final MessageSeverity severity;

    MessageMapper(final MessageSeverity severity) {
        this.severity = severity;
    }

    @Override
    public MessageSeverity getSeverity() {
        return this.severity;
    }

}