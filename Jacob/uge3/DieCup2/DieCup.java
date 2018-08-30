import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * This class models a DieCup (rafleb�ger)
 * 
 * @author Kurt Jensen
 * @version 2017-05-01
 **/
public class DieCup {
    private static ThreadLocal<Random> random = ThreadLocal.withInitial(Random::new);
    
    private Collection<Die> dies;
    private int maxEyes;
    private int sum;
    
    /**
     * Constructor for DieCup objects
     */
    public DieCup(Die...dies) {
        if (dies.length < 1)
            throw new IllegalArgumentException("DieCup cannot have less than one die.");
        this.dies = Arrays.asList(dies);
        this.maxEyes = 0;
    }
    
    /**
     * Constructor for DieCup objects
     */
    public DieCup(int...sides) {
        if (sides.length < 1)
            throw new IllegalArgumentException("DieCup cannot have less than one die.");
        
        this.dies = new ArrayList(sides.length);
        for (int side : sides)
            this.dies.add(new Die(random.get(), side));
        this.maxEyes = 0;
    }
    
    public void multipleRolls(int noOfRolls) {
        double average = 0;
        for (int i = 0; i < noOfRolls; i++) {
            System.out.printf("Throw no %d: %d \n", i + 1, this.roll());
            average = (average * i + this.getEyes()) / (i + 1);
        }
        System.out.printf("Average no of eyes: %.2f\n", average);
    }
    
     /**
     * Obtain a new number of eyes for both dies
     */
    public int roll() {
        this.sum = 0;
        for (Die die : dies)
            this.sum += die.roll();
        this.maxEyes = this.sum > this.maxEyes ? this.sum : this.maxEyes;
        return this.sum;
    }
    
    /**
     * Return the sum of the number of eyes shown by the two dies
     */
    public int getEyes() {
        return this.sum;
    }
    
    public int getMaxEyes() {
        return this.maxEyes;
    }
    
    public void resetMaxEyes() {
        this.maxEyes = 0;
    }
}
