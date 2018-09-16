import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Band
{
    private String name;
    private Set<Musician> musicians;
    
    public Band(String name) {
        this.name = name;
        this.musicians = new HashSet();
    }
    
    public Band(String name, Musician...musicians) {
        this.name = name;
        this.musicians = new HashSet(Arrays.asList(musicians));
    }
    
    public void add(Musician m) {
        musicians.add(m);
    }
    
    public void remove(Musician m) {
        musicians.remove(m);
    }
    
    public int skilledMusicians(int level) {
        /*
         * return (int) musicians.stream().filter(m -> m.getSkillLevel() > level).count();
         */
        int sum = 0;
        for (Musician m : this.musicians)
            sum += m.getSkillLevel() > level ? 1 : 0;
        return sum;
    }
    
    public Musician withInstrument(String instrument) {
        /*
         * return musicians.stream().filter(m -> m.getInstrument().equalsIgnoreCase(instrument))
         *   .findAny().get();
         */
        for (Musician m : this.musicians)
            if (m.getInstrument().equalsIgnoreCase(instrument))
                return m;
        return null;
    }
    
    public void printBand () {
        System.out.println(this.name);
        /* 
         * musicians.stream()
         *   .sorted((v1, v2) -> v1.getInstrument().equalsIgnoreCase(v2.getInstrument()) ? 
         *       v2.getSkillLevel() - v1.getSkillLevel() : 
         *       v1.getInstrument().compareTo(v2.getInstrument()))
         *   .forEach(System.out::println); 
         */
        Musician[] musicians = new Musician[this.musicians.size()];
        musicians = this.musicians.toArray(musicians);
        for (int j = 1; j < musicians.length; j++) {
            Musician key = musicians[j];
            int i = j;
            while (i > 0 && (musicians[i - 1].getInstrument().compareTo(key.getInstrument()) > 0 ||
                    (musicians[i - 1].getInstrument().equalsIgnoreCase(key.getInstrument()) && 
                    musicians[i - 1].getSkillLevel() < key.getSkillLevel()))) {
                musicians[i] = musicians[i - 1];
                i -= 1;
            }
            musicians[i] = key;
        }
        for (Musician m : musicians)
            System.out.println(m);
    }
}
