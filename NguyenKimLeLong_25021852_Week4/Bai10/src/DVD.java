public class DVD extends MediaItem{
    String director;
    int duration;
    DVD(String id, String name, String director, int duration) {
        super(id, name);
        this.director = director;
        this.duration = duration;
    }
    
    @Override
    public void display() {
        System.out.println(name + " - " + director + " - " + duration);
    }
}
