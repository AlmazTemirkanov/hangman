import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class HangmanTest {

    @Test
    public void bufferedShouldReader() throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Almaz\\Desktop\\Java\\test3.txt"));
        if (reader.readLine() == null) {
            throw new Exception("Не записаны слова для загадки");
        }
    }

    @Test
    public void isExistFile() throws FileNotFoundException {
        File file = new File("C:\\Users\\Almaz\\Desktop\\Java\\test3.txt");
        if (!file.exists())
            throw new FileNotFoundException("Файл не существует по указанному пути");
    }

}

