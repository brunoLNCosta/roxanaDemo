package br.com.conductor.roxana.demo.application.service;

import br.com.conductor.roxana.demo.domain.model.AmazingClient.AmazingClient;
import br.com.conductor.roxana.demo.domain.model.AmazingClient.AmazingClientRepository;
import br.com.conductor.roxana.demo.domain.model.service.AmazingClientBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.*;
import java.util.Set;

@Service
@Transactional
class AmazingClientBusinessImpl implements AmazingClientBusiness {

    private static final ValidatorFactory VALIDATOR_FACTORY = Validation.buildDefaultValidatorFactory();
    private static final Validator VALIDATOR = VALIDATOR_FACTORY.getValidator();

    @Autowired
    private AmazingClientRepository repository;

    @Override
    public AmazingClient create(AmazingClient client) {
        this.valid(client);
        return this.getClientRepository().save(client);
    }

    @Override
    public void alter(AmazingClient client) {
        this.valid(client);
        this.getClientRepository().save(client);
    }

    @Override
    public AmazingClient getClient(Long id) {
        return this.getClientRepository().findById(id)
                        .orElseThrow(() -> new RuntimeException());
    }

    public AmazingClientRepository getClientRepository() {
        return repository;
    }

    private void valid(AmazingClient client) {
        Set<ConstraintViolation<AmazingClient>> violations = VALIDATOR.validate(client);
        if(violations != null &&  !violations.isEmpty())
            throw new ConstraintViolationException("erro", violations);
    }

}
