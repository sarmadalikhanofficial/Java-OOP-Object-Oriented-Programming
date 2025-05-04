package lab8Task3.media;


public class Video implements Playable, Viewable {
    private String videoFile;
    private int zoomLevel;

    public Video(String videoFile) {
        this.videoFile = videoFile;
        this.zoomLevel = 100; // Default zoom level
    }

    @Override
    public void play() {
        System.out.println("Playing video file: " + videoFile);
    }

    @Override
    public void pause() {
        System.out.println("Pausing video file: " + videoFile);
    }

    @Override
    public void zoomIn() {
        zoomLevel += 10;
        System.out.println("Zooming in to " + zoomLevel + "% on video: " + videoFile);
    }

    @Override
    public void zoomOut() {
        zoomLevel -= 10;
        System.out.println("Zooming out to " + zoomLevel + "% on video: " + videoFile);
    }
}
