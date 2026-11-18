import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class DataValidator {

    private static final Pattern EMAIL_PATTERN =
        Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private static final Pattern PHONE_PATTERN =
        Pattern.compile("^[6-9][0-9]{9}$");

    public static List<String> validateRecord(Record record) {

        List<String> errors = new ArrayList<>();

        // Validate name
        if (record.name == null || record.name.trim().isEmpty()) {
            errors.add("Name is missing");
        }

        // Validate email
        if (record.email == null ||
            !EMAIL_PATTERN.matcher(record.email.trim()).matches()) {
            errors.add("Invalid email: " + record.email);
        }

        // Validate Indian mobile number
        if (record.phone == null ||
            !PHONE_PATTERN.matcher(record.phone.trim()).matches()) {
            errors.add("Invalid phone number: " + record.phone);
        }

        // Validate date of birth
        try {
            DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-uuuu", Locale.ROOT)
                    .withResolverStyle(ResolverStyle.STRICT);

            LocalDate dob = LocalDate.parse(
                record.dob.trim(), formatter
            );

            if (dob.isAfter(LocalDate.now())) {
                errors.add("Date of birth cannot be in the future");
            }

        } catch (DateTimeParseException | NullPointerException e) {
            errors.add("Invalid date of birth: " + record.dob);
        }

        return errors;
    }

    public static void validateRecords(List<Record> records) {

        int validCount = 0;
        int invalidCount = 0;
        int rowNumber = 1;

        System.out.println("\n========== VALIDATION REPORT ==========");

        for (Record record : records) {

            List<String> errors = validateRecord(record);

            System.out.println("\nRecord " + rowNumber + ": " + record.name);

            if (errors.isEmpty()) {
                System.out.println("Status: VALID");
                validCount++;
            } else {
                System.out.println("Status: INVALID");

                for (String error : errors) {
                    System.out.println(" - " + error);
                }

                invalidCount++;
            }

            rowNumber++;
        }

        System.out.println("\n========== SUMMARY ==========");
        System.out.println("Total records: " + records.size());
        System.out.println("Valid records: " + validCount);
        System.out.println("Invalid records: " + invalidCount);
    }
}