package proeza.test.unit.sgs.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proeza.core.util.date.DateUtil;
import com.proeza.sgs.business.chart.venta.UserSalesChartDefinition;
import com.proeza.sgs.business.service.IVentaChartService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import proeza.test.unit.sgs.WebMvcUnitTest;

public class VentaChartRestTest extends WebMvcUnitTest {

    @Autowired
    private IVentaChartService chartService;

    @Override
    protected Object[] getMocks () {
        return new Object[] {this.chartService};
    }

    @Test
    public void userLastMonthsSales () throws Exception {
        List<Double> data = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        UserSalesChartDefinition precioHistory = new UserSalesChartDefinition(labels, data);
        precioHistory.setData(data);
        precioHistory.setLabels(labels);
        data.addAll(Arrays.asList(new Double[] {20D, 30D, 40D, 50D, 60D, 70D, 80D, 90D, 100D, 110D, 120D, 130D}));
        labels.addAll(Arrays.asList(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio"}));
        Date to = DateUtil.createNow();
        Date from = DateUtil.substractMonths(to, 12);
        when(this.chartService.ventasMensuales("admin", from, to)).thenReturn(precioHistory);
        this.mockMvc.perform(post("/rest/sales/stats/userLastMonthsSales/admin/12")).andExpect(status().isOk());
    }
}