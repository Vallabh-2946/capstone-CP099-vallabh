# 🧹 CleanSlate — Data Validation and Cleansing Utility

A Java-based console application that helps identify data-quality issues in CSV files, detect duplicate records, standardize inconsistent data, export cleaned datasets, and generate error reports.

---

## 📌 Table of Contents

- [About the Project](#-about-the-project)
- [Problem Statement](#-problem-statement)
- [Project Objectives](#-project-objectives)
- [Features](#-features)
- [Technologies Used](#-technologies-used)
- [Project Structure](#-project-structure)
- [How the Application Works](#-how-the-application-works)
- [Java File Responsibilities](#-java-file-responsibilities)
- [Sample Datasets](#-sample-datasets)
- [How to Install and Run](#-how-to-install-and-run)
- [Output Files](#-output-files)
- [Testing Checklist](#-testing-checklist)
- [Team Responsibilities](#-team-responsibilities)
- [Future Enhancements](#-future-enhancements)
- [Conclusion](#-conclusion)

---

## 📖 About the Project

CleanSlate is a data validation and cleansing utility developed using Java.

CSV files are commonly used to store information about customers, employees, students, and other entities. However, these files can contain invalid values, inconsistent formatting, missing or incorrect information, and duplicate records.

CleanSlate aims to make these datasets easier to inspect and maintain by providing a menu-driven interface for validating records, identifying duplicates, cleaning supported formatting issues, exporting processed data, and generating error reports.

The application runs in a terminal and does not require a graphical user interface.

## ❗ Problem Statement

Data stored in CSV files may contain several data-quality problems, including:

- Invalid email addresses.
- Incorrectly formatted or incomplete phone numbers.
- Invalid dates, such as impossible calendar dates.
- Duplicate records.
- Unnecessary spaces in names and other fields.
- Inconsistent capitalization of city names.
- Data that requires manual inspection and correction.

Manually identifying these problems in large datasets can be time-consuming and error-prone.

CleanSlate is designed to automate basic validation and cleansing tasks, helping users identify problems and prepare data for further processing.

## 🎯 Project Objectives

1. Read and process CSV datasets using Java.
2. Validate common data fields using predefined rules.
3. Detect duplicate records.
4. Standardize supported formatting inconsistencies.
5. Export processed records into separate CSV files.
6. Generate readable reports describing detected errors.
7. Demonstrate modular programming and file handling in Java.

## ✨ Features

### 1. Load CSV Files
Load one of the available sample datasets:

- Customers
- Employees
- Students

### 2. Display Records
Display the records loaded into the application so users can inspect the dataset.

### 3. Validate Records
Check supported fields, including:

- Names
- Email addresses
- Phone numbers
- Dates of birth

The validation rules determine which values are accepted and which are reported as invalid.

### 4. Detect Duplicate Records
Identify records that match the application's duplicate-detection criteria.

### 5. Clean Data and Suggest Fixes
Apply supported standardization operations, such as:

- Removing unnecessary leading and trailing spaces.
- Standardizing city-name capitalization.
- Preparing corrected or standardized values for export.

Validation and cleaning are separate operations: detecting an invalid value does not necessarily mean the application can safely correct it automatically.

### 6. Export Cleaned Records
Save processed records into a CSV file in the output directory without intentionally replacing the original input dataset.

### 7. Generate Error Reports
Generate a readable text report describing detected data-quality issues.

### 8. Exit
Close the application using the menu.

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java | Core application logic |
| Java File I/O | Reading and writing files |
| CSV | Input datasets and exported records |
| PowerShell | Running commands on Windows |
| Git | Version control |
| GitHub | Source-code hosting and collaboration |

---

## 📂 Project Structure

```text
CleanSlate/
│
├── Main.java
├── Record.java
├── CSVReader.java
├── DataValidator.java
├── DuplicateDetector.java
├── DataCleaner.java
├── CSVExporter.java
├── ErrorReporter.java
│
├── input/
│   ├── customers.csv
│   ├── employees.csv
│   └── students.csv
│
├── output/
│   ├── cleaned_customers.csv
│   └── error_report.txt
│
├── README.md
├── CleanSlate_Team_Project_Guide.docx
└── .gitignore
```

The exact files in `output/` may change as the application is tested and run.

## 🔄 How the Application Works

The application follows this general workflow:

```text
          ┌───────────────────┐
          │   Start Program   │
          └─────────┬─────────┘
                    │
                    ▼
          ┌───────────────────┐
          │ Display Main Menu │
          └─────────┬─────────┘
                    │
                    ▼
          ┌───────────────────┐
          │   Load CSV File   │
          └─────────┬─────────┘
                    │
                    ▼
          ┌───────────────────┐
          │  Display Records  │
          └─────────┬─────────┘
                    │
                    ▼
          ┌───────────────────┐
          │ Validate Records  │
          └─────────┬─────────┘
                    │
                    ▼
          ┌───────────────────┐
          │ Detect Duplicates │
          └─────────┬─────────┘
                    │
                    ▼
          ┌───────────────────┐
          │  Clean the Data   │
          └─────────┬─────────┘
                    │
                    ▼
          ┌───────────────────┐
          │ Export CSV / Report│
          └─────────┬─────────┘
                    │
                    ▼
          ┌───────────────────┐
          │       Exit        │
          └───────────────────┘
```

The user selects operations from the menu. Validation, duplicate detection, cleaning, and exporting can be performed as separate actions according to the application's implementation.

## 🧩 Java File Responsibilities

| File | Responsibility |
|---|---|
| `Main.java` | Displays the menu and coordinates the application's operations. |
| `Record.java` | Represents an individual data record. |
| `CSVReader.java` | Reads CSV input and loads records. |
| `DataValidator.java` | Implements data-validation rules. |
| `DuplicateDetector.java` | Identifies duplicate records. |
| `DataCleaner.java` | Implements supported data-cleaning operations. |
| `CSVExporter.java` | Exports processed records to CSV files. |
| `ErrorReporter.java` | Generates reports describing detected issues. |

The classes are separated by responsibility to make the application easier to understand, maintain, test, and extend.

## 📊 Sample Datasets

The project includes three sample datasets.

| Dataset | File | Purpose |
|---|---|---|
| Customers | `customers.csv` | Demonstrates customer-record validation and cleansing. |
| Employees | `employees.csv` | Demonstrates processing employee records. |
| Students | `students.csv` | Demonstrates processing student records. |

The sample data includes examples intended to help test data validation, duplicate detection, and standardization.

## ⚙️ How to Install and Run

### Prerequisites

Install a Java Development Kit (JDK).

Verify that Java and the compiler are available by opening PowerShell and running:

```powershell
java -version
javac -version
```

Both commands should display version information.

### Step 1: Download the Project

Clone the repository:

```powershell
git clone https://github.com/Vallabh-2946/capstone-CP099-vallabh.git
```

### Step 2: Navigate to the Project Directory

```powershell
cd capstone-CP099-vallabh
```

### Step 3: Compile the Java Files

```powershell
javac *.java
```

If compilation succeeds, the Java compiler returns to the terminal prompt without displaying errors.

### Step 4: Run the Application

```powershell
java Main
```

### Step 5: Use the Menu

The application displays a menu similar to the following:

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

Choose the desired operation by entering its corresponding number.

**Note:** The menu shown above describes the intended interface. Confirm the available options and their behavior against the current source code.

## 📁 Output Files

The application uses the `output/` directory for generated files.

Examples include:

| File | Purpose |
|---|---|
| `cleaned_customers.csv` | Example of an exported customer dataset. |
| `cleaned_employees.csv` | Intended export for employee records. |
| `cleaned_students.csv` | Intended export for student records. |
| `error_report.txt` | Example of a text report containing detected issues. |

Generated filenames and report contents depend on the dataset selected and the operations performed.

The original CSV files should remain in the `input/` directory so that the original data can be compared with the processed results.

## 🧪 Testing Checklist

Use the following checklist to verify the application.

- [ ] Compile all Java source files successfully.
- [ ] Load the customer dataset.
- [ ] Load the employee dataset.
- [ ] Load the student dataset.
- [ ] Display loaded records.
- [ ] Test valid and invalid email addresses.
- [ ] Test valid and invalid phone numbers.
- [ ] Test valid and invalid dates.
- [ ] Test duplicate detection.
- [ ] Verify whitespace cleaning.
- [ ] Verify city-name standardization.
- [ ] Export processed records.
- [ ] Open exported CSV files and inspect their contents.
- [ ] Generate an error report.
- [ ] Verify that reported errors correspond to the input records.
- [ ] Confirm that the original input files remain unchanged.

## 👥 Team Responsibilities

The work can be divided among team members as follows.

| Work Area | Relevant Files | Responsibility |
|---|---|---|
| Application integration | `Main.java` | Menu handling and connecting application features. |
| Data model and CSV input | `Record.java`, `CSVReader.java` | Representing records and reading input files. |
| Validation | `DataValidator.java` | Defining and implementing validation rules. |
| Duplicate detection | `DuplicateDetector.java` | Defining and testing duplicate-matching criteria. |
| Data cleaning | `DataCleaner.java` | Implementing standardization and cleaning operations. |
| Export and reporting | `CSVExporter.java`, `ErrorReporter.java` | Saving processed data and generating reports. |
| Testing and documentation | Test cases, `README.md`, project guide | Verifying behavior and documenting the project. |

Team members should coordinate changes and test the integrated application before presenting it.

## 🚀 Future Enhancements

Potential improvements include:

- Support for user-selected CSV files.
- More comprehensive CSV parsing and validation.
- Additional validation rules for different data types.
- Detailed error reports with suggested corrections.
- Configurable cleaning rules.
- A summary of errors before and after cleaning.
- Automated unit tests.
- A graphical user interface.
- Support for larger datasets and more file formats.

These are possible future improvements, not claims about features already implemented.

## 🏁 Conclusion

CleanSlate demonstrates how Java can be used to process CSV datasets, validate records, detect duplicate entries, standardize data, export processed files, and generate error reports.

Its modular structure separates reading, validation, duplicate detection, cleaning, exporting, and reporting into individual classes.

The project provides a foundation for understanding data quality and file processing while offering opportunities for further development and testing.

---

**Project:** CleanSlate — Data Validation and Cleansing Utility  
**Language:** Java  
**Interface:** Console-based  
**Repository:** [capstone-CP099-vallabh](https://github.com/Vallabh-2946/capstone-CP099-vallabh)
