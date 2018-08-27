/**
 * This class models a DieCup (raflebæger)
 * 
 * @author Kurt Jensen
 * @version 2017-05-01
 */
public class DieCup {
    private Die d1;   //first die
    private Die d2;   //second die
    private int maxEyes = 0; //max number on die1+die2
   

    /**
     * Constructor for DieCup objects
     */
    public DieCup(int sides1, int sides2) {
        d1 = new Die(sides1);
        d2 = new Die(sides2);
    }

    /**
     * Obtain a new number of eyes for both dies
     */
    public void roll() {
        d1.roll();
        d2.roll();
        if(maxEyes<d1.getEyes()+d2.getEyes()){
            maxEyes = d1.getEyes()+d2.getEyes();
        }
    }

    /**
     * Return the sum of the number of eyes shown by the two dies
     */
    public int getEyes() {
        return d1.getEyes()+d2.getEyes();
    }

    /**
     * Return the sum of the maximum nummer rolled by two dies
     */
    public int getMaxEyes(){
        return maxEyes;
    }

    /**
     * Resets maxEyes
     */
    public void resetMaxEyes(){
        maxEyes = 0;
    }

}
