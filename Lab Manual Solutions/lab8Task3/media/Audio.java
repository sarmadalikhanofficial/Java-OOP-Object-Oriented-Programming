package lab8Task3.media;

public class Audio implements Playable {
    private String audioFile;

    public Audio(String audioFile) {
        this.audioFile = audioFile;
    }

    @Override
    public void play() {
        System.out.println("Playing audio file: " + audioFile);
    }

    @Override
    public void pause() {
        System.out.println("Pausing audio file: " + audioFile);
    }
}
