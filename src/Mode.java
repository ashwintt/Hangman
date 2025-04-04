import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

abstract class Mode {
    private HashMap<String, String> words = new HashMap<>();
    private int attempts;
    private final String mode;
    protected String word;

    Mode(String mode) {
        this.mode = mode;
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

//        //        Test
//        for (String key : words.keySet()) {
//            System.out.println(key + " " + words.get(key));
//        }
    }

    public void attempted() {
        attempts--;
    }

    public String randomWord() {
        //    TODO Make the function get a random word from filtered words
    }
}
