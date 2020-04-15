package proeza.test.integration.persistence.conad;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proeza.conad.dao.IInquilinoDao;
import com.proeza.conad.entity.Inquilino;

import static org.junit.Assert.*;

import proeza.test.integration.IntegrationTest;

public class InquilinoDalTest extends IntegrationTest {

	@Autowired
	private IInquilinoDao inquilinoDao;

	@Test
	public void find_BY_PK () {
		Inquilino inquilino = this.inquilinoDao.find(1L);
		assertNotNull(inquilino);
		assertNotNull(inquilino.getUnidadesFuncionales());
		assertEquals(1, inquilino.getUnidadesFuncionales().size());
		assertEquals("23", inquilino.getUnidadesFuncionales().iterator().next().getCodigo());
	}
}
