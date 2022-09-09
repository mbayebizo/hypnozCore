package net.hypnozcore.hypnozcore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HypnozCoreApplicationTests {

    @Test
    void contextLoads() {
        String actual="test";
        String expected="test";
        assertThat(actual).as("assertion desc").isEqualTo(expected);
    }

}
