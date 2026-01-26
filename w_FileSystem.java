import java.nio.file.*;
import java.io.IOException;

public class w_FileSystem {
    public static void main(String[] args) {
        Path path = Paths.get("tasks.json");

        try {
            // Create file if it doesn't exist
            if (!Files.exists(path)) {
                Files.writeString(path, "[]"); // better than createFile
            }

            // Read file
            String file = Files.readString(path);
            System.out.println(file);

            Files.writeString(path, file + "[HIYA]");
            file = Files.readString(path);
            System.out.println(file);

        } catch (IOException e) {
            System.out.println("Failed to access the file");
        }
    }
}
