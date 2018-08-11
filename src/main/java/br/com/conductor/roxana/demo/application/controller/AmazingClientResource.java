package br.com.conductor.roxana.demo.application.controller;

import br.com.conductor.roxana.demo.application.dto.ClientReqDTO;
import br.com.conductor.roxana.demo.application.dto.ClientRespDTO;
import br.com.conductor.roxana.demo.domain.model.AmazingClient.AmazingClient;
import br.com.conductor.roxana.demo.domain.model.service.AmazingClientBusiness;
import br.com.rooting.roxana.message.Message;
import br.com.rooting.roxana.message.MessageCreator;
import br.com.rooting.roxana.message.MessageCreatorFactory;
import br.com.rooting.roxana.response.FilledResponse;
import br.com.rooting.roxana.response.Response;
import br.com.rooting.roxana.response.ResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static br.com.conductor.roxana.demo.application.controller.MessageMapper.CLIENT_ALTERED;
import static br.com.conductor.roxana.demo.application.controller.MessageMapper.CLIENT_CREATED;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "/api/amazing-client")
@Api(tags = "Amazing Cliente")
public class AmazingClientResource {

	private MessageCreator messageCreator;

	private AmazingClientResource(@Autowired MessageCreatorFactory messageFactory) {
        this.messageCreator = messageFactory.getMessageCreator();
    }

	@Autowired
	private AmazingClientBusiness clientBusiness;

	@ResponseStatus(code = CREATED)
	@RequestMapping(method = POST)
	public FilledResponse<ClientRespDTO> create(@RequestBody ClientReqDTO requestClient) {

		AmazingClient client = new AmazingClient();
		client = clientBusiness.create(requestClient.mergeClient(client));

		Message success = messageCreator.create(CLIENT_CREATED, client.getId());
		return ResponseBuilder.buildFilledWith(new ClientRespDTO(client), success);
	}

	@ResponseStatus(code = OK)
	@RequestMapping(method = GET, path = "/{id}")
	public FilledResponse<ClientRespDTO> get(
			@ApiParam(value = "Client identifier", required = true) @PathVariable("id") Long id) {

		AmazingClient client = clientBusiness.getClient(id);
		return ResponseBuilder.buildFilledWith(new ClientRespDTO(client));
	}

	@ResponseStatus(code = ACCEPTED)
	@RequestMapping(method = PUT, path = "/{id}")
	public Response alter(
                @ApiParam(value = "Client identifier", required = true) @PathVariable("id") Long id,
                @ApiParam(value = "Client informations", required = true) @RequestBody ClientReqDTO requestClient) {

		AmazingClient client = clientBusiness.getClient(id);
		clientBusiness.alter(requestClient.mergeClient(client));

		Message success = messageCreator.create(CLIENT_ALTERED, client.getId());
		return ResponseBuilder.buildWith(success);
	}

}