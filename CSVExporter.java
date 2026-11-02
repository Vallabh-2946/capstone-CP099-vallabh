import java.io.*;
import java.util.List;

public class CSVExporter {
    public static void exportRecords(List<Record> records, String path) {
        File file = new File(path);
        File parent = file.getParentFile();
        if (parent != null) parent.mkdirs();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("name,email,phone,dob,city");
            writer.newLine();
            for (Record r : records) {
                writer.write(r.name + "," + r.email + "," + r.phone + "," + r.dob + "," + r.city);
                writer.newLine();
            }
            System.out.println("Export successful: " + file.getAbsolutePath());
            System.out.println("Records exported: " + records.size());
        } catch (IOException e) {
            System.out.println("Export failed: " + e.getMessage());
        }
    }
}
