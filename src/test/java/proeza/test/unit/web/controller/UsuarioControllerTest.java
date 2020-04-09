package proeza.test.unit.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.proeza.security.service.IRoleService;
import com.proeza.sgs.web.controller.UsuarioController;
import com.proeza.system.dao.IPageDao;
import com.proeza.system.entity.Item;
import com.proeza.system.entity.Menu;
import com.proeza.system.entity.MenuItem;
import com.proeza.system.entity.MenuType;
import com.proeza.system.entity.Page;
import com.proeza.system.service.IMenuService;
import com.proeza.system.service.IPageService;
import com.proeza.system.service.dto.MenuDTO;
import com.proeza.system.service.dto.PageDTO;

import static com.proeza.system.entity.MenuType.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static proeza.test.unit.web.WebMvcTestUtils.*;

import proeza.test.unit.web.WebMvcUnitTest;

public class UsuarioControllerTest extends WebMvcUnitTest {

	@Autowired
	private IPageDao		pageDao;

	@Autowired
	private IMenuService	menuService;

	@Autowired
	private IPageService	pageService;

	@Autowired
	private IRoleService	rolService;

	@Test
	public void usuarioControllerTest_HOME () throws Exception {
		Menu menu = buildBaseLeftMenu();
		// Creo un item adicional para el menu que apunte a la funcionalidad admin
		Item itemAdmin = buildItem("MI_ADMIN", "usuario/admin");
		MenuItem menuItemAlta = buildMenuItem(1, itemAdmin, menu);
		menu.getItems().add(menuItemAlta);
		Set<Menu> menues = new HashSet<>();
		menues.add(menu);
		Page page = buildPage("usuario", "home", menues);

		Map<String, MenuDTO> pageMenues = new HashMap<>();
		pageMenues.put(SIDE_LEFT.name(), new MenuDTO(null, "MAIN", "MAIN"));
		when(this.menuService.getMenus(UsuarioController.PAGE_GROUP, "home", null)).thenReturn(pageMenues);
		when(this.pageDao.findByGroupAndName(UsuarioController.PAGE_GROUP, "home")).thenReturn(page);
		when(this.pageService.findByGroupAndName(UsuarioController.PAGE_GROUP, "home")).thenReturn(new PageDTO(page));
		when(this.rolService.findAll()).thenReturn(new ArrayList<>());

		this.mockMvc
		.perform(get("/usuario/home"))
		.andExpect(status().isOk())
		.andExpect(view().name("usuario/home.html"))
		.andExpect(model().attribute(MenuType.SIDE_LEFT.name(), hasProperty("code", is("MAIN"))));

		// Una vez para buscar los menues y la otra para buscar el titulo y subtitulo de la pagina
		verify(this.pageService, times(1)).findByGroupAndName(UsuarioController.PAGE_GROUP, "home");
		verifyNoMoreInteractions(this.pageService);
	}

	@Override
	protected Object[] getMocks () {
		return new Object[] {this.menuService, this.pageService, this.pageDao, this.rolService};
	}
}