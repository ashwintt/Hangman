import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//TODO Continue making this class before other modes
//Words with 4-5 letters
public class ModeEasy extends Mode{
    ModeEasy(){
        super("easy");
    }

    @Override
    public void retrieveWords(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            //FIXME
            // - Split words using the space
            // - Get words and store in HashMap with key being word, value being difficulty
            reader.close();
        } catch(IOException e) {
            System.out.println("Error accessing file");
        }
    }
}