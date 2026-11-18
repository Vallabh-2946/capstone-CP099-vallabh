# 🧹 CleanSlate — Data Validation and Cleansing Utility

![Java](https://img.shields.io/badge/Java-8%2B-orange) ![Interface](https://img.shields.io/badge/Interface-Console-blue) ![Project](https://img.shields.io/badge/Project-CP--099-green)

CleanSlate is a menu-driven Java console application that checks CSV datasets for data-quality problems, detects duplicate records, standardizes inconsistent formatting, exports a cleaned copy of the data, and generates a readable error report.

> **Project Code:** CP-099 &nbsp;|&nbsp; **Team:** Vallabh P (1AT24CS243), Shivam Chilkoti (1ST24CS205) &nbsp;|&nbsp; CSE, Section D, Atria Institute of Technology

---

## 📌 Table of Contents

- [About the Project](#-about-the-project)
- [Problem Statement](#-problem-statement)
- [Project Objectives](#-project-objectives)
- [Features](#-features)
- [Validation Rules](#-validation-rules)
- [Technologies Used](#-technologies-used)
- [Project Structure](#-project-structure)
- [How the Application Works](#-how-the-application-works)
- [Java File Responsibilities](#-java-file-responsibilities)
- [OOP and Java Concepts Used](#-oop-and-java-concepts-used)
- [Sample Datasets and Results](#-sample-datasets-and-results)
- [How to Install and Run](#-how-to-install-and-run)
- [Output Files](#-output-files)
- [Known Limitations](#-known-limitations)
- [Testing Checklist](#-testing-checklist)
- [Team Responsibilities](#-team-responsibilities)
- [Future Enhancements](#-future-enhancements)
- [Conclusion](#-conclusion)

---

## 📖 About the Project

CleanSlate is a data validation and cleansing utility developed in Java.

CSV (Comma-Separated Values) files are widely used to store information about customers, employees, students, and other entities. These files often contain invalid values, inconsistent formatting, missing information, and duplicate records.

CleanSlate makes such datasets easier to inspect and maintain. Through a simple numbered menu, the user can load a dataset, validate every record, identify duplicates, clean supported formatting issues, export the processed data, and generate an error report.

The application runs entirely in a terminal and does not require a graphical user interface or any external libraries.

## ❗ Problem Statement

Data stored in CSV files commonly suffers from problems such as:

| Problem | Example |
|---|---|
| Invalid email address | `priya.example.com` (missing `@`) |
| Invalid or incomplete phone number | `12345` |
| Impossible calendar date | `31-02-2004` |
| Duplicate records | The same person entered twice |
| Unnecessary spaces | `"  AMAN KUMAR  "` |
| Inconsistent capitalization | `bengaluru` vs `Bengaluru` |

Finding these problems manually in large datasets is slow and error-prone.

CleanSlate automates these basic checks so that problems are identified consistently and the data is prepared for further processing.

## 🎯 Project Objectives

1. Read and process CSV datasets using Java file handling.
2. Validate common data fields using clearly defined rules.
3. Detect duplicate records.
4. Standardize supported formatting inconsistencies.
5. Export processed records into separate CSV files without altering the originals.
6. Generate readable reports describing detected errors.
7. Demonstrate modular, object-oriented programming in Java.

## ✨ Features

### 1. Load CSV File
Choose one of the three sample datasets: **Customers**, **Employees**, or **Students**. Malformed rows (rows without exactly five fields) are skipped with a message.

### 2. Display Records
Show the loaded records in an aligned table so the dataset can be inspected.

### 3. Validate Records
Check every record against the [validation rules](#-validation-rules) and mark it **VALID** or **INVALID**, listing each problem found, followed by a summary of totals.

### 4. Detect Duplicate Records
Identify records with the same **name + email + phone** (ignoring letter case and extra spaces) and report which earlier record each duplicate matches.

### 5. Clean Data and Suggest Fixes
Apply safe formatting fixes and show every change as *before → after*:

- Remove leading, trailing, and repeated spaces in names.
- Trim and lowercase email addresses.
- Standardize city capitalization (e.g., `bengaluru` → `Bengaluru`).

Values that cannot be corrected safely (invalid emails, phone numbers, and dates) are **flagged for manual correction** rather than guessed, so no incorrect data is introduced.

### 6. Export Cleaned Records
Save the processed records to `output/cleaned_<dataset>.csv`. The original input file is never modified.

### 7. Generate Error Report
Write a text report to `output/<dataset>_error_report.txt` listing each affected record, its issues (validation errors and duplicates), and overall totals.

### 8. Exit
Close the application.

> Every option from 2 to 7 checks that a dataset has been loaded first, and non-numeric menu input is handled without crashing.

## ✅ Validation Rules

| Field | Rule | Valid example | Invalid example |
|---|---|---|---|
| Name | Must not be empty | `Rahul Sharma` | *(blank)* |
| Email | `text@domain.extension`, extension of 2+ letters | `rahul@example.com` | `priya.example.com` |
| Phone | Exactly 10 digits, starting with 6, 7, 8, or 9 (Indian mobile format) | `9876543210` | `12345` |
| Date of birth | Format `DD-MM-YYYY`, must be a real calendar date, not in the future | `15-08-2003` | `31-02-2004` |

Dates are checked in **strict** mode, so impossible dates such as `31-02-2004`, `31-04-2004`, or `29-02-2001` (not a leap year) are rejected instead of being silently adjusted.

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java (JDK 8 or later) | Core application logic |
| Java File I/O (`BufferedReader`, `BufferedWriter`) | Reading input files and writing output files |
| Java Collections (`ArrayList`, `HashMap`, `HashSet`) | Storing records and detecting duplicates |
| `java.util.regex` | Email and phone validation patterns |
| `java.time` (`LocalDate`) | Strict date validation |
| CSV | Input datasets and exported records |
| PowerShell / Terminal | Compiling and running the application |
| Git and GitHub | Version control and collaboration |

## 📂 Project Structure

```text
capstone-CP099-vallabh/
│
├── Main.java               # Menu and program control
├── Record.java             # Data model for one CSV row
├── CSVReader.java          # Reads CSV files into Record objects
├── DataValidator.java      # Validation rules
├── DuplicateDetector.java  # Duplicate detection
├── DataCleaner.java        # Formatting cleanup
├── CSVExporter.java        # Writes cleaned CSV files
├── ErrorReporter.java      # Writes error reports
│
├── input/                  # Original datasets (never modified)
│   ├── customers.csv
│   ├── employees.csv
│   └── students.csv
│
├── output/                 # Files generated by the application
│
├── README.md
└── .gitignore              # Excludes compiled .class files and IDE settings
```

## 🔄 How the Application Works

```text
            ┌───────────────────┐
            │   Start Program   │
            └─────────┬─────────┘
                      ▼
            ┌───────────────────┐
            │ Display Main Menu │◄──────────────┐
            └─────────┬─────────┘               │
                      ▼                         │
            ┌───────────────────┐               │
            │   Load CSV File   │  CSVReader    │
            └─────────┬─────────┘               │
                      ▼                         │
   ┌──────────────────────────────────────┐     │
   │ Display │ Validate │ Find Duplicates │     │  Repeat until
   │  Clean  │  Export CSV  │ Error Report │────┘  user selects Exit
   └──────────────────────────────────────┘
                      ▼
            ┌───────────────────┐
            │       Exit        │
            └───────────────────┘
```

1. `Main` displays the menu in a loop and reads the user's choice.
2. `CSVReader` reads the selected file line by line, skips the header, and converts each row into a `Record` object stored in a shared list.
3. Each menu action passes that list to the responsible class.
4. Cleaning updates the same `Record` objects, so a later export contains the cleaned values.
5. Export and report files are written to `output/` and named after the loaded dataset.

## 🧩 Java File Responsibilities

| File | Responsibility |
|---|---|
| `Main.java` | Displays the menu, handles user input, and coordinates all operations. |
| `Record.java` | Represents one data record (name, email, phone, date of birth, city). |
| `CSVReader.java` | Reads a CSV file, skips the header and malformed rows, and returns a list of records. |
| `DataValidator.java` | Applies validation rules and returns a list of errors for each record. |
| `DuplicateDetector.java` | Finds duplicate records using a normalized name + email + phone key. |
| `DataCleaner.java` | Trims spaces, lowercases emails, and standardizes city capitalization. |
| `CSVExporter.java` | Writes processed records to a CSV file, creating the output folder if needed. |
| `ErrorReporter.java` | Reuses the validator and duplicate check to write a summary error report. |

Each class has a single responsibility, making the application easier to understand, maintain, test, and extend.

## 🧠 OOP and Java Concepts Used

| Concept | Where it is used |
|---|---|
| Classes and objects | Each CSV row becomes a `Record` object |
| Constructor | `Record` initializes its fields when created |
| Encapsulation | `Record` groups its data with its `display()` behavior |
| Abstraction | `Main` calls operations without depending on their internal logic |
| Modularity / single responsibility | One class per task |
| Code reuse | `ErrorReporter` reuses `DataValidator.validateRecord()` |
| Interface-based programming | `List<Record> records = new ArrayList<>()` |
| Exception handling | `try-catch` and try-with-resources for file and date errors |
| Collections | `ArrayList`, `HashMap`, `HashSet` |
| Regular expressions | Email and phone validation |

## 📊 Sample Datasets and Results

| Dataset | File | Records | Valid | Invalid | Duplicates | Records cleaned |
|---|---|---|---|---|---|---|
| Customers | `customers.csv` | 5 | 3 | 2 | 1 | 1 |
| Employees | `employees.csv` | 15 | 8 | 7 | 2 | 5 |
| Students | `students.csv` | 15 | 10 | 5 | 1 | 4 |

The sample data deliberately includes invalid emails, short phone numbers, impossible dates, duplicate rows, extra spaces, and lowercase city names to demonstrate every feature.

**Example error report (customers):**

```text
CLEANSLATE - ERROR REPORT
=========================
Total records: 5

Record 2: Priya Nair
 - Invalid email: priya.example.com

Record 4: Sneha Rao
 - Invalid phone number: 12345
 - Invalid date of birth: 31-02-2004

Record 5: Rahul Sharma
 - Duplicate record detected

Records with issues: 3
Total issues: 4
```

## ⚙️ How to Install and Run

### Prerequisites

- A Java Development Kit (JDK 8 or later).
- PowerShell or Command Prompt on Windows, or a terminal on macOS/Linux.
- Git (optional — you can download the ZIP instead).

Verify Java is installed:

```powershell
java -version
javac -version
```

### Step 1: Download the Project

**Option A — Clone with Git**

```powershell
git clone https://github.com/Vallabh-2946/capstone-CP099-vallabh.git
cd capstone-CP099-vallabh
```

**Option B — Download ZIP**

Click **Code → Download ZIP** on the repository page, extract it, and open a terminal in the extracted folder.

### Step 2: Compile

```powershell
javac *.java
```

### Step 3: Run

```powershell
java Main
```

> Run the program from the project folder, because input and output paths are relative to it.

### Step 4: Use the Menu

```text
========================================
               CLEANSLATE
  Data Validation and Cleansing Utility
========================================
1. Load CSV File
2. Display Records
3. Validate Records
4. Detect Duplicate Records
5. Clean Data and Suggest Fixes
6. Export Cleaned Records
7. Generate Error Report
8. Exit
========================================
Enter your choice:
```

**Recommended demo order:** `1` (choose a dataset) → `2` → `3` → `4` → `5` → `6` → `7` → open the `output/` folder → `8`.

## 📁 Output Files

| File | Created by | Contents |
|---|---|---|
| `output/cleaned_customers.csv` | Option 6 | Processed customer records |
| `output/cleaned_employees.csv` | Option 6 | Processed employee records |
| `output/cleaned_students.csv` | Option 6 | Processed student records |
| `output/<dataset>_error_report.txt` | Option 7 | Issues per record and overall totals |

Files are overwritten each time the same option is run for the same dataset. Original files in `input/` remain unchanged so results can always be compared with the source.

## ⚠️ Known Limitations

- Only the three bundled datasets can be loaded.
- CSV values containing commas inside quotes are not supported.
- Duplicates are reported but not removed automatically.
- Invalid emails, phone numbers, and dates are flagged, not corrected.
- All records are held in memory, so very large files may be slow.

## 🧪 Testing Checklist

- [x] All Java source files compile successfully.
- [x] Customer, employee, and student datasets load correctly.
- [x] Loaded records display correctly.
- [x] Invalid emails, phone numbers, and dates are detected.
- [x] Impossible dates (e.g., `31-02`, `29-02` in non-leap years) are rejected.
- [x] Duplicate records are detected and matched to the original record.
- [x] Extra spaces and city capitalization are cleaned.
- [x] Cleaned records export to the `output/` folder.
- [x] Error report totals match the listed issues.
- [x] Original input files remain unchanged.
- [x] Invalid menu input is handled without crashing.

## 👥 Team Responsibilities

| Work Area | Relevant Files | Responsibility |
|---|---|---|
| Application integration | `Main.java` | Menu handling and connecting features |
| Data model and CSV input | `Record.java`, `CSVReader.java` | Representing records and reading input files |
| Validation | `DataValidator.java` | Defining and implementing validation rules |
| Duplicate detection | `DuplicateDetector.java` | Defining and testing duplicate-matching criteria |
| Data cleaning | `DataCleaner.java` | Standardization and cleaning operations |
| Export and reporting | `CSVExporter.java`, `ErrorReporter.java` | Saving processed data and generating reports |
| Testing and documentation | Sample datasets, `README.md`, user manual | Verifying behavior and documenting the project |

## 🚀 Future Enhancements

- Load any user-selected CSV file.
- Robust CSV parsing (quoted values, commas inside fields).
- Option to remove duplicate records automatically.
- Suggested corrections for invalid values in the report.
- Additional and configurable validation rules (age range, name characters).
- A before/after data-quality summary.
- Automated unit tests with JUnit.
- A graphical user interface.
- Support for larger datasets and formats such as Excel and JSON.

These are planned improvements, not features of the current version.

## 🏁 Conclusion

CleanSlate shows how Java can be used to read CSV datasets, validate records, detect duplicates, standardize data, export processed files, and generate error reports.

Its modular, object-oriented design separates reading, validation, duplicate detection, cleaning, exporting, and reporting into individual classes, providing a solid foundation for further development.

---

**Project:** CleanSlate — Data Validation and Cleansing Utility (CP-099)
**Language:** Java
**Interface:** Console-based
**Repository:** [capstone-CP099-vallabh](https://github.com/Vallabh-2946/capstone-CP099-vallabh)
