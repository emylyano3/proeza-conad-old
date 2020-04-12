package proeza.test.integration.persistence.core;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proeza.core.dao.impl.IPersonaDao;
import com.proeza.core.entity.Persona;

import static org.junit.Assert.*;

import proeza.test.integration.IntegrationTest;

public class PersonaDalTest extends IntegrationTest {
	@Autowired
	private IPersonaDao personaDao;

	@Test
	public void find_BY_PK () {
		Persona p = this.personaDao.find(1L);
		assertNotNull(p);
	}
}
