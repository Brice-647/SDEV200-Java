// MyDate2 class (renamed from MyDate)
class MyDate2 {
    private int year;
    private int month; // 0-based: 0 for January
    private int day;

    public MyDate2() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        this.year = cal.get(java.util.Calendar.YEAR);
        this.month = cal.get(java.util.Calendar.MONTH);
        this.day = cal.get(java.util.Calendar.DAY_OF_MONTH);
    }

    public MyDate2(long elapsedTime) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTimeInMillis(elapsedTime);
        this.year = cal.get(java.util.Calendar.YEAR);
        this.month = cal.get(java.util.Calendar.MONTH);
        this.day = cal.get(java.util.Calendar.DAY_OF_MONTH);
    }

    public MyDate2(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}

// Base class
class Person {
    protected String name;
    protected String address;
    protected String phoneNumber;
    protected String emailAddress;

    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Person: " + name;
    }
}

// Subclass Student
class Student extends Person {
    public static final String FRESHMAN = "Freshman";
    public static final String SOPHOMORE = "Sophomore";
    public static final String JUNIOR = "Junior";
    public static final String SENIOR = "Senior";

    private String status;

    public Student(String name, String address, String phoneNumber, String emailAddress, String status) {
        super(name, address, phoneNumber, emailAddress);
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student: " + name;
    }
}

// Subclass Employee
class Employee extends Person {
    protected String office;
    protected double salary;
    protected MyDate2 dateHired;

    public Employee(String name, String address, String phoneNumber, String emailAddress,
                    String office, double salary, MyDate2 dateHired) {
        super(name, address, phoneNumber, emailAddress);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return "Employee: " + name;
    }
}

// Subclass Faculty
class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty(String name, String address, String phoneNumber, String emailAddress,
                   String office, double salary, MyDate2 dateHired,
                   String officeHours, String rank) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Faculty: " + name;
    }
}

// Subclass Staff
class Staff extends Employee {
    private String title;

    public Staff(String name, String address, String phoneNumber, String emailAddress,
                 String office, double salary, MyDate2 dateHired, String title) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
        this.title = title;
    }

    @Override
    public String toString() {
        return "Staff: " + name;
    }
}

// Test Program
public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person("Alice", "123 Main St", "555-1111", "alice@email.com");
        Student student = new Student("Bob", "456 Oak St", "555-2222", "bob@email.com", Student.SENIOR);
        Employee employee = new Employee("Charlie", "789 Pine St", "555-3333", "charlie@email.com",
                "Office 101", 50000, new MyDate2());
        Faculty faculty = new Faculty("Dana", "135 Maple St", "555-4444", "dana@email.com",
                "Office 202", 70000, new MyDate2(), "9am-5pm", "Professor");
        Staff staff = new Staff("Eve", "246 Birch St", "555-5555", "eve@email.com",
                "Office 303", 40000, new MyDate2(), "Administrator");

        System.out.println(person);
        System.out.println(student);
        System.out.println(employee);
        System.out.println(faculty);
        System.out.println(staff);
    }
}
