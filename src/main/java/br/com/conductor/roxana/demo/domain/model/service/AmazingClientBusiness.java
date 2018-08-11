package br.com.conductor.roxana.demo.domain.model.service;

import br.com.conductor.roxana.demo.domain.model.AmazingClient.AmazingClient;

public interface AmazingClientBusiness {
	
	 AmazingClient create(AmazingClient client);

	 void alter(AmazingClient client);

	 AmazingClient getClient(Long id);

}
