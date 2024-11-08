package org.example.lab9_20210795;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class MealsDao {
    public List<Meals> listar() {

        List<Meals> lista = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();

        String endPoint = "http://localhost:8080/product";

        ResponseEntity<Meals[]> responseEntity = restTemplate.getForEntity(endPoint, Meals[].class);

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            Meals[] body = responseEntity.getBody();
            lista = Arrays.asList(body);
        }

        return lista;
    }
}
