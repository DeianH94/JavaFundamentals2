package exercises.vehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();
        String vehicleData = scanner.nextLine();

        while (!vehicleData.equalsIgnoreCase("end")) {
            String[] vehicleParams = vehicleData.split("\\s+");
            String type = vehicleParams[0];
            String model = vehicleParams[1];
            String color = vehicleParams[2];
            int horsepower = Integer.parseInt(vehicleParams[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsepower);
            vehicles.add(vehicle);

            vehicleData = scanner.nextLine();
        }

        String modelToDisplay = scanner.nextLine();

        while (!modelToDisplay.equalsIgnoreCase("close the catalogue")) {
            String finalModelToDisplay = modelToDisplay;
            vehicles.stream().filter(v -> v.getModel().equals(finalModelToDisplay)).forEach(System.out::println);

            modelToDisplay = scanner.nextLine();
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", averageHorsepower(vehicles.stream()
                .filter(v -> v.getVehicleType().equalsIgnoreCase("car"))
                .collect(Collectors.toList())));
        System.out.printf("Trucks have average horsepower of: %.2f.%n", averageHorsepower(vehicles.stream()
                .filter(v -> v.getVehicleType().equalsIgnoreCase("truck"))
                .collect(Collectors.toList())));
    }

    private static double averageHorsepower(List<Vehicle> vehicles) {
        if (vehicles.size() == 0) {
            return 0.0;
        }

        double sum = 0;

        for (Vehicle vehicle : vehicles) {
            sum += vehicle.getHorsepower();
        }

        return sum / vehicles.size();
    }
}
