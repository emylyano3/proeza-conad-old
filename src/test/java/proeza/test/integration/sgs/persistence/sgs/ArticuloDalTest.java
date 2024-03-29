package proeza.test.integration.sgs.persistence.sgs;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proeza.sgs.business.dao.IArticuloDao;
import com.proeza.sgs.business.entity.Articulo;

import proeza.test.integration.IntegrationTest;


public class ArticuloDalTest extends IntegrationTest {

	@Autowired
	private IArticuloDao articleDao;

	@Test
	public void findAll () {
		List<Articulo> result = this.articleDao.findAll();
		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());
	}
}