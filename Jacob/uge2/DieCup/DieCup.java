import java.util.Random;

/**
 * This class models a DieCup (raflebæger)
 * 
 * @author Kurt Jensen
 * @version 2017-05-01
 **/
public class DieCup {
    private static ThreadLocal<Random> random = ThreadLocal.withInitial(Random::new);

    private Die d1;   //first die
    private Die d2;   //second die
    private int maxEyes;
    
    /**
     * Constructor for DieCup objects
     */
    public DieCup() {
        this(new Die(random.get()), new Die(random.get()));
    }
    
    /**
     * Constructor for DieCup objects
     */
    public DieCup(int die1, int die2) {
        this(new Die(die1), new Die(die2));
    }
    
    /**
     * Constructor for DieCup objects
     */
    public DieCup(Die d1, Die d2) {
        this.d1 = d1;
        this.d2 = d2;
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
        int sum = this.d1.roll() + this.d2.roll();
        this.maxEyes = sum > maxEyes ? sum : maxEyes;
        return sum;
    }
    
    /**
     * Return the sum of the number of eyes shown by the two dies
     */
    public int getEyes() {
        return this.d1.getEyes() + this.d2.getEyes();
    }
    
    public int getMaxEyes() {
        return this.maxEyes;
    }
    
    public void resetMaxEyes() {
        this.maxEyes = 0;
    }
}
