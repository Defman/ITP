public class TestDriver
{
    public static void test() {
        DieCup dieCup = new DieCup();
        System.out.printf("You rolled %d\n",dieCup.roll());
    }
    
    public static void testMultiple(int noOfRolls) {
        DieCup dieCup = new DieCup();
        double average = 0;
        for (int i = 0; i < noOfRolls; i++) {
            System.out.printf("Throw no %d: %d \n", i + 1, dieCup.roll());
            average = (average * i + dieCup.getEyes()) / (i + 1);
        }
        System.out.printf("Average no of eyes: %.2f\n", average);
    }
    
    public static void compareDieCups(int s1, int s2, int s3, int s4, int noOfRolls) {
        DieCup dieCup1 = new DieCup(s1, s2);
        DieCup dieCup2 = new DieCup(s3, s4);
        int w1 = 0;
        int w2 = 0;
        for (int i = 0; i < noOfRolls; i++) {
            w1 += dieCup1.roll() > dieCup2.roll() ? 1 : 0;
            w2 += dieCup2.getEyes() > dieCup1.getEyes() ? 1 : 0;
        }
        System.out.printf("DieCup 1 with %d and %d sides is highest: %d times\n" +
            "DieCup 2 with %d and %d sides is highest: %d times\n" +
            "Same score in both: %d times", 
            s1, s2, w1, s3, s4, w2, noOfRolls - w1 - w2);
    }
}
