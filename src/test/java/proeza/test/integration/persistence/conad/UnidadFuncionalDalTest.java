package proeza.test.integration.persistence.conad;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proeza.conad.dao.ITipoUnidadFuncionalDao;
import com.proeza.conad.dao.IUnidadFuncionalDao;
import com.proeza.conad.entity.TipoUnidadFuncional;
import com.proeza.conad.entity.UnidadFuncional;

import static org.junit.Assert.*;

import proeza.test.integration.IntegrationTest;

public class UnidadFuncionalDalTest extends IntegrationTest {
	@Autowired
	private IUnidadFuncionalDao		unidadFuncionalDao;

	@Autowired
	private ITipoUnidadFuncionalDao	tipoUFDao;

	@Test
	public void findUF_BY_PK () {
		UnidadFuncional unidadFuncional = this.unidadFuncionalDao.find(1L);
		assertNotNull(unidadFuncional);
		assertEquals("21", unidadFuncional.getCodigo());
		assertEquals(1.25D, unidadFuncional.getIncidencia(), 0.001D);
	}

	@Test
	public void findTipoUF_BY_PK () {
		TipoUnidadFuncional unidadFuncional = this.tipoUFDao.find(1L);
		assertNotNull(unidadFuncional);
		assertEquals("Cochera", unidadFuncional.getNombre());
	}
}
