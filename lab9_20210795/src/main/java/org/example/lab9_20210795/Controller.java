package org.example.lab9_20210795;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/categories")
public class Controller {
    final MealsDao mealsDao;
    final CategoriesDao categoriesDao;

    public Controller(MealsDao mealsDao, CategoriesDao categoriesDao) {
        this.mealsDao = mealsDao;
        this.categoriesDao = categoriesDao;
    }
    @GetMapping({"/list", "", "/"})
    public String listarProductos(Model model) {
        model.addAttribute("listCategories", categoriesDao.listar());
        return "list";
    }
}
