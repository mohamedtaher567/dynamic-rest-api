package application.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
	public static String extractServiceName(String fullPath) {
        Path path = Paths.get(fullPath);
        String fileName = path.getFileName().toString();
        return fileName.replace(".class", "");
    }
}
