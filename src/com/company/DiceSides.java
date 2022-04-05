package com.company;


public class DiceSides {

//    static Random random = new Random();

    public static void printDice(int sides) {

        switch (sides) {
            case 1 -> System.out.println("""
                    +-------+
                    |       |
                    |   #   |
                    |       |
                    +-------+                 
                    """);
            case 2 -> System.out.println("""
                    +-------+
                    | #     |
                    |       |
                    |     # |
                    +-------+
                    """);
            case 3 -> System.out.println("""
                    +-------+
                    | #     |
                    |   #   |
                    |     # |
                    +-------+
                    """);
            case 4 -> System.out.println("""
                    +-------+
                    | #   # |
                    |       |
                    | #   # |
                    +-------+
                    """);
            case 5 -> System.out.println("""
                    +-------+
                    | #   # |
                    |   #   |
                    | #   # |
                    +-------+
                    """);
            case 6 -> System.out.println("""
                    +-------+
                    | #   # |
                    | #   # |
                    | #   # |
                    +-------+
                    """);
        }

    }
}
