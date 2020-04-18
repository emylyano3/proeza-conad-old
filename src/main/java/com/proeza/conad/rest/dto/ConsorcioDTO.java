package com.proeza.conad.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ConsorcioDTO {
	private Long			id;
	private String			nombre;
	private String			descripcion;
	private String			email;
	private boolean			habilitado	= true;
	private DireccionDTO	direccion;
}
