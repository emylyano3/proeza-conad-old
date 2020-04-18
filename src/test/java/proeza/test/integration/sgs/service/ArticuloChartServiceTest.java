package proeza.test.integration.sgs.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proeza.sgs.business.chart.SingleValueChartData;
import com.proeza.sgs.business.service.IArticuloChartService;

import static org.junit.Assert.*;

import proeza.test.integration.IntegrationTest;

public class ArticuloChartServiceTest extends IntegrationTest {

    @Autowired
    private IArticuloChartService chartService;

    @Test
    public void worstSellers () {
        List<SingleValueChartData> result = this.chartService.worstSellers(10);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}