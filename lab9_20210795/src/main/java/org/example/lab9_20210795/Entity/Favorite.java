package org.example.lab9_20210795.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="favoritemeal")
@Getter
@Setter
public class Favorite {
    @Id
    @Column(name="idFavoriteMeal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFavoriteMeal;

    private String idMeal;
    private String strMeal;
    private String strMealThumb;
    private String strCategory;
}
