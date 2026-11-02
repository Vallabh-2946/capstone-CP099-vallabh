import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    public static List<Record> loadRecords(String filePath) {

        List<Record> records = new ArrayList<>();

        try (BufferedReader br =
                     new BufferedReader(new FileReader(filePath))) {

            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {

                lineNumber++;

                if (lineNumber == 1) {
                    continue;
                }

                String[] fields = line.split(",", -1);

                if (fields.length != 5) {
                    System.out.println(
                            "Skipping malformed row: " + lineNumber);
                    continue;
                }

                Record record = new Record(
                        fields[0],
                        fields[1],
                        fields[2],
                        fields[3],
                        fields[4]
                );

                records.add(record);
            }

            System.out.println(
                    "CSV loaded successfully. Records: " + records.size());

        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }

        return records;
    }
}