import java.util.ArrayList;
import java.util.Random;

abstract class Mode {
    private ArrayList<String> words = new ArrayList<>();
    private int attempts;
    private String mode;

    Mode(String mode) {
        this.mode = mode;
    }

    abstract void retrieveWords(String filename);

    public void attempted() {
        attempts--;
    }

    public String randomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}
