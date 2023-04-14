package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest extends IOTest{
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

//    ==========================================
    public class SetTest {
        private Set<Integer> numbers;

        public SetTest() {
        }

        @BeforeEach
        void setUp() {
            numbers = new HashSet();
            numbers.add(1);
            numbers.add(1);
            numbers.add(2);
            numbers.add(3);
        }

        void checkSizeSet() {
            Assertions.assertThat(this.numbers.size()).isEqualTo(3);
        }
    }
    @Test
    void testSetTest() {
        SetTest setTest = new SetTest();
        setTest.setUp();
        setTest.checkSizeSet();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_ShouldReturnTrueIfNumberIsInSet(int num) {
        SetTest setTest = new SetTest();
        setTest.setUp();
        assertTrue(setTest.numbers.contains(num));
    }

    @ParameterizedTest
    @CsvSource(
            value = {"1:true", "2:true", "3:true", "4:false", "5:false"},
            delimiter = ':'
    )
    void checkNumInSet(String input, String expected) {
        SetTest setTest = new SetTest();
        setTest.setUp();
        Integer num = Integer.valueOf(String.valueOf(input));
        boolean actualValue = setTest.numbers.contains(num);
        assertEquals(expected, String.valueOf(actualValue));
    }

//    =====================================================================
    String[] inputStringConvertToList() {

        systemIn("2 + 3 * 4 / 2 - 5 - 5");
        return this.ListConverter();
    }

    String[] ListConverter() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        return values;
    }

    @Test
    void calculate2() {
        String[] calList = inputStringConvertToList();
        int[] numberList = stringNumArrayToIntArray(calList);
        String[] calSymbolList = toCalculateSymbolsArray(calList);
        int result = numberList[0];

        for(int i = 0; i < calSymbolList.length; ++i) {
            int CalResult;
            if (calSymbolList[i].equals("+")) {
                CalResult = add(result, numberList[i + 1]);
                result = CalResult;
            } else if (calSymbolList[i].equals("-")) {
                CalResult = subtract(result, numberList[i + 1]);
                result = CalResult;
            } else if (calSymbolList[i].equals("*")) {
                CalResult = multiple(result, numberList[i + 1]);
                result = CalResult;
            } else if (calSymbolList[i].equals("/")) {
                CalResult = divide(result, numberList[i + 1]);
                result = CalResult;
            }
        }

        System.out.println("This is final result :" + result);
    }

    int[] stringNumArrayToIntArray(String[] originalList) {
        int[] newNumberList = new int[originalList.length / 2 + 1];

        for(int index = 0; index < originalList.length; ++index) {
            if (index % 2 == 0) {
                newNumberList[index / 2] = stringNumToIntConverter(originalList[index]);
            }
        }

        return newNumberList;
    }

    String[] toCalculateSymbolsArray(String[] originalList) {
        String[] newCalSymbolList = new String[originalList.length / 2];

        for(int index = 0; index < originalList.length; ++index) {
            if (index % 2 == 1) {
                newCalSymbolList[index / 2] = originalList[index];
            }
        }

        return newCalSymbolList;
    }

    int stringNumToIntConverter(String a) {
        return Integer.parseInt(a);
    }

//    사칙연산

    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiple(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        return b != 0 ? a / b : 0;
    }


}
