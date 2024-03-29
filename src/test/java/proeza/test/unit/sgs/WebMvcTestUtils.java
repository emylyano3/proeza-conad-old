package proeza.test.unit.sgs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.proeza.system.entity.Item;
import com.proeza.system.entity.Menu;
import com.proeza.system.entity.MenuItem;
import com.proeza.system.entity.MenuType;
import com.proeza.system.entity.Page;
import com.proeza.system.entity.builder.ItemBuilder;
import com.proeza.system.entity.builder.MenuBuilder;
import com.proeza.system.entity.builder.MenuItemBuilder;
import com.proeza.system.entity.builder.PageBuilder;

import static com.proeza.system.entity.MenuType.*;

public class WebMvcTestUtils {

    private static long id;

    /**
     * Construye un item de menu simple. Los atributos no pasados por parametro son seteados en valores default. El
     * icono es seteado a null.
     */
    public static Item buildItem (String code, String link) {
        long id = getNextId();
        return new ItemBuilder()
            .withId(id)
            .withCode(code)
            .withLink(link)
            .withIcon(null)
            .withText(code + " " + id)
            .withTooltip("Menu item " + code + " numero " + id)
            .build();
    }

    /**
     * Construye un menu simple. Los atributos no pasados por parametro son seteados en valores default. El icono es
     * seteado a null.
     */
    public static Menu buildMenu (String code, MenuType type) {
        long id = getNextId();
        return new MenuBuilder()
            .withId(id)
            .withCode(code)
            .withIcon(null)
            .withText(code + " " + id)
            .withTooltip("Menu " + code + " numero " + id)
            .withType(type.name())
            .build();
    }

    /**
     * Construye una asociacion entre menu e item.
     */
    public static MenuItem buildMenuItem (int index, Item item, Menu menu) {
        long id = getNextId();
        return new MenuItemBuilder()
            .withId(id)
            .withIndex(index)
            .withItem(item)
            .withMenu(menu)
            .build();
    }

    /**
     * Construye una pagina. Los atributos no pasados por parametro son seteados en valores default.
     */
    public static Page buildPage (String group, String name, Set<Menu> menues) {
        long id = getNextId();
        return new PageBuilder()
            .withId(id)
            .withGroup(group)
            .withName("Pagina " + name + " numero " + id)
            .withMenues(menues)
            .build();
    }

    /**
     * Crea un left menu base compuesto por los items de menu que estan presentes en toda la aplicacion.
     */
    public static Menu buildBaseLeftMenu () {
        Item itemHome = buildItem("MI_HOME", "inicio");
        Menu menu = buildMenu("MAIN", SIDE_LEFT);
        MenuItem menuItemHome = buildMenuItem(1, itemHome, menu);
        Set<MenuItem> items = new HashSet<>(Arrays.asList(menuItemHome));
        menu.setItems(items);
        return menu;
    }

    public static String buildPagePath (String group, String name, String suffix) {
       return new StringBuilder()
            .append(group)
            .append("/")
            .append(name)
            .append(".")
            .append(suffix)
            .toString();
    }

    private synchronized static long getNextId () {
        return ++id;
    }
}