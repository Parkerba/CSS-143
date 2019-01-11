import java.util.Scanner;

public class Lect1 {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = keyboard.next();
        int nameLength = name.length();
        String secondHalf = name.substring(nameLength / 2);
        String firstHalf = name.substring(0, nameLength / 2);
        String flippedName = secondHalf + firstHalf;
        System.out.println("How old are you?");
        int age = keyboard.nextInt();
        int birthYear = 2019 - age;
        String[] randomArr = new String[age/4];
        for (int i = 0; i < age/4; i ++) {
            System.out.printf(flippedName + " was born in %d\n", birthYear);
            randomArr[i] = secondHalf + i;
        }
        for(String j : randomArr)
            System.out.println(j);
        keyboard.close();
        System.out.println(Math.pow(2,.5));
    }
}
