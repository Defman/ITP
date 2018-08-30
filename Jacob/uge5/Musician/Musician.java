public class Musician
{
    private String name;
    private String instrument;
    private int skillLevel;
    
    public Musician(String name, String instrument, int skillLevel) {
        this.name = name;
        this.instrument = instrument;
        this.skillLevel = skillLevel;
    }
    
    public String toString() {
        return String.format("%s, %s (Skill level: %d)", this.name, this.instrument, this.skillLevel);
    }
}
