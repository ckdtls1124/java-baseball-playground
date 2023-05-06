package numberbaseball;

public class RandomNumberGenerator {

    public static int numberGenerator(){

        double ranNum = Math.random()*1000;

        int threeDigitRandomNum=0;
        if(ranNum >= 100){
            double flooredNum = Math.floor(ranNum);

            threeDigitRandomNum = (int) flooredNum;

        }

        return threeDigitRandomNum;
    }

}
