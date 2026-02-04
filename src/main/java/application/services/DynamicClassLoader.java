package application.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DynamicClassLoader extends ClassLoader {

    public Class<?> loadClassFromFile(String path) throws IOException {

        File file = new File(path);
        byte[] classData = new byte[(int) file.length()];

        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(classData);
        }

        return defineClass(null, classData, 0, classData.length);
    }
}
