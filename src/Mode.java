import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

abstract class Mode {
    private HashMap<String, String> words = new HashMap<>();
    private int attempts;
    private final String mode;

    Mode(String mode, int attempts) {
        this.mode = mode;
        this.attempts = attempts;
    }

    // Used to get the words from the words.txt and
    public  void retrieveWords(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            // Appending the lines into a key (word) and value (difficulty) within a hashmap
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(" ");
                String key = splitLine[0];
                String value = splitLine[1];
                words.put(key, value);
            }
            reader.close();
        } catch(IOException e) {
            System.out.println("Error accessing file");
        }

        // Removing words taken from the words.txt file that does not match the mode
        Iterator<Map.Entry<String,String>> iterator = words.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,String> line = iterator.next();
            if (!line.getValue().equals(mode)) {
                iterator.remove();
            }
        }
    }

    public void attempted() {
        attempts--;
    }

    // Getting a random word from the list of words
    public String randomWord() {
        Random random = new Random();
        ArrayList<String> keys = new ArrayList<>(words.keySet());
        return keys.get(random.nextInt(keys.size()));
    }
}
