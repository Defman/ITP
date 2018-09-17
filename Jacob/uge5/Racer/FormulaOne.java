import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class FormulaOne
{
    private String name;
    private Set<Racer> racers;
    
    public FormulaOne(String name) {
        this.name = name;
        this.racers = new HashSet();
    }
    
    public FormulaOne(String name, Racer...racers) {
        this.name = name;
        this.racers = new HashSet(Arrays.asList(racers));
    }
    
    public void add(Racer r) {
        this.racers.add(r);
    }
    
    public int averageTopSpeed() {
        int sum = 0;
        for (Racer r : racers)
            sum += r.getTopSpeed();
        return sum / racers.size();
    }
    
    public Racer fastestRacer() {
        Racer fastest = null;
        for (Racer r : racers)
            fastest = fastest == null || 
                        r.getTopSpeed() > fastest.getTopSpeed() ? r : fastest;
        return fastest;
    }
    
    public void printFormulaOne(){
        System.out.println(this.name);
        Racer[] racers = new Racer[this.racers.size()];
        racers = this.racers.toArray(racers);
        for (int j = 1; j < racers.length; j++) {
            Racer key = racers[j];
            int i = j;
            while (i > 0 && (racers[i - 1].getYear() > key.getYear() || 
                    (racers[i - 1].getYear() == key.getYear() &&
                    racers[i - 1].getName().compareTo(key.getName()) > 0))) {
                racers[i] = racers[i - 1];
                i -= 1;
            }
            racers[i] = key;
        }
        for (Racer r : racers)
            System.out.println(r);
    }
    
}
