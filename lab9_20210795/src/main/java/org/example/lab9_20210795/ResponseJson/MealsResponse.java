package org.example.lab9_20210795.ResponseJson;

import lombok.Getter;
import lombok.Setter;
import org.example.lab9_20210795.Entity.Meals;

import java.util.List;

@Getter
@Setter
public class MealsResponse {
    //Se ha añadido una clase extra debido a que el json responde de esta forma:
    /*
     "meals": [
        {
            "idMeal": "53036",
            "strMeal": "Boxty Breakfast",
            "strDrinkAlternate": null,
            "strCategory": "Pork",
            "strArea": "Irish",
            "strInstructions": "STEP 1\r\nBefore you start, put your oven on its lowest setting, ready to keep things warm. Peel the potatoes, grate 2 of them, then set aside. Cut the other 2 into large chunks, then boil for 10-15 mins or until tender. Meanwhile, squeeze as much of the liquid from the grated potatoes as you can using a clean tea towel. Mash the boiled potatoes, then mix with the grated potato, spring onions and flour.\r\n\r\nSTEP 2\r\nWhisk the egg white in a large bowl until it holds soft peaks. Fold in the buttermilk, then add the bicarbonate of soda. Fold into the potato mix.\r\n\r\nSTEP 3\r\nHeat a large non-stick frying pan over a medium heat, then add 1 tbsp butter and some of the oil. Drop 3-4 spoonfuls of the potato mixture into the pan, then gently cook for 3-5 mins on each side until golden and crusty. Keep warm on a plate in the oven while you cook the next batch, adding more butter and oil to the pan before you do so. You will get 16 crumpet-size boxty from the mix. Can be made the day ahead, drained on kitchen paper, then reheated in a low oven for 20 mins.\r\n\r\nSTEP 4\r\nHeat the grill to medium and put the tomatoes in a heavy-based pan. Add a good knob of butter and a little oil, then fry for about 5 mins until softened. Grill the bacon, then pile onto a plate and keep warm. Stack up the boxty, bacon and egg, and serve the tomatoes on the side.",
            "strMealThumb": "https://www.themealdb.com/images/media/meals/naqyel1608588563.jpg",
            "strTags": null,
            "strYoutube": "https://www.youtube.com/watch?v=80W0mCFDIP0",
            "strIngredient1": "Potatoes",
            y mas...
        },
    * */
    private List<Meals> meals;
}
