package com.proeza.conad.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DireccionDTO {
	private Long	id;
	private String	calle;
	private Integer	numero;
	private String	localidad;
	private String	partido;
	private String	provincia;
	private String	codigoPostal;
	private Integer	piso;
	private String	departamento;
	private String	descripcion;
}
