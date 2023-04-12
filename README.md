## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.
<!--  ==========================================================================================================-->
public abstract class IOTest {
    public IOTest() {
    }

    protected void systemIn(String input) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
    }
}


public class StringTest extends IOTest {
    public StringTest() {
    }

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        Assertions.assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitTest1() {
        String[] actual = "1,2".split(",");
        Assertions.assertThat(actual[0]).contains(new CharSequence[]{"1"});
    }

    @Test
    void splitTest2() {
        String[] actual = "1,2".split(",");
        Assertions.assertThat(actual[1]).contains(new CharSequence[]{"2"});
    }

    @Test
    void splitTest3() {
        String[] actual = "1".split(",");
        Assertions.assertThat(actual).containsExactly(new String[]{"1"});
    }

    @Test
    void splitTest4() {
        String actual = "(1,2)".substring(1, 4);
        System.out.println(actual);
    }

    @Test
    void charAtTest() {
        char actual = "abc".charAt(2);
    }

    @Test
    void charAtTestError() {
        ((AbstractThrowableAssert)Assertions.assertThatThrownBy(() -> {
            throw new IndexOutOfBoundsException("Wrong");
        }).isInstanceOf(IndexOutOfBoundsException.class)).hasMessageContaining("Wrong");
    }

    @Test
    void testSetTest() {
        SetTest setTest = new SetTest();
        setTest.setUp();
        setTest.checkSizeSet();
    }

    @ParameterizedTest
    @ValueSource(
        ints = {1, 2, 3}
    )
    void contains_ShouldReturnTrueIfNumberIsInSet(int num) {
        SetTest setTest = new SetTest();
        setTest.setUp();
        org.junit.jupiter.api.Assertions.assertTrue(setTest.numbers.contains(num));
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
        org.junit.jupiter.api.Assertions.assertEquals(expected, String.valueOf(actualValue));
    }

    String[] inputStringConvertToList() {
        this.systemIn("2 + 3 * 4 / 2 - 5");
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
        String[] calList = this.inputStringConvertToList();
        int[] numberList = this.stringNumArrayToIntArray(calList);
        String[] calSymbolList = this.toCalculateSymbolsArray(calList);
        int result = numberList[0];

        for(int i = 0; i < calSymbolList.length; ++i) {
            int CalResult;
            if (calSymbolList[i].equals("+")) {
                CalResult = this.add(result, numberList[i + 1]);
                result = CalResult;
            } else if (calSymbolList[i].equals("-")) {
                CalResult = this.subtract(result, numberList[i + 1]);
                result = CalResult;
            } else if (calSymbolList[i].equals("*")) {
                CalResult = this.multiple(result, numberList[i + 1]);
                result = CalResult;
            } else if (calSymbolList[i].equals("/")) {
                CalResult = this.divide(result, numberList[i + 1]);
                result = CalResult;
            }
        }

        System.out.println("This is final result :" + result);
    }

    int[] stringNumArrayToIntArray(String[] originalList) {
        int[] newNumberList = new int[originalList.length / 2 + 1];

        for(int index = 0; index < originalList.length; ++index) {
            if (index % 2 == 0) {
                newNumberList[index / 2] = this.stringNumToIntConverter(originalList[index]);
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

    public class SetTest {
        private Set<Integer> numbers;

        public SetTest() {
        }

        @BeforeEach
        void setUp() {
            this.numbers = new HashSet();
            this.numbers.add(1);
            this.numbers.add(1);
            this.numbers.add(2);
            this.numbers.add(3);
        }

        void checkSizeSet() {
            Assertions.assertThat(this.numbers.size()).isEqualTo(3);
        }
    }
}
