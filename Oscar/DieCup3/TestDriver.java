
/**
 * Write a description of class TestDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class TestDriver {
    private DieCup dc;
    private DieCup dc1;
    private DieCup dc2;
    private double averageDieNo = 0;
    private int dc1Win = 0;
    private int dc2Win = 0;
    private int dc1Edc2 = 0;

    TestDriver(int noOfDies) {
        dc = new DieCup(noOfDies);
    }

    public void test() {
        dc.roll();
        System.out.println(dc.getEyes());

    }

    public void multipleRolls(int noOfRolls) {
        for (int i = 1; i <= noOfRolls; i++) {
            dc.roll();
            System.out.println("Throw no" + i + ":" + "" + dc.getEyes());
            averageDieNo += dc.getEyes();
        }
        System.out.println("Average no of eyes: " + averageDieNo / noOfRolls);
        averageDieNo = 0;
    }

    void compareDieCups(int noOfDies1, int noOfDies2, int noOfRolls) {
        dc1 = new DieCup(noOfDies1);
        dc2 = new DieCup(noOfDies2);
        for (int i = 1; i <= noOfRolls; i++) {
            dc1.roll();
            dc2.roll();
            if (dc1.getEyes() > dc2.getEyes()) {
                dc1Win += 1;
            } else if (dc1.getEyes() < dc2.getEyes()) {
                dc2Win += 1;
            } else {
                dc1Edc2 += 1;
            }
        }
        System.out.println("DieCup 1 with" + noOfDies1 + "dies is highest:" + dc1Win + "times");
        System.out.println("DieCup 2 with" + noOfDies2 + "dies is highest:" + dc2Win + "times");
        System.out.println("Same score in both:" + dc1Edc2 + "times");
    }
}
