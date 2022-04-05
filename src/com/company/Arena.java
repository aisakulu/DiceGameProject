package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arena {

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Integer> diceForUser = new ArrayList<>();
    static ArrayList<Integer> predictForUser = new ArrayList<>();
    static ArrayList<Integer> resultForUser = new ArrayList<>();

    static ArrayList<Integer> diceForCpu = new ArrayList<>();
    static ArrayList<Integer> predictForCpu = new ArrayList<>();
    static ArrayList<Integer> resultForCpu = new ArrayList<>();

    static void playGame() {

        int userInput = 0;
        int count = 0;

        do {
            System.out.println("--------------- Start Game ----------------");
            System.out.println("Predict amount of points (2..12)");
            userInput = scanner.nextInt();
            predictForUser.add(userInput);

            int userSideOne = rollTheDice();
            int userSideTwo = rollTheDice();
            int userResult = userSideOne + userSideTwo;

            diceForUser.add(userResult);

            DiceSides.printDice(userSideOne);
            DiceSides.printDice(userSideTwo);

            System.out.println("On the Dice fell " + userResult + " points");

            int userPoints = showResult(userResult, userInput);
            resultForUser.add(userPoints);

            System.out.println("Result is " + userResult + " - abs(" + userResult +
                    " - " + userInput + ") * 2 = " + userPoints + " points");

            if (userPoints > 0) {
                System.out.println("User wins!!!");
            } else {
                System.out.println("User lost!!!");
            }
            System.out.println("\n---------------------------------------------\n");
            // Code for Computer
            int cpuInput = cpuRandomNumber();
            predictForCpu.add(cpuInput);

            int cpuSideOne = rollTheDice();
            int cpuSideTwo = rollTheDice();
            int cpuResult = userSideOne + userSideTwo;

            diceForCpu.add(cpuResult);

            DiceSides.printDice(cpuSideOne);
            DiceSides.printDice(cpuSideTwo);

            System.out.println("On the Dice fell " + cpuResult + " points");
            int cpuPoints = showResult(cpuResult, cpuInput);
            resultForCpu.add(cpuPoints);

            System.out.println("Result is " + cpuResult + " - abs(" + cpuResult +
                    " - " + cpuInput + ") * 2 = " + cpuPoints + " points");

            if (cpuPoints > 0) {
                System.out.println("Computer wins!!!");
            } else {
                System.out.println("Computer lost!!!");
            }

            System.out.println("\n---------------------------------------------\n");

            System.out.println("-------------- Current Score -----------------");
            System.out.println("User: " + userPoints + " points");
            System.out.println("Computer: " + cpuPoints + " points");

            if (userPoints > cpuPoints) {
                int resultForUser = userPoints - cpuPoints;
                System.out.println("User is ahead by " + resultForUser + " points");
            } else {
                int resultForCpu = cpuPoints - userPoints;
                System.out.println("Computer is ahead by " + resultForCpu + " points");
            }
            count++;
        } while (count < 3);
        System.out.println();

        printTotalResult();
    }

    public static void printTotalResult() {
        System.out.println("-------------------- Game Over --------------" + "\n" +
                " Round    |          User     |     Computer" + "\n" +
                "----------+-------------------+--------------" + "\n" +
                "          | Predicated: " + predictForUser.get(0) + "     | Predicated: " + predictForCpu.get(0) + "\n" +
                "   -1-    | Dice: " + diceForUser.get(0) + "           | Dice: " + diceForCpu.get(0) + "\n" +
                "          | Result: " + resultForUser.get(0) + "         | Result: " + resultForCpu.get(0) + "\n" +
                "----------+-------------------+--------------" + "\n" +
                "          | Predicated: " + predictForUser.get(1) + "     | Predicated: " + predictForCpu.get(1) + "\n" +
                "   -2-    | Dice: " + diceForUser.get(1) + "           | Dice: " + diceForCpu.get(1) + "\n" +
                "          | Result: " + resultForUser.get(1) + "         | Result: " + resultForCpu.get(1) + "\n" +
                "----------+-------------------+--------------" + "\n" +
                "          | Predicated: " + predictForUser.get(2) + "     | Predicated: " + predictForCpu.get(2) + "\n" +
                "   -3-    | Dice: " + diceForUser.get(2) + "           | Dice: " + diceForCpu.get(2) + "\n" +
                "          | Result: " + resultForUser.get(2) + "         | Result: " + resultForCpu.get(2) + "\n" +
                "----------+-------------------+--------------" + "\n" +
                " Total    |       Points: " + totalPoint(resultForUser) + "   |     Points: " + totalPoint(resultForCpu) + "\n");

        int totalForUser = totalPoint(resultForUser) - totalPoint(resultForCpu);
        int totalForCpu = totalPoint(resultForCpu) - totalPoint(resultForUser);

        if (totalForUser > totalForCpu) {
            System.out.println("User win " + totalForUser + " points more. Congrats!");
        } else {
            System.out.println("Computer win " + totalForCpu + " points more. Congrats!");
        }
    }

    private static int totalPoint(ArrayList<Integer> points) {
        int sum = 0;
        for (int i = 0; i < points.size(); i++) {
            sum = sum + points.get(i);
        }
        return sum;
    }

    public static int cpuRandomNumber() {
        return random.nextInt(2, 13);
    }

    public static int showResult(int userResult, int userInput) {
        return userResult - Math.abs(userResult - userInput) * 2;
    }

    public static int rollTheDice() {
        return random.nextInt(1, 7);
    }
}
