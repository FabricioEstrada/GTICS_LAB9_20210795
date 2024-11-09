package org.example.lab9_20210795.Controller;

import org.example.lab9_20210795.Dao.CategoriesDao;
import org.example.lab9_20210795.Dao.MealsDao;
import org.example.lab9_20210795.Entity.Categories;
import org.example.lab9_20210795.Entity.Favorite;
import org.example.lab9_20210795.Entity.Meals;
import org.example.lab9_20210795.Repository.FavoriteRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/TeleMeal")
public class Controller {
    final MealsDao mealsDao;
    final CategoriesDao categoriesDao;
    final FavoriteRepository favoriteRepository;

    public Controller(MealsDao mealsDao, CategoriesDao categoriesDao, FavoriteRepository favoriteRepository) {
        this.mealsDao = mealsDao;
        this.categoriesDao = categoriesDao;
        this.favoriteRepository = favoriteRepository;
    }
    @GetMapping({"/list", "/", ""})
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
        return "list";
    }
    @GetMapping("/details")
    public String getMealDetails(@RequestParam("id") String id, Model model) {
        Meals meal = mealsDao.detallesID(id);
        model.addAttribute("meal", meal);

        Optional<Favorite> favorite = favoriteRepository.findByIdMeal(id);

        if (favorite.isPresent()) {
            model.addAttribute("favoriteAdded", true);
        } else {
            model.addAttribute("favoriteAdded", false);
        }
        return "mealDetails";
    }

    @PostMapping("/favorito")
    public String addFavorite(@RequestParam("mealId") String mealId,
                              @RequestParam("mealName") String mealName,
                              @RequestParam("mealImage") String mealImage,
                              @RequestParam("mealCategory") String mealCategory,
                              Model model) {

        Favorite favorite = new Favorite();
        favorite.setIdMeal(mealId);
        favorite.setStrMeal(mealName);
        favorite.setStrMealThumb(mealImage);
        favorite.setStrCategory(mealCategory);

        favoriteRepository.save(favorite);
        return "redirect:/TeleMeal/details?id=" + mealId;
    }
    @GetMapping("/listMyFavorites")
    public String listarFavoritos(Model model) {

        // Si no hay busqeudas, muestro como antes todas las categorias
        List<Favorite> listaFavoritos = favoriteRepository.findAll();
        model.addAttribute("listaFavoritos", listaFavoritos);  // Pasa la lista de comidas a la vista
        return "listFavorite";
    }
}
