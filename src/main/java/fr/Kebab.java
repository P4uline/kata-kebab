package fr;

import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static fr.Kebab.Ingredient.poisson;
import static fr.Kebab.Ingredient.viande;

/**
 * Created by pauline on 07/04/17.
 */
public class Kebab {



    public enum Ingredient {viande, salade, tomate, oignon, oeuf, fromage, poisson};


    private List<Ingredient> ingredients;

    @Override
    public String toString() {
        return "Kebab{" +
                "ingredients=" + ingredients +
                '}';
    }

    public Kebab(Ingredient ... ingredients) {
        List<Ingredient> tmp= new LinkedList<Ingredient>();
        Collections.addAll(tmp, ingredients);
        this.ingredients = tmp;
    }

    public boolean isVegetarien() {
        return ingredients.stream().anyMatch(i -> !EnumSet.of(viande, poisson).contains(i));
    }

    public boolean isPessetarien(){
        return !ingredients.contains(viande);
    }

    public Kebab removeOignon() {
        this.ingredients = ingredients.stream()
                .filter(i -> !i.equals(Ingredient.oignon))
                .collect(Collectors.<Ingredient>toList());
        return this;
    }

    public Kebab doubleCheese() {
        this.ingredients = ingredients.stream().flatMap(i -> {
            if (i.equals(Ingredient.fromage))
                return Stream.of(Ingredient.fromage, Ingredient.fromage);
            else
                return Stream.of(i);
        }).collect(Collectors.toList());
        return this;
    }

    public static void main (String[] args) {
        Kebab kebab = new Kebab(Ingredient.poisson, Ingredient.salade, Ingredient.oeuf, Ingredient.oignon, Ingredient.oignon, Ingredient.fromage);
        System.out.println(kebab);
        System.out.println("vegetarien: " + kebab.isVegetarien());
        System.out.println("pessetarien: " + kebab.isPessetarien());

        System.out.println(kebab.removeOignon());

        System.out.println(kebab.doubleCheese());

    }


}
