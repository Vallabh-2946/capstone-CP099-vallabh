public class Record {

    String name;
    String email;
    String phone;
    String dob;
    String city;

    public Record(String name, String email, String phone,
                  String dob, String city) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.city = city;
    }

    public void display() {
        System.out.printf("%-20s %-28s %-12s %-12s %-15s%n",
                name, email, phone, dob, city);
    }
}