package fr;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static fr.Kebab.Ingredient.*;

/**
 * Created by pauline on 07/04/17.
 */

public class KebabTest {

    private Kebab kebab;

    @Test
    public void should_remove_oignon() {
        kebab = new Kebab(oignon, salade, tomate);
        Assertions.assertThat(kebab.removeOignon().toString()).doesNotContain(oignon.toString());
    }

    @Test
    public void should_remove_2_oignon_consecutifs() {
        kebab = new Kebab(oignon, oignon, salade, tomate);
        Assertions.assertThat(kebab.removeOignon().toString()).doesNotContain(oignon.toString());
    }

    @Test
    public void should_double_cheese() {
        kebab = new Kebab(oignon, oignon, salade, fromage, tomate);
        Assertions.assertThat(kebab.doubleCheese().toString()).contains("oignon, oignon, salade, fromage, fromage, tomate");
    }

    @Test
    public void should_double_2_cheeses() {
        kebab = new Kebab(oignon, oignon, salade, fromage, fromage, tomate);
        Assertions.assertThat(kebab.doubleCheese().toString()).contains("oignon, oignon, salade, fromage, fromage, fromage, fromage, tomate");
    }

    @Test
    public void should_be_vegetarien_when_does_not_contain_meet_nor_fish() {
        kebab = new Kebab(oignon, oignon, salade, fromage, fromage, tomate);
        Assertions.assertThat(kebab.isVegetarien()).isTrue();
    }

    @Test
    public void should_be_pessetarein_when_does_not_contain_meet() {
        kebab = new Kebab(oignon, oignon, salade, fromage, poisson, fromage, tomate);
        Assertions.assertThat(kebab.isPessetarien()).isTrue();
    }

    @Test
    public void should_be_pessetarein_when_does_not_contain_meet_nor_fish() {
        kebab = new Kebab(oignon, oignon, salade, fromage, fromage, tomate);
        Assertions.assertThat(kebab.isPessetarien()).isTrue();
    }

}
