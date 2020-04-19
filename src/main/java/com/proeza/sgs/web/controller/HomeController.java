package com.proeza.sgs.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proeza.core.classmapper.Mapeable;
import com.proeza.sgs.web.PageConfig;
import com.proeza.system.service.IMenuService;
import com.proeza.system.service.IPageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

    public static final String PAGE_GROUP = "root";
    public static final String PAGE_NAME  = "home";

    @Autowired
    private IMenuService       menuService;

    @Autowired
    private IPageService       pageService;

    @ModelAttribute
    public void menues (final ModelMap model, final Principal principal) {
    	log.info("Home. User:" + principal != null ? principal.getName() : null);
        model.addAllAttributes(this.menuService.getMenus(PAGE_GROUP, PAGE_NAME, principal));
    }

    @RequestMapping({"/", "/home"})
    public String home (ModelMap model) {
        model.addAttribute("pageConfig", buildPageConfig(PAGE_GROUP, PAGE_NAME));
        return PAGE_GROUP + "/" + PAGE_NAME + ".html";
    }

    private Mapeable buildPageConfig(String group, String page) {
        return new PageConfig().mapFrom(this.pageService.findByGroupAndName(group, page));
    }
}