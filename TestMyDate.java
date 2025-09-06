public class TestMyDate {
    public static void main(String[] args) {
        // Create MyDate object for current date
        MyDate date1 = new MyDate();
        System.out.println("Current date: " +
                date1.getYear() + "-" +
                (date1.getMonth() + 1) + "-" + // +1 because month is 0-based
                date1.getDay());

        // Create MyDate object from elapsed time
        MyDate date2 = new MyDate(34355555133101L);
        System.out.println("Elapsed time date: " +
                date2.getYear() + "-" +
                (date2.getMonth() + 1) + "-" +
                date2.getDay());
    }
}
