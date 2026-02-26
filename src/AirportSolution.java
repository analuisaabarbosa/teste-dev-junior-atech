import java.util.Scanner;

public class AirportSolution {
    
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            
            int numPassengers = Integer.parseInt(scanner.nextLine());

            int[] entries = new int[numPassengers];
            for (int i = 0; i < numPassengers; i++) {
                entries[i] = scanner.nextInt();
            }

            int[] exits = new int[numPassengers];
            for (int i = 0; i < numPassengers; i++) {
                exits[i] = scanner.nextInt();
            }

            int maxOccupancy = calculateMaxOccupancy(numPassengers, entries, exits);

            System.out.println(maxOccupancy);
        }
    }

    public static int calculateMaxOccupancy(int numPassengers, int[] entries, int[] exits) {
        int[] timeline = new int[1001];

        for (int i = 0; i < numPassengers; i++) {
            int entryTime = entries[i];
            int exitTime = exits[i];

            for (int t = entryTime; t < exitTime; t++) {
                timeline[t]++;
            } 
        }

        int maxOccupancy = 0;
        for (int t = 0; t < timeline.length; t++) {
            if (timeline[t] > maxOccupancy) {
                maxOccupancy = timeline[t];
            }
        }
        return maxOccupancy;

    }

}