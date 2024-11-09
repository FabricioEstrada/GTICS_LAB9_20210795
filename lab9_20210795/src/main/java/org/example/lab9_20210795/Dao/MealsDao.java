package org.example.lab9_20210795.Dao;

import org.example.lab9_20210795.Entity.Meals;
import org.example.lab9_20210795.ResponseJson.MealsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Component
public class MealsDao {
    public List<Meals> listar(String searchMeal) {

        List<Meals> lista = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();

        String endPoint = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + searchMeal;

        ResponseEntity<MealsResponse> responseEntity = restTemplate.getForEntity(endPoint, MealsResponse.class);

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            MealsResponse body = responseEntity.getBody();
            if (body != null && body.getMeals() != null) {
                lista = body.getMeals(); // Obtener la lista de meals
            }
        }

        return lista;
    }
    public Meals detallesID(String ID) {
        RestTemplate restTemplate = new RestTemplate();

        // este link se ha usado de la propia API
        String endPoint = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + ID;

        ResponseEntity<MealsResponse> responseEntity = restTemplate.getForEntity(endPoint, MealsResponse.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            MealsResponse body = responseEntity.getBody();
            if (body != null && body.getMeals() != null && !body.getMeals().isEmpty()) {
                // Devuelve el primer (y único) elemento de la lista
                return body.getMeals().get(0);
            }
        }
        //si no no devuelve nada
        return null;
    }
}
