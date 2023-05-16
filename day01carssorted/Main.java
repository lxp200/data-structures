import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    static ArrayList<Car> parking = new ArrayList<>();

    public static void main(String[] args) {

//        Car car1 = new Car("Toyota Corolla", 1.8, 2000);
//        Car car2 = new Car("Honda Accord", 2.0, 2021);
//        Car car3 = new Car("Ford Mustang", 5.0, 2019);
//        Car car4 = new Car("Chevrolet Camaro", 6.2, 2022);
//        Car car5 = new Car("Tesla Model S", 0.0, 2023);
//        Car car6 = new Car("Audi A3", 1.4, 2023);
//
//        parking.add(car1);
//        parking.add(car2);
//        parking.add(car3);
//        parking.add(car4);
//        parking.add(car5);
//        parking.add(car6);

        readDataFromFile();

        // print cars one by line
        System.out.println("\nCars: ");
        for (Car car : parking) {
            System.out.println(car.toString());
        }

        // sort by makeModel
        parking.sort(Comparator.comparing(car -> car.makeModel));
        System.out.println("\nCars sorted by makeModel: ");
        parking.forEach(System.out::println);

        // sort by engineSizeL
        parking.sort(Comparator.comparingDouble(car -> car.engineSizeL));
        System.out.println("\nCars sorted by engineSizeL:");
        parking.forEach(System.out::println);

        // sort by prodYear
        parking.sort(Comparator.comparingInt(car -> car.prodYear));
        System.out.println("\nCars sorted by prodYear:");
        parking.forEach(System.out::println);

        // sort by prodYear then makeModel
        parking.sort(Comparator.comparing(Car::getProdYear).thenComparing(Car::getMakeModel));
        System.out.println("\nCars sorted by prodYear then makeModel:");
        parking.forEach(System.out::println);

    }

    static void readDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("cars.txt"))) {

            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(";");
                String makeModel = parts[0].trim();
                double engineSizeL = Double.parseDouble(parts[1].trim());
                int prodYear = Integer.parseInt(parts[2].trim());

                Car car = new Car(makeModel, engineSizeL, prodYear);
                parking.add(car);

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
