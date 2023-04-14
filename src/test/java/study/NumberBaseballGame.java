package study;

import sun.tools.java.Scanner;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGame {

    void startGameInput(String startNumber) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(startNumber.getBytes());
        System.setIn(byteArrayInputStream);
    }

    String generateRandomNumbers() {
        int intResult = (int) Math.floor(Math.random() * 1000);
        String result="";
        if (intResult > 99) {
            result = result + String.valueOf(Integer.valueOf(intResult));
        }
        return result;
    }


    String userGuessInput(String guessNumber) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(guessNumber.getBytes());
        System.setIn(byteArrayInputStream);
        return guessNumber;
    }
    public static void main(String[] args) throws IOException {


    }


    List<Integer> stringNumbersToIntListConverter(String stringNumbers) {
        char[] stringNumbersArray = new char[stringNumbers.length()];
        List<Integer> intList = new ArrayList<>();
        for (char eachNumber : stringNumbersArray) {
            int convertedNumber = changeCharNumberToInt(eachNumber);
            intList.add(convertedNumber);
        }
        return intList;
    }

    int changeCharNumberToInt(char stringNumber) {
        Integer intNumber = Integer.valueOf(stringNumber);
        return intNumber;
    }




}
