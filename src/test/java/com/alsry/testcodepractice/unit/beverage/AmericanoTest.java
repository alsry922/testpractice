package com.alsry.testcodepractice.unit.beverage;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmericanoTest {
    @Test
    void getName() {
        Americano americano = new Americano();
        Assertions.assertThat(americano.getName()).isEqualTo("아메리카노");
    }

    @Test
    void name() {
        Americano americano = new Americano();
        Assertions.assertThat(americano.getPrice()).isEqualTo(4000);
    }
}
