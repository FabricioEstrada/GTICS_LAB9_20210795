package org.example.lab9_20210795;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CategoriesDao {
    public List<Categories> listar() {

        List<Categories> lista = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        String endPoint = "https://www.themealdb.com/api/json/v1/1/categories.php";

        ResponseEntity<CategoriesResponse> responseEntity = restTemplate.getForEntity(endPoint, CategoriesResponse.class);

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            CategoriesResponse body = responseEntity.getBody();
            if (body != null && body.getCategories() != null) {
                lista = body.getCategories(); // Obtener la lista de categorías
            }
        }

        return lista;
    }
}
