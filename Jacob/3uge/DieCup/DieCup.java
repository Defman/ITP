import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class models a DieCup (rafleb�ger)
 * 
 * @author Kurt Jensen
 * @version 2017-05-01
 **/
public class DieCup {
    private Collection<Die> dies;
    private int maxEyes;
    private int sum;

    /**
     * Constructor for DieCup objects
     */
    public DieCup(int noOfDies) {
        if (noOfDies < 2)
            throw new IllegalArgumentException("DieCup cannot have less than two dies.");
        this.dies = new ArrayList(noOfDies);
        for (int i = 0; i < noOfDies; i++)
            dies.add(new Die());
    }
    
    /**
     * Constructor for DieCup objects
     */
    public DieCup(Die...dies) {
        if (dies.length < 2)
            throw new IllegalArgumentException("DieCup cannot have less than two dies.");
        this.dies = Arrays.asList(dies);
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
