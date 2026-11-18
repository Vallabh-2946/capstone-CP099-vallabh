import java.io.*;
import java.util.*;

public class ErrorReporter {

    public static void generateReport(List<Record> records, String path) {
        File file = new File(path);
        File parent = file.getParentFile();

        if (parent != null) {
            parent.mkdirs();
        }

        int issues = 0;
        int affected = 0;
        Set<String> seen = new HashSet<>();

        try (BufferedWriter writer =
                 new BufferedWriter(new FileWriter(file))) {

            writer.write("CLEANSLATE - ERROR REPORT");
            writer.newLine();
            writer.write("=========================");
            writer.newLine();
            writer.write("Total records: " + records.size());
            writer.newLine();

            for (int i = 0; i < records.size(); i++) {
                Record r = records.get(i);
                List<String> errors = DataValidator.validateRecord(r);

                String key = String.valueOf(r.name).trim().toLowerCase()
                        + "|" + String.valueOf(r.email).trim().toLowerCase()
                        + "|" + String.valueOf(r.phone).trim();

                boolean duplicate = !seen.add(key);

                if (!errors.isEmpty() || duplicate) {
                    affected++;
                    writer.newLine();
                    writer.write("Record " + (i + 1) + ": " + r.name);
                    writer.newLine();

                    for (String error : errors) {
                        writer.write(" - " + error);
                        writer.newLine();
                        issues++;
                    }

                    if (duplicate) {
                        writer.write(" - Duplicate record detected");
                        writer.newLine();
                        issues++;
                    }
                }
            }

            writer.newLine();
            writer.write("Records with issues: " + affected);
            writer.newLine();
            writer.write("Total issues: " + issues);
            writer.newLine();

            System.out.println("Error report generated: "
                    + file.getAbsolutePath());
            System.out.println("Records with issues: " + affected);
            System.out.println("Total issues: " + issues);

        } catch (IOException e) {
            System.out.println("Report generation failed: "
                    + e.getMessage());
        }
    }
}
