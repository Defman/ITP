
/**
 * Write a description of class TestDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class TestDriver {
    private DieCup dc1;
    private DieCup dc2;
    private DieCup dc3;
    private double averageDieNo = 0;
    private int dc2Win = 0;
    private int dc3Win = 0;
    private int dc2Edc3 = 0;

    TestDriver(int sides1, int sides2) {
        dc1 = new DieCup(sides1, sides2);
    }

    public void test() {
        dc1.roll();
        System.out.println(dc1.getEyes());

    }

    public void multipleRolls(int noOfRolls) {
        for (int i = 1; i <= noOfRolls; i++) {
            dc1.roll();
            System.out.println("Throw no" + i + ":" + "" + dc1.getEyes());
            averageDieNo += dc1.getEyes();
        }
        System.out.println("Average no of eyes: " + averageDieNo / noOfRolls);
        averageDieNo = 0;
    }

    void compareDieCups(int s1, int s2, int s3, int s4, int noOfRolls) {
        dc2 = new DieCup(s1, s2);
        dc3 = new DieCup(s3, s4);
        for (int i = 1; i <= noOfRolls; i++) {
            dc2.roll();
            dc3.roll();
            if (dc2.getEyes() > dc3.getEyes()) {
                dc2Win += 1;
            } else if (dc2.getEyes() < dc3.getEyes()) {
                dc3Win += 1;
            } else {
                dc2Edc3 += 1;
            }
        }
        System.out.println("DieCup 1 with" + s1 + "and" + s2 + "sides is highest:" + dc2Win + "times");
        System.out.println("DieCup 2 with" + s3 + "and" + s4 + "sides is highest:" + dc3Win + "times");
        System.out.println("Same score in both:" + dc2Edc3 + "times");
    }
}
