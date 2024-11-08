package org.example.lab9_20210795;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CategoriesResponse {
    //Se ha añadido una clase extra debido a que el json responde de esta forma:
    /*
        "categories": [
                {
                    "idCategory": "1",
                    "strCategory": "Beef",
                    "strCategoryThumb": "https://www.themealdb.com/images/category/beef.png",
                    "strCategoryDescription": "Beef is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating beef since prehistoric times.[1] Beef is a source of high-quality protein and essential nutrients.[2]"
                },
        Esta emcapsulado en una lista y luego en sub categorias por lo que hay que desempaquetar la lista primero
    * */
    private List<Categories> categories;
}
