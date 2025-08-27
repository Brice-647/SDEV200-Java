public class Exercise6_9{
    public static void main(String[] args) {

    //define headers
    String header1 = "Feet";
    String header2 = "Meters";
    String header3 = "Meters";
    String header4 = "Feet";
    //Header formatting + seperator
    System.out.printf("%-5s | %-5s  %15s | %-20s%n", header1, header2, header3, header4);
        System.out.println("------------------------------------------------------------------");
    
    //loop to print the conversion table
    for(int i = 1, j = 20; i <= 10; i++, j += 5){
        System.out.printf("%-5d | %-5.3f  %15d | %-20.3f%n", i, footToMeter(i), j, meterToFoot(j));
        }
    }

public static double footToMeter(double foot){
    return foot * 0.305;
    }

public static double meterToFoot(double meter){
    return meter * 3.279;
    }
}    