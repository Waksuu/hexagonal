package pl.kacper.starzynski.hexagon;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class HexagonApplicationTests {

    @Test
    void contextLoads() {

        var base = new BigDecimal("100");
        var substract = new BigDecimal("120");

        var c = substract.compareTo(base) < 0;
    }

}
