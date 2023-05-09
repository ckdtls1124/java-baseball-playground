package numberbaseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputNumber {

    public static void inputNum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Type in 3 digits number :"+br.readLine());

    }

    public static char[] changeInputStringToIntArray(String inputNums){

        char[] result = new char[inputNums.length()];
        for(int i=0; i<result.length; i++){
            result[i] = inputNums.charAt(i);
        }

        return result;
    }

    public static int charToInt(char charInput){
        int result = charInput - '0';
        return result;
    }

}
