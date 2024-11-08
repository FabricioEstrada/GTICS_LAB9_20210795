package org.example.lab9_20210795;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/TeleMeal")
public class Controller {
    final MealsDao mealsDao;
    final CategoriesDao categoriesDao;

    public Controller(MealsDao mealsDao, CategoriesDao categoriesDao) {
        this.mealsDao = mealsDao;
        this.categoriesDao = categoriesDao;
    }
    @GetMapping("/list")
    public String listarMealsCategoria(@RequestParam(name = "search", required = false) String search, Model model) {

        if (search != null && !search.isEmpty()) {
            // si tiene un valor busco por comidaaaa
            List<Meals> listaMeals = mealsDao.listar(search);
            model.addAttribute("listaMeals", listaMeals);  // Pasa la lista de comidas a la vista
        } else {
            // Si no hay busqeudas, muestro como antes todas las categorias
            List<Categories> listaCategories = categoriesDao.listar();
            model.addAttribute("listaCategories", listaCategories);  // Pasa la lista de comidas a la vista
        }
        return "list";  // Devuelve la vista listMeals
    }
    @GetMapping("/details")
    public String getMealDetails(@RequestParam("id") String id, Model model) {
        // Obtén los detalles de la comida desde el DAO o servicio usando el ID
        Meals meal = mealsDao.detallesID(id); // Aquí asumo que mealsDao tiene un método findById
        model.addAttribute("meal", meal); // Pasa los detalles de la comida a la vista
        return "mealDetails"; // Devuelve la vista con los detalles de la comida
    }
}
