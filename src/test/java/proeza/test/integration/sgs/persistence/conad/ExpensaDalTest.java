package proeza.test.integration.sgs.persistence.conad;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proeza.conad.dao.IExpensaDao;
import com.proeza.conad.entity.Expensa;
import com.proeza.conad.entity.ExpensaAplica;
import com.proeza.conad.entity.ExpensaTipo;
import com.proeza.core.persistence.IGenericDao;
import com.proeza.core.util.date.DateUtil;

import static org.junit.Assert.*;

import proeza.test.integration.IntegrationTest;

public class ExpensaDalTest extends IntegrationTest {
	@Autowired
	private IExpensaDao	expensaDao;

	@Autowired
	private IGenericDao	genericDao;

	@Test
	public void find_BY_PK_1 () {
		Expensa expensa = this.expensaDao.find(1L);
		assertNotNull(expensa);
		assertEquals("Fondo reseva dptos.", expensa.getNombre());
		assertTrue(expensa.isHabilitado());
		assertNotNull(expensa.getConsorcio());
		assertNotNull(expensa.getExpensaTipo());
		assertNotNull(expensa.getExpensaAplica());
		assertEquals(DateUtil.create(2020, 05, 01), expensa.getVigencia());
		assertNotNull(expensa.getValor());
		assertEquals(Double.valueOf(3500), expensa.getValor().doubleValue(), 0.0001D);
		assertNotNull(expensa.getUnidadesFuncionales());
		assertTrue(expensa.getUnidadesFuncionales().isEmpty());
	}

	@Test
	public void find_BY_PK_3 () {
		Expensa expensa = this.expensaDao.find(3L);
		assertNotNull(expensa);
		assertEquals("Wifi", expensa.getNombre());
		assertTrue(expensa.isHabilitado());
		assertNotNull(expensa.getConsorcio());
		assertNotNull(expensa.getExpensaTipo());
		assertNotNull(expensa.getExpensaAplica());
		assertEquals(DateUtil.create(2019, 11, 01), expensa.getVigencia());
		assertEquals(Integer.valueOf(0), expensa.getDuracion());
		assertNotNull(expensa.getValor());
		assertEquals(Double.valueOf(900), expensa.getValor().doubleValue(), 0.0001D);
		assertNotNull(expensa.getUnidadesFuncionales());
		assertEquals(2, expensa.getUnidadesFuncionales().size());
	}

	@Test
	public void findTipo_BY_PK () {
		ExpensaTipo et = this.genericDao.find(ExpensaTipo.class, 1L);
		assertNotNull(et);
		assertEquals("Mensual", et.getNombre());
		assertNotNull(et.getDescripcion());
	}

	@Test
	public void findAplica_BY_PK () {
		ExpensaAplica ea = this.genericDao.find(ExpensaAplica.class, 1L);
		assertNotNull(ea);
		assertEquals("Cocheras", ea.getNombre());
		assertNotNull(ea.getDescripcion());
	}
}
