package lab8Task3.mainpkg;

import lab8Task3.media.Audio;
import lab8Task3.media.Video;
import lab8Task3.media.Image;

public class Main {
    public static void main(String[] args) {
        // Creating instances of media types
        Audio audio = new Audio("song.mp3");
        Video video = new Video("movie.mp4");
        Image image = new Image("picture.jpg");

        // Playing and pausing audio
        audio.play();
        audio.pause();

        // Playing, pausing, and zooming in/out on video
        video.play();
        video.zoomIn();
        video.zoomOut();
        video.pause();

        // Displaying, pausing, and zooming in/out on image
        image.play();
        image.zoomIn();
        image.zoomOut();
        image.pause();
    }
}

