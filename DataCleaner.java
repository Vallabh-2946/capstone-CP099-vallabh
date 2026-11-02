import java.util.List;

public class DataCleaner {

    public static void cleanRecords(List<Record> records) {
        System.out.println("\n========== DATA CLEANING REPORT ==========");

        int changes = 0;
        int rowNumber = 1;

        for (Record record : records) {
            boolean changed = false;

            // Clean name: remove extra spaces and fix capitalization
            String cleanedName = record.name.trim().replaceAll("\\s+", " ");

            if (!cleanedName.equals(record.name)) {
                System.out.println("Record " + rowNumber
                        + ": Name spacing cleaned: '"
                        + record.name + "' -> '" + cleanedName + "'");
                record.name = cleanedName;
                changed = true;
            }

            // Clean email: remove spaces and convert to lowercase
            String cleanedEmail = record.email.trim().toLowerCase();

            if (!cleanedEmail.equals(record.email)) {
                System.out.println("Record " + rowNumber
                        + ": Email cleaned: '"
                        + record.email + "' -> '" + cleanedEmail + "'");
                record.email = cleanedEmail;
                changed = true;
            }

            // Clean city: standardize capitalization
            String cleanedCity = record.city.trim();

            if (!cleanedCity.isEmpty()) {
                cleanedCity = cleanedCity.substring(0, 1).toUpperCase()
                        + cleanedCity.substring(1).toLowerCase();
            }

            if (!cleanedCity.equals(record.city)) {
                System.out.println("Record " + rowNumber
                        + ": City standardized: '"
                        + record.city + "' -> '" + cleanedCity + "'");
                record.city = cleanedCity;
                changed = true;
            }

            if (changed) {
                changes++;
            }

            rowNumber++;
        }

        if (changes == 0) {
            System.out.println("No cleaning changes were required.");
        }

        System.out.println("\nRecords updated: " + changes);
        System.out.println("Note: Invalid emails, phone numbers, and dates "
                + "are not automatically corrected.");
    }
}