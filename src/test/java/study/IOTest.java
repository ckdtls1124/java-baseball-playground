package study;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public abstract class IOTest {
    public IOTest() {
    }

    protected void systemIn(String input) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteArrayInputStream);
    }
}
