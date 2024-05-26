package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetShelterApp {

    private static final String DATA_FILE = "pets.json";
    private List<Animal> animals;
    private ObjectMapper objectMapper;

    public PetShelterApp() {
        objectMapper = new ObjectMapper();
        animals = loadAnimals();
    }

    private List<Animal> loadAnimals() {
        try {
            File file = new File(DATA_FILE);
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<List<Animal>>() {
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private void saveAnimals() {
        try {
            objectMapper.writeValue(new File(DATA_FILE), animals);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPet() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter pet name: ");
        String name = scanner.nextLine();
        System.out.print("Enter pet breed: ");
        String breed = scanner.nextLine();
        System.out.print("Enter pet age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        animals.add(new Animal(name, breed, age));
        System.out.println("Pet added successfully.");
    }

    public void showAllPets() {
        if (animals.isEmpty()) {
            System.out.println("No pets in the shelter.");
        } else {
            for (int i = 0; i < animals.size(); i++) {
                System.out.println((i + 1) + ". " + animals.get(i));
            }
        }
    }

    public void takePetFromShelter() {
        Scanner scanner = new Scanner(System.in);
        showAllPets();
        if (!animals.isEmpty()) {
            System.out.print("Enter the number of the pet to take: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            if (index > 0 && index <= animals.size()) {
                animals.remove(index - 1);
                System.out.println("Pet removed successfully.");
            } else {
                System.out.println("Invalid number.");
            }
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add pet");
            System.out.println("2. Show all pets");
            System.out.println("3. Take pet from shelter");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPet();
                    break;
                case 2:
                    showAllPets();
                    break;
                case 3:
                    takePetFromShelter();
                    break;
                case 4:
                    saveAnimals();
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        PetShelterApp app = new PetShelterApp();
        app.run();
    }
}