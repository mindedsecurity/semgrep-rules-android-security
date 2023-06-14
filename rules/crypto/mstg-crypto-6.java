import java.util.Random;
import java.lang.*;
import java.security.SecureRandom;

public class A{
    String a = "test";
    private int test(){
        return 1 + new Random().nextInt(6);
    }
    private int test2random(){
        return 1 + Math.random();
    }
    private int test3gen(){
        Random r = new Random();
        return r.nextDouble();
    }
    private int test4(){
        SecureRandom number = new SecureRandom(12);
        return number.nextInt(21);
    }
    //This case is not cover
    private int random(){
        int b = 3;
        return b + 10;
    }
    private int random(){
        SecureRandom number = new SecureRandom();
        return number.nextInt(21);
    }
    private int gen_token(){
        return abc(new Date().getTime());
    }
    private int gen_token(){
        Calendar c = Calendar.getInstance(); 
        int mseconds = c.get(Calendar.MILLISECOND)
    }
}
