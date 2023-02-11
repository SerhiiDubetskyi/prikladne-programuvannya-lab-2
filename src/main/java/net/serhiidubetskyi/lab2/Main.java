package net.serhiidubetskyi.lab2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Abiturient[] abiturients;
        String name;
        float mark;
        int top;

        while (true) {
            try {
                System.out.println("Enter the number of abiturients: ");
                abiturients = new Abiturient[Integer.parseInt(scanner.nextLine())];
                System.out.println("Enter abiturient name: ");
                name = scanner.nextLine();
                System.out.println("Enter desired mark: ");
                mark = Float.parseFloat(scanner.nextLine());
                System.out.println("Enter the number of top abiturients: ");
                top = Integer.parseInt(scanner.nextLine());
                if (top > abiturients.length) {
                    top = abiturients.length;
                }
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        ArrayList<Abiturient> desiredNameAbiturients = new ArrayList<>();
        ArrayList<Abiturient> desiredMarkAbiturients = new ArrayList<>();
        Abiturient[] topAbiturients = new Abiturient[top];

        for (int i = 0; i < abiturients.length; i++) {
            abiturients[i] = new Abiturient("Name" + i, "Surname" + i, "Patronymic" + i, "Address" + i, "PhoneNumber" + i, (float) (Math.random() * 100));

            if (Objects.equals(abiturients[i].getName(), name)) {
                desiredNameAbiturients.add(abiturients[i]);
            }

            if (abiturients[i].getAverageMark() > mark) {
                desiredMarkAbiturients.add(abiturients[i]);
            }
        }

        System.out.println("\nDesired name abiturients: ");
        for (Abiturient abit : desiredNameAbiturients) {
            System.out.println(abit);
        }

        System.out.println("\nDesired mark abiturients: ");
        for (Abiturient abit : desiredMarkAbiturients) {
            System.out.println(abit);
        }

        Arrays.sort(abiturients, (o1, o2) -> Float.compare(o1.getAverageMark(), o2.getAverageMark()));

        System.out.println("\nTop abiturients: ");
        for (int i = 0; i < top; i++) {
            topAbiturients[i] = abiturients[abiturients.length - i - 1];
            System.out.println(topAbiturients[i]);
        }
    }
}