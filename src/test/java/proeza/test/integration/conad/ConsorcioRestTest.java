package proeza.test.integration.conad;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proeza.conad.dao.IConsorcioDao;
import com.proeza.conad.entity.Consorcio;
import com.proeza.conad.entity.Consorcio_;
import com.proeza.conad.rest.dto.ConsorcioDTO;
import com.proeza.conad.rest.dto.DireccionDTO;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import proeza.test.integration.WebMvcIntegrationTest;
import proeza.test.unit.TestUtil;

public class ConsorcioRestTest extends WebMvcIntegrationTest {

	@Autowired
	private IConsorcioDao consorcioDao;

	@Test
	public void find () throws Exception {
		this.mockMvc
			.perform(get("/api/consorcios?id=1"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtil.APPLICATION_JSON))
			.andExpect(jsonPath("$.id", is(1)))
			.andExpect(jsonPath("$.nombre", is("Victoria Tower")))
			.andExpect(jsonPath("$.direccion.localidad", is("Villa Carlos Paz")));
	}

	@Test
	@Transactional
	public void create () throws Exception {
		ConsorcioDTO c = new ConsorcioDTO();
		c.setNombre("Brickland");
		c.setDescripcion("Barrio Cerrado Brickland");
		c.setEmail("brickland@gmail.com");
		c.setHabilitado(true);
		DireccionDTO d = new DireccionDTO();
		d.setCalle("Calle Falsa");
		d.setLocalidad("Springfield");
		d.setPartido("Springfield");
		d.setProvincia("Springfield");
		d.setCodigoPostal("10001");
		d.setNumero(123);
		c.setDireccion(d);
		this.mockMvc
			.perform(
				post("/api/consorcios")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(c)))
			.andExpect(status().is2xxSuccessful());
		Consorcio fetched = this.consorcioDao.findByAttribute(Consorcio_.nombre, "Brickland");
		assertNotNull(fetched);
		assertNotNull(fetched.getDireccion());
		assertEquals("Springfield", fetched.getDireccion().getLocalidad());
	}

	@Test
	@Transactional
	public void CRUD () throws Exception {
		ConsorcioDTO c = new ConsorcioDTO();
		c.setNombre("Consorcio");
		c.setDescripcion("Consorcio Test");
		c.setEmail("consorcio@gmail.com");
		c.setHabilitado(true);
		DireccionDTO d = new DireccionDTO();
		d.setCalle("Calle Falsa");
		d.setLocalidad("Springfield");
		d.setPartido("Springfield");
		d.setProvincia("Springfield");
		d.setCodigoPostal("10001");
		d.setNumero(123);
		c.setDireccion(d);
		// Creo el Consorcio
		this.mockMvc
			.perform(
				post("/api/consorcios")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(c)))
			.andExpect(status().is2xxSuccessful());
		// Consulto
		this.mockMvc
			.perform(get("/api/consorcios?id=3"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtil.APPLICATION_JSON))
			.andExpect(jsonPath("$.id", is(3)))
			.andExpect(jsonPath("$.nombre", is("Consorcio")));
		c.setDescripcion("Consorcio Test modificado");
		c.setId(3L);
		// Actualizo
		this.mockMvc
			.perform(
				put("/api/consorcios")
					.contentType(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(c)))
			.andExpect(status().is2xxSuccessful());
		// Consulto
		this.mockMvc
			.perform(get("/api/consorcios?id=3"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtil.APPLICATION_JSON))
			.andExpect(jsonPath("$.id", is(3)))
			.andExpect(jsonPath("$.descripcion", is("Consorcio Test modificado")));
		// Elimino
		this.mockMvc
			.perform(delete("/api/consorcios?id=3"))
			.andExpect(status().is2xxSuccessful());
		// Verifico que no exista
		assertNull(this.consorcioDao.find(3L));
	}
}