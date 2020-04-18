package proeza.test.integration.sgs.persistence.conad;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proeza.conad.dao.IConsorcioDao;
import com.proeza.conad.entity.Consorcio;
import com.proeza.conad.entity.UnidadFuncional;

import static org.junit.Assert.*;

import proeza.test.integration.IntegrationTest;

public class ConsorcioDalTest extends IntegrationTest {
	@Autowired
	private IConsorcioDao consorcioDao;

	@Test
	public void find_BY_PK () {
		Consorcio consorcio = this.consorcioDao.find(1L);
		assertNotNull(consorcio);
		assertNotNull(consorcio.getConsorcistas());
		assertFalse(consorcio.getConsorcistas().isEmpty());
		assertNotNull(consorcio.getUnidadesFuncionales());
		assertFalse(consorcio.getUnidadesFuncionales().isEmpty());
		assertEquals(4, consorcio.getUnidadesFuncionales().size());
		for (UnidadFuncional uf : consorcio.getUnidadesFuncionales()) {
			switch (uf.getCodigo()) {
				case UnidadFuncional.UF_COCHE: {
					assertNotNull(uf.getInquilino());
					break;
				}
				case UnidadFuncional.UF_DEPTO: {
					assertNotNull(uf.getPropietario());
					break;
				}
			}
		}
		assertNotNull(consorcio.getConsorcistas());
		assertEquals(1, consorcio.getConsorcistas().size());
	}
}
