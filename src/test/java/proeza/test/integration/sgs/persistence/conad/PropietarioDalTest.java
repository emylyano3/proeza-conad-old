package proeza.test.integration.sgs.persistence.conad;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proeza.conad.dao.IPropietarioDao;
import com.proeza.conad.entity.Propietario;

import static org.junit.Assert.*;

import proeza.test.integration.IntegrationTest;

public class PropietarioDalTest extends IntegrationTest {

	@Autowired
	private IPropietarioDao propietarioDao;

	@Test
	public void find_BY_PK () {
		Propietario propietario = this.propietarioDao.find(1L);
		assertNotNull(propietario);
		assertNotNull(propietario.getUnidadesFuncionales());
		assertEquals(2, propietario.getUnidadesFuncionales().size());
		assertTrue(Arrays.asList("21", "22").contains(propietario.getUnidadesFuncionales().iterator().next().getCodigo()));
		assertNotNull(propietario.getPagos());
		assertFalse(propietario.getPagos().isEmpty());
		assertNotNull(propietario.getPagos().iterator().next().getMonto());
		assertEquals(4000D, propietario.getPagos().iterator().next().getMonto().doubleValue(), 0.0001D);
	}
}
