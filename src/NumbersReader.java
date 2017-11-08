import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.List;



public class NumbersReader {

    List<String> readInputFile(String filename) throws NumbersException {
        File file = makeFileFromFilename(filename);
        Path path = makePathFromFile(file);
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new NumbersException("IOException: cannot read from Path");
        }
    }

    private File makeFileFromFilename (String filename) throws NumbersException {
        try {
            return new File(filename);
        }
        catch (NullPointerException npe) {
            throw new NumbersException("Filename is null!");
        }
    }

    private Path makePathFromFile (File file) throws NumbersException {
        try {
            return file.toPath();
        }
        catch (InvalidPathException ipe) {
            throw new NumbersException("Cannot create path from File!");
        }
    }

}
