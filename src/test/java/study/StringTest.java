package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitTest1(){
        String[] actual = "1,2".split(",");
        assertThat(actual[0]).contains("1");
    }

    @Test
    void splitTest2(){
        String[] actual = "1,2".split(",");
        assertThat(actual[1]).contains("2");
    }

    @Test
    void splitTest3(){
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void splitTest4(){
        String actual ="(1,2)".substring(1,4);
        System.out.println(actual);
    }

    @Test
    void charAtTest(){
        char actual = "abc".charAt(2);
    }

    @Test
    void charAtTestError(){
        assertThatThrownBy(()->{
            throw new IndexOutOfBoundsException("Wrong");
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Wrong");
    }

}
