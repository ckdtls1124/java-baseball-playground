package numberbaseball;

public class RandomNumberGenerator {

    public static int numberGenerator() {

        double ranNum = Math.random() * 1000;
        int threeDigitRandomNum = 0;
        if(ranNum >= 100){
            threeDigitRandomNum = (int) Math.floor(ranNum);
        }
        return threeDigitRandomNum;
    }

}
