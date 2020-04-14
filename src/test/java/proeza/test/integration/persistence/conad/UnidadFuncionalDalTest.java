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
	public void findUF_BY_PK_UF_21 () {
		UnidadFuncional unidadFuncional = this.unidadFuncionalDao.find(1L);
		assertNotNull(unidadFuncional);
		assertEquals("21", unidadFuncional.getCodigo());
		assertNotNull(unidadFuncional.getIncidencia());
		assertEquals(1.25D, unidadFuncional.getIncidencia().doubleValue(), 0.001D);
		assertNotNull(unidadFuncional.getPropietario());
		assertNull(unidadFuncional.getInquilino());
	}

	@Test
	public void findUF_BY_PK_UF_22 () {
		UnidadFuncional unidadFuncional = this.unidadFuncionalDao.find(2L);
		assertNotNull(unidadFuncional);
		assertEquals("22", unidadFuncional.getCodigo());
		assertNotNull(unidadFuncional.getIncidencia());
		assertEquals(0.73D, unidadFuncional.getIncidencia().doubleValue(), 0.001D);
		assertNotNull(unidadFuncional.getInquilino());
		assertNull(unidadFuncional.getPropietario());
	}

	@Test
	public void findUF_BY_PK_UF_23 () {
		UnidadFuncional unidadFuncional = this.unidadFuncionalDao.find(3L);
		assertNotNull(unidadFuncional);
		assertEquals("23", unidadFuncional.getCodigo());
		assertNotNull(unidadFuncional.getIncidencia());
		assertEquals(0.73D, unidadFuncional.getIncidencia().doubleValue(), 0.001D);
		assertNull(unidadFuncional.getInquilino());
		assertNull(unidadFuncional.getPropietario());
	}

	@Test
	public void findTipoUF_BY_PK () {
		TipoUnidadFuncional unidadFuncional = this.tipoUFDao.find(1L);
		assertNotNull(unidadFuncional);
		assertEquals("Cochera", unidadFuncional.getNombre());
	}
}
