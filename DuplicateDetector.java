import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateDetector {

    public static void detectDuplicates(List<Record> records) {

        Map<String, Integer> seen = new HashMap<>();

        int duplicateCount = 0;
        int rowNumber = 1;

        System.out.println("\n========== DUPLICATE REPORT ==========");

        for (Record record : records) {

            String key =
                record.name.trim().replaceAll("\\s+", " ").toLowerCase()
                + "|" + record.email.trim().toLowerCase()
                + "|" + record.phone.trim();

            if (seen.containsKey(key)) {

                System.out.println(
                    "Duplicate found at record " + rowNumber
                    + " (matches record " + seen.get(key) + "): "
                    + record.name.trim()
                );

                duplicateCount++;

            } else {
                seen.put(key, rowNumber);
            }

            rowNumber++;
        }

        if (duplicateCount == 0) {
            System.out.println("No duplicate records found.");
        }

        System.out.println("\nTotal duplicate records: " + duplicateCount);
    }
}