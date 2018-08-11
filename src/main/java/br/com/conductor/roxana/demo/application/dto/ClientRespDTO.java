package br.com.conductor.roxana.demo.application.dto;

import br.com.conductor.roxana.demo.domain.model.AmazingClient.AmazingClient;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class ClientRespDTO {
	
	@ApiModelProperty(position = 0, value = "Identifier of the Client", example = "1")
	private Long id;
	
	@ApiModelProperty(position = 1, value = "First Name of the Client", example = "Bruno")
	private String firstName;
	
	@ApiModelProperty(position = 2, value = "Last Name of the Client", example = "Costa")
	private String lastName;
	
	@ApiModelProperty(position = 4, value = "The e-mail of the Client", example = "brunoluisncosta@gmail.com")
	private String email;
	
	@ApiModelProperty(position = 5, value = "The birth date of the Client", example = "1992-12-11")
	private LocalDate birthDate;
	
	public ClientRespDTO(final AmazingClient client) {
		this.setId(client.getId());
		this.setFirstName(client.getFirstName());
		this.setLastName(client.getLastName());
		this.setEmail(client.getEmail());
		this.setBirthDate(client.getBirthDate());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
}
