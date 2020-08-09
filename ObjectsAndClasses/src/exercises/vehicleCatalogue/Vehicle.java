package exercises.vehicleCatalogue;

public class Vehicle {
    private String vehicleType;
    private String model;
    private String color;
    private int horsepower;

    public Vehicle() {
    }

    public Vehicle(String vehicleType, String model, String color, int horsepower) {
        this.setVehicleType(vehicleType);
        this.setModel(model);
        this.setColor(color);
        this.setHorsepower(horsepower);
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType.substring(0, 1).toUpperCase() + vehicleType.substring(1);
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%n" +
                        "Model: %s%n" +
                        "Color: %s%n" +
                        "Horsepower: %d",
                this.getVehicleType(),
                this.getModel(),
                this.getColor(),
                this.getHorsepower());
    }
}
