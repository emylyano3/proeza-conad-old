package proeza.test.integration.sgs.persistence.conad;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proeza.conad.dao.IPagoDao;
import com.proeza.conad.entity.Documento;
import com.proeza.conad.entity.Estado;
import com.proeza.conad.entity.Pago;
import com.proeza.core.persistence.IGenericDao;
import com.proeza.core.util.date.DateUtil;

import static org.junit.Assert.*;

import proeza.test.integration.IntegrationTest;

public class PagoDalTest extends IntegrationTest {
	@Autowired
	private IPagoDao	pagoDao;

	@Autowired
	private IGenericDao	genericDao;

	@Test
	public void find_BY_PK () {
		Pago pago = this.pagoDao.find(1L);
		assertNotNull(pago);
		assertNotNull(pago.getRecibo());
		assertNotNull(pago.getEstado());
		assertEquals("Pendiente", pago.getEstado().getNombre());
		assertEquals(DateUtil.create(2020, 04, 14), pago.getFechaRevision());
	}

	@Test
	public void findEstado_BY_PK () {
		Estado estado = this.genericDao.find(Estado.class, 1L);
		assertEquals("Pendiente", estado.getNombre());
		assertNotNull(estado);
	}

	@Test
	public void findRecibo_BY_PK () throws SQLException {
		Documento recibo = this.genericDao.find(Documento.class, 1L);
		assertNotNull(recibo);
		assertEquals("png", recibo.getMediaType());
		assertEquals("recibo pago", recibo.getNombre());
		byte[] data = recibo.getData().getBytes(1, (int) recibo.getData().length());
		assertEquals("BINARY DATA", new String(data));
	}
}
