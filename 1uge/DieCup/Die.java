// import class for generation of random numbers
import java.util.Random;

/**
 * This class models a Die (terning)
 * 
 * @author Kurt Jensen
 * @version 2017-01-05
 */
public class Die {
    private Random random;   //used for generation of random numbers
    private int eyes;       //number of eyes shown

    /**
     * Constructor for Die objects
     */
    public Die() {
        this(new Random());
    }

    /**
     * Constructor for Die objects
     */
    public Die(Random random) {
        this.random = random;
        this.roll();
    }
    
    /**
     * Obtain a new number of eyes for this die
     */
    public int roll() {
        this.eyes = random.nextInt(6) + 1;
        return getEyes();
    }

    /**
     * Return the number of eyes shown by this die
     */
    public int getEyes() {
        return this.eyes;
    }
}
