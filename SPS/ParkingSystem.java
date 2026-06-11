package com.mycompany.smartparking;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ParkingSystem {

    private final ArrayList<String> parkingSlots;
    private final Queue<String> vehicleQueue;
    private final Stack<String> actionHistory;

    public ParkingSystem() {

        parkingSlots = new ArrayList<>();
        vehicleQueue = new LinkedList<>();
        actionHistory = new Stack<>();
    }

    // Add Parking Slot
    public void addParkingSlot(String slotID) {

        parkingSlots.add(slotID);

        actionHistory.push("ADD_SLOT:" + slotID);

        System.out.println("Parking Slot " + slotID + " added.");
    }

    // Remove Parking Slot
    public void removeParkingSlot(String slotID) {

        if (parkingSlots.remove(slotID)) {

            actionHistory.push("REMOVE_SLOT:" + slotID);

            System.out.println("Parking Slot " + slotID + " removed.");

        } else {

            System.out.println("Slot not found.");
        }
    }

    // Display Parking Slots
    public void displayParkingSlots() {

        System.out.println("\n===== Parking Slots =====");

        if (parkingSlots.isEmpty()) {

            System.out.println("No parking slots available.");
            return;
        }

        for (String slot : parkingSlots) {

            System.out.println(slot);
        }
    }

    // Vehicle Enter
    public void vehicleEnter(String plateNumber) {

        vehicleQueue.offer(plateNumber);

        actionHistory.push("ENTER:" + plateNumber);

        System.out.println(plateNumber + " entered parking.");
    }

    // Vehicle Exit
    public void vehicleExit() {

        if (vehicleQueue.isEmpty()) {

            System.out.println("No vehicle inside parking.");
            return;
        }

        String vehicle = vehicleQueue.poll();

        actionHistory.push("EXIT:" + vehicle);

        System.out.println(vehicle + " exited parking.");
    }

    // Display Vehicles
    public void displayVehicles() {

        System.out.println("\n===== Vehicles In Queue =====");

        if (vehicleQueue.isEmpty()) {

            System.out.println("No vehicles.");
            return;
        }

        for (String vehicle : vehicleQueue) {

            System.out.println(vehicle);
        }
    }

    // Undo Function
    public void undo() {

        if (actionHistory.isEmpty()) {

            System.out.println("Nothing to undo.");
            return;
        }

        String lastAction = actionHistory.pop();

        String[] parts = lastAction.split(":");

        String action = parts[0];
        String value = parts[1];

        switch (action) {

            case "ADD_SLOT" -> {
                parkingSlots.remove(value);

                System.out.println("Undo: Added Slot "
                        + value + " removed.");
            }

            case "REMOVE_SLOT" -> {
                parkingSlots.add(value);

                System.out.println("Undo: Removed Slot "
                        + value + " restored.");
            }

            case "ENTER" -> {
                vehicleQueue.remove(value);

                System.out.println("Undo: Vehicle "
                        + value + " entry cancelled.");
            }

            case "EXIT" -> {
                LinkedList<String> temp =
                        (LinkedList<String>) vehicleQueue;

                temp.addFirst(value);

                System.out.println("Undo: Vehicle "
                        + value + " restored.");
            }

            default -> System.out.println("Undo failed.");
        }
    }
}