package br.com.conductor.roxana.demo.application.dto;

import br.com.conductor.roxana.demo.domain.model.AmazingClient.AmazingClient;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class ClientReqDTO {

	@ApiModelProperty(position = 0, required = true, value = "First Name of the Client", example = "Bruno")
	private String firstName;
	
	@ApiModelProperty(position = 1, required = true, value = "Last Name of the Client", example = "Costa")
	private String lastName;
	
	@ApiModelProperty(position = 2, required = true, value = "The e-mail of the Client", example = "brunoluisncosta@gmail.com")
	private String email;
	
	@ApiModelProperty(position = 3, required = true, value = "The birth date of the Client", example = "1992-12-11")
	private LocalDate birthDate;

	public AmazingClient mergeClient(final AmazingClient client) {
		client.setFirstName(this.getFirstName());
		client.setLastName(this.getLastName());
		client.setEmail(this.getEmail());
		client.setBirthDate(this.getBirthDate());
		return client;
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