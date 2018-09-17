public class Driver
{
    public static void exam() {
        Racer   r1 = new Racer("a", 2000, 200),
                r2 = new Racer("b", 2001, 200),
                r3 = new Racer("c", 2002, 200),
                r4 = new Racer("d", 2003, 200),
                r5 = new Racer("e", 2002, 200);
        
        FormulaOne f1 = new FormulaOne("Monaco", r1, r2, r3, r4, r5);
        
        System.out.println(f1.averageTopSpeed());
        System.out.println(f1.fastestRacer());
        
        f1.printFormulaOne();   
    }
}
