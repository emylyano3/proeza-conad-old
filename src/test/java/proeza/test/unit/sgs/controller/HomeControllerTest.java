package proeza.test.unit.sgs.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proeza.system.entity.Item;
import com.proeza.system.entity.Menu;
import com.proeza.system.entity.MenuItem;
import com.proeza.system.entity.Page;
import com.proeza.system.service.IMenuService;
import com.proeza.system.service.IPageService;
import com.proeza.system.service.dto.MenuDTO;
import com.proeza.system.service.dto.PageDTO;

import static com.proeza.sgs.web.controller.HomeController.*;
import static com.proeza.system.entity.MenuType.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static proeza.test.unit.sgs.WebMvcTestUtils.*;

import proeza.test.unit.sgs.WebMvcUnitTest;

public class HomeControllerTest extends WebMvcUnitTest {

	@Autowired
	private IPageService	pageService;

	@Autowired
	private IMenuService	menuService;

	@Test
	public void homeTest () throws Exception {
		Item item = buildItem("MI_HOME", "inicio");
		Menu menu = buildBaseLeftMenu();
		MenuItem menuItem = buildMenuItem(1, item, menu);

		Set<MenuItem> items = new HashSet<>(Arrays.asList(menuItem));
		menu.setItems(items);
		Set<Menu> menues = new HashSet<>(Arrays.asList(menu));
		Page page = buildPage(PAGE_GROUP, PAGE_NAME, menues);

		when(this.pageService.findByGroupAndName(PAGE_GROUP, PAGE_NAME)).thenReturn(new PageDTO(page));
		Map<String, MenuDTO> pageMenues = new HashMap<>();
		pageMenues.put(SIDE_LEFT.name(), new MenuDTO(null, "MAIN", "MAIN"));
		when(this.menuService.getMenus(PAGE_GROUP, PAGE_NAME, null)).thenReturn(pageMenues);

		this.mockMvc
		.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name(buildPagePath(PAGE_GROUP, PAGE_NAME, "html")))
		.andExpect(model().attribute(SIDE_LEFT.name(), hasProperty("code", is("MAIN"))));
		// Una vez para buscar los menues y la otra para buscar el titulo y subtitulo de la pagina
		verify(this.pageService, times(1)).findByGroupAndName(PAGE_GROUP, PAGE_NAME);
		verifyNoMoreInteractions(this.pageService);
	}

	@Override
	protected Object[] getMocks () {
		return new Object[] {this.menuService, this.pageService};
	}
}