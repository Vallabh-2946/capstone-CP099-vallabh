import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Record> records = new ArrayList<>();
        String outputPrefix = "customers";
        int choice = 0;

        do {
            System.out.println("\n========================================");
            System.out.println("               CLEANSLATE");
            System.out.println("  Data Validation and Cleansing Utility");
            System.out.println("========================================");
            System.out.println("1. Load CSV File");
            System.out.println("2. Display Records");
            System.out.println("3. Validate Records");
            System.out.println("4. Detect Duplicate Records");
            System.out.println("5. Clean Data and Suggest Fixes");
            System.out.println("6. Export Cleaned Records");
            System.out.println("7. Generate Error Report");
            System.out.println("8. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Invalid input! Enter a number from 1 to 8.");
                if (sc.hasNext()) {
                    sc.next();
                } else {
                    break;
                }
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\nSelect a CSV file:");
                    System.out.println("1. Customers");
                    System.out.println("2. Employees");
                    System.out.println("3. Students");
                    System.out.print("Enter your choice: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Invalid selection.");
                        if (sc.hasNext()) {
                            sc.next();
                        }
                        break;
                    }

                    int fileChoice = sc.nextInt();
                    String filePath;

                    switch (fileChoice) {
                        case 1:
                            filePath = "input/customers.csv";
                            outputPrefix = "customers";
                            break;
                        case 2:
                            filePath = "input/employees.csv";
                            outputPrefix = "employees";
                            break;
                        case 3:
                            filePath = "input/students.csv";
                            outputPrefix = "students";
                            break;
                        default:
                            System.out.println("Invalid file selection.");
                            continue;
                    }

                    List<Record> loadedRecords = CSVReader.loadRecords(filePath);
                    if (!loadedRecords.isEmpty()) {
                        records = loadedRecords;
                        System.out.println("Successfully loaded " + outputPrefix
                                + ".csv. Records: " + records.size());
                    } else {
                        System.out.println("No records loaded. Check the file.");
                    }
                    break;

                case 2:
                    if (records.isEmpty()) {
                        System.out.println("Please load a CSV file first.");
                    } else {
                        System.out.printf("%-20s %-28s %-12s %-12s %-15s%n",
                                "Name", "Email", "Phone", "DOB", "City");
                        for (Record record : records) {
                            record.display();
                        }
                        System.out.println("Total records: " + records.size());
                    }
                    break;

                case 3:
                    if (records.isEmpty()) {
                        System.out.println("Please load the CSV file first.");
                    } else {
                        DataValidator.validateRecords(records);
                    }
                    break;

                case 4:
                    if (records.isEmpty()) {
                        System.out.println("Please load the CSV file first.");
                    } else {
                        DuplicateDetector.detectDuplicates(records);
                    }
                    break;

                case 5:
                    if (records.isEmpty()) {
                        System.out.println("Please load the CSV file first.");
                    } else {
                        DataCleaner.cleanRecords(records);
                    }
                    break;

                case 6:
                    if (records.isEmpty()) {
                        System.out.println("Please load the CSV file first.");
                    } else {
                        CSVExporter.exportRecords(records,
                                "output/cleaned_" + outputPrefix + ".csv");
                    }
                    break;

                case 7:
                    if (records.isEmpty()) {
                        System.out.println("Please load the CSV file first.");
                    } else {
                        ErrorReporter.generateReport(records,
                                "output/" + outputPrefix + "_error_report.txt");
                    }
                    break;

                case 8:
                    System.out.println("Thank you for using CleanSlate!");
                    break;

                default:
                    System.out.println("Invalid choice! Select 1 to 8.");
            }
        } while (choice != 8);

        sc.close();
    }
}
