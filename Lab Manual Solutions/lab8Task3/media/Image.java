package lab8Task3.media;

public class Image implements Playable, Viewable {
    private String imageFile;
    private int zoomLevel;

    public Image(String imageFile) {
        this.imageFile = imageFile;
        this.zoomLevel = 100; // Default zoom level
    }

    @Override
    public void play() {
        System.out.println("Displaying image file: " + imageFile);
    }

    @Override
    public void pause() {
        System.out.println("Pausing display of image file: " + imageFile);
    }

    @Override
    public void zoomIn() {
        zoomLevel += 10;
        System.out.println("Zooming in to " + zoomLevel + "% on image: " + imageFile);
    }

    @Override
    public void zoomOut() {
        zoomLevel -= 10;
        System.out.println("Zooming out to " + zoomLevel + "% on image: " + imageFile);
    }
}
