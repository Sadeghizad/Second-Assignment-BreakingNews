package AP;

import java.util.Scanner;

public class NewsAppNoGUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Infrastructure infra = new Infrastructure("ce282472d9a8479b8808363fe180864e","tesla");
        infra.displayNewsList();

        System.out.print("\nChoose an article number to read details (0 to exit): ");
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= infra.getNewsList().size()) {
            infra.getNewsList().get(choice - 1).displayNews();
        } else if (choice != 0) {
            System.out.println("Invalid selection. Exiting.");
        }
    }
}
