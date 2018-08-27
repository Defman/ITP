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
    private int sides;

    /**
     * Constructor for Die objects
     */
    public Die() {
        this(new Random(), 6);
    }

    /**
     * Constructor for Die objects
     */
    public Die(int sides) {
        this(new Random(), sides);
    }
    
    /**
     * Constructor for Die objects
     */
    public Die(Random random, int sides) {
        if(sides < 2)
            throw new IllegalArgumentException("The number of sides cannot be less than two.");
        this.random = random;
        this.sides = sides;
        this.roll();
    }
    
    /**
     * Obtain a new number of eyes for this die
     */
    public int roll() {
        this.eyes = random.nextInt(this.sides) + 1;
        return getEyes();
    }

    /**
     * Return the number of eyes shown by this die
     */
    public int getEyes() {
        return this.eyes;
    }
}
