package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllReader {
    private final String path;

    public AllReader(String path) {
        this.path = path;
    }


    public String fileRead() throws IOException {
        return String.join("", Files.readAllLines(Paths.get(path)));
    }
}
