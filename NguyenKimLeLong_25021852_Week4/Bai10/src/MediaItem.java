public abstract class MediaItem {
    String id, name;
    MediaItem(String id, String name) {
        this.id = id;
        this.name = name;
    }
    abstract public void display();
}
