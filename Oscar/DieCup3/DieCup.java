import java.util.ArrayList;

/**
 * This class models a DieCup (rafleb�ger)
 * 
 * @author Kurt Jensen
 * @version 2017-05-01
 */
public class DieCup {
    private ArrayList<Die> dies;
    private int noOfEyes = 0;
    private double averageDieNo = 0;

    /**
     * Constructor for DieCup objects
     */
    public DieCup(int noOfDies) {
        dies = new ArrayList();
        for (int i = 0; i < noOfDies; i++) {
            dies.add(new Die(6));
        }
    }

    /**
     * Obtain a new number of eyes for both dies
     */
    public void roll() {
        noOfEyes = 0;
        for (Die die : dies) {
            die.roll();
            noOfEyes += die.getEyes();
        }
    }

    public int getEyes() {
        return noOfEyes;
    }

    public void multipleRolls(int noOfRolls) {
        for (int i = 1; i < noOfRolls; i++) {
            roll();
            System.out.println("Throw no" + i + ":" + "" + getEyes());
            averageDieNo += getEyes();
        }
        System.out.println("Average no of eyes: " + averageDieNo / noOfRolls);
        averageDieNo = 0;
    }

}
