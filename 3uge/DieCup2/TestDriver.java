import java.util.Arrays;

public class TestDriver
{
    public static void test() {
        DieCup dieCup = new DieCup(6, 6);
        System.out.printf("You rolled %d\n",dieCup.roll());
    }
    
    public static void testMultiple(int noOfDies, int noOfRolls) {
        DieCup dieCup = new DieCup(noOfDies);
        double average = 0;
        for (int i = 0; i < noOfRolls; i++) {
            System.out.printf("Throw no %d: %d \n", i + 1, dieCup.roll());
            average = (average * i + dieCup.getEyes()) / (i + 1);
        }
        System.out.printf("Average no of eyes: %.2f\n", average);
    }
    
    public static void compareDieCups(int noOfDies, int noOfRolls) {
        int sides[] = new int[noOfDies];
        Arrays.fill(sides, 6);
        DieCup dieCup1 = new DieCup(sides);
        DieCup dieCup2 = new DieCup(sides);
        int w1 = 0;
        int w2 = 0;
        for (int i = 0; i < noOfRolls; i++) {
            w1 += dieCup1.roll() > dieCup2.roll() ? 1 : 0;
            w2 += dieCup2.getEyes() > dieCup1.getEyes() ? 1 : 0;
        }
        System.out.printf("DieCup 1 with %d dies is highest: %d times\n" +
            "DieCup 2 with %d dies is highest: %d times\n" +
            "Same score in both: %d times", 
            noOfDies, w1, noOfDies, w2, noOfRolls - w1 - w2);
    }
    
    public static void test4638(int noOfRolls) {
        DieCup dieCup = new DieCup(4, 6, 3, 8);
        double average = 0;
        for (int i = 0; i < noOfRolls; i++) {
            System.out.printf("Throw no %d: %d \n", i + 1, dieCup.roll());
            average = (average * i + dieCup.getEyes()) / (i + 1);
        }
        System.out.printf("Average no of eyes: %.2f\n", average);
    }
}
