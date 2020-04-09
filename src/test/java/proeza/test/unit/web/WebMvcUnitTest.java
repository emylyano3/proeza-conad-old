package proeza.test.unit.web;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.proeza.config.dispatcher.WebMvcConfig;

import proeza.test.unit.AbstractUnitTest;

/**
 * Arquitectura de testing unitario para la parte web de la aplicacion.<br/>
 * <a href=
 * "http://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-configuration/"
 * >Documentacion</a>
 *
 * @author c.eschia
 */
@WebAppConfiguration
@ContextConfiguration(classes = {WebMvcConfig.class})
public abstract class WebMvcUnitTest extends AbstractUnitTest {
	protected MockMvc             mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	@Override
	public void setUp () {
		super.setUp();
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
}