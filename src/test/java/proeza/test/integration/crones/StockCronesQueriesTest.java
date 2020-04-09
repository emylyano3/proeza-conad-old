package proeza.test.integration.crones;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.proeza.config.env.Environments;
import com.proeza.config.root.ContextConfig;
import com.proeza.sgs.business.scheduling.JobRelevamiento;

@Transactional
@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Environments.class, ContextConfig.class})
public class StockCronesQueriesTest {

	@Autowired
	private JobRelevamiento job;

	@Test
	public void countStock_POR_MARCA () {
		this.job.countStockByBrand();
	}

	@Test
	public void countStock_POR_RUBRO () {
		this.job.countStockByBrand();
	}
}