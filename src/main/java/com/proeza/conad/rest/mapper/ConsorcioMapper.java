package com.proeza.conad.rest.mapper;

import org.springframework.stereotype.Component;

import com.proeza.conad.entity.Consorcio;
import com.proeza.conad.rest.dto.ConsorcioDTO;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class ConsorcioMapper extends ConfigurableMapper {

	@Override
	protected void configure (MapperFactory factory) {
		factory.classMap(Consorcio.class, ConsorcioDTO.class).byDefault().register();
	}
}