import java.io.File;
import java.util.List;



public class NumbersReader {

    private File makeFile(String filename) {
        try {
            return new File(filename);
        }
        catch (NullPointerException npe) {
            
        }

    }

}
