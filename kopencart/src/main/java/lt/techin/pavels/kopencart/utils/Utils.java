package lt.techin.pavels.kopencart.utils;

import java.util.Random;

public class Utils {
    public static int generateRandomNrFrom1To20 (){
        Random random = new Random();
        return random.nextInt(20)+1;
    }
}
