

public class Racer {
    private String name;
    private int year;
    private int topSpeed;
    
    public Racer(String name, int year, int topSpeed) {
        this.name = name;
        this.year = year;
        this.topSpeed = topSpeed;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getYear() {
        return this.year;
    }
    
    public int getTopSpeed() {
        return this.topSpeed;
    }
    
    public String toString() {
        return String.format("%s-%d, Top speed: %dkm/h", name, year, topSpeed);
    }
}