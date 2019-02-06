import java.util.Scanner;

public class External {
//    This handles anyone outside Base Camp that wants to apply or nominate a candidate
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Application app = new Application();
    Nomination nom = new Nomination();
    var statement = true;
    while (statement) {
        System.out.println("[1]-- to nominate\n[2]-- to apply\n[3]-- to exit");
        var choice = input.nextLine();
        if (choice.equals("1")) {
            nom.runner();
        } else if (choice.equals("2")) {
            app.runner();
        } else if (choice.equals("3")){
            System.out.println("Have a good day!");
            System.exit(0);
        } else {
            System.out.println("Invalid input");
        }
    }
}
}
