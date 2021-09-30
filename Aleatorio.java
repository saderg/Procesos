import java.util.Random;

public class Aleatorio {
    public static void main(String[] args) {
        
       random();
       
    }

    public static void random(){
        
        Random r = new Random();
        int x = r.nextInt(9) + 1;

        System.out.println(x);
        
    }


}
