package com.mycompany.smartparking;

import java.util.Scanner;

public class SmartParking {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            ParkingSystem system = new ParkingSystem();
            
            int choice;
            
            do {
                
                System.out.println("\n========================");
                System.out.println(" SMART PARKING SYSTEM ");
                System.out.println("========================");
                System.out.println("1. Add Parking Slot");
                System.out.println("2. Remove Parking Slot");
                System.out.println("3. Display Parking Slots");
                System.out.println("4. Vehicle Enter");
                System.out.println("5. Vehicle Exit");
                System.out.println("6. Display Vehicles");
                System.out.println("7. Undo");
                System.out.println("0. Exit");
                
                System.out.print("Choose: ");
                choice = sc.nextInt();
                sc.nextLine();
                
                switch (choice) {
                    
                    case 1 -> {
                        System.out.print("Enter Slot ID: ");
                        String addSlot = sc.nextLine();
                        system.addParkingSlot(addSlot);
                    }
                    
                    case 2 -> {
                        System.out.print("Enter Slot ID: ");
                        String removeSlot = sc.nextLine();
                        system.removeParkingSlot(removeSlot);
                    }
                    
                    case 3 -> system.displayParkingSlots();
                    
                    case 4 -> {
                        System.out.print("Enter Vehicle Plate: ");
                        String plate = sc.nextLine();
                        system.vehicleEnter(plate);
                    }
                    
                    case 5 -> system.vehicleExit();
                    
                    case 6 -> system.displayVehicles();
                    
                    case 7 -> system.undo();
                    
                    case 0 -> System.out.println("Program End.");
                    
                    default -> System.out.println("Invalid Choice.");
                }
                
            } while (choice != 0);
        }
    }
}