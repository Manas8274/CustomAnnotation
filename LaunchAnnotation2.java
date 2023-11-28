import java.lang.annotation.*;
import java.util.*;

@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface CricketPlayer {

    String country() default "India";

    int age() default 24;
}

@CricketPlayer
class Virat {

    @CricketPlayer
    private int innings;
    private int runs;

    @CricketPlayer
    public int getInnings() {
        return innings;
    }

    public void setInnings(int innings) {
        this.innings = innings;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

}

public class LaunchAnnotation2 {
    public static void main(String[] args) {

        Virat v = new Virat();
        v.setInnings(250);
        v.setRuns(15000);

        System.out.println("Innings : " + v.getInnings() + " Runs : " + v.getRuns());

        Class c = v.getClass();
        Annotation a = c.getAnnotation(CricketPlayer.class);
        CricketPlayer cp = (CricketPlayer) a;

        String country = cp.country();
        System.out.println("Country:" + country);
        int age = cp.age();
        System.out.println("Age: " + age);

    }

}