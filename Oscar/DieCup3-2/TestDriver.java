
/**
 * Write a description of class TestDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class TestDriver {
    private DieCup dc;
    private DieCup dc1;
    private double averageDieNo = 0;

    TestDriver(int noOfDies) {
        dc = new DieCup(noOfDies);
    }

    void test4638(int noOfRolls) {
        dc1 = new DieCup(4, 6, 3, 8);
        for (int i = 1; i <= noOfRolls; i++) {
            dc1.roll();
            System.out.println("Throw no " + i + ":" + dc1.getEyes());
            averageDieNo += dc1.getEyes();
        }
        System.out.println("Average no of eyes:" + averageDieNo / noOfRolls);
    }
}
