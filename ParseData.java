import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class ParseData {
    public static LocalDate get() {
        LocalDate returnD = LocalDate.now();
        try {
            File input = new File("input/data.txt");

            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                returnD = LocalDate.parse(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred opening the file.");
            e.printStackTrace();
        }

        return returnD;
    }
}
