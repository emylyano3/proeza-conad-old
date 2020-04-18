package proeza.test.integration.sgs.persistence.conad;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proeza.conad.dao.ICuentaDao;
import com.proeza.conad.entity.Cuenta;
import com.proeza.conad.entity.MovimientoCuenta;

import static org.junit.Assert.*;

import proeza.test.integration.IntegrationTest;

public class CuentaDalTest extends IntegrationTest {
	@Autowired
	private ICuentaDao cuentaDao;

	@Test
	public void find_BY_PK () {
		Cuenta cuenta = this.cuentaDao.find(1L);
		assertNotNull(cuenta);
		assertNotNull(cuenta.getMovimientos());
		assertFalse(cuenta.getMovimientos().isEmpty());
		assertNotNull(cuenta.getSaldo());
		assertEquals(150D, cuenta.getSaldo().doubleValue(), 0.001D);
		double total = 0;
		for (MovimientoCuenta m : cuenta.getMovimientos()) {
			assertNotNull(m.getMonto());
			total += m.getMonto().doubleValue();
		}
		assertEquals(cuenta.getSaldo().doubleValue(), total, 0.001D);
	}
}
