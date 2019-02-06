import java.util.Scanner;

public class External {
    //    This handles anyone outside Base Camp that wants to apply or nominate a candidate
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Application app = new Application();
        Nomination nom = new Nomination();
        var statement = true;
        while (statement) {
            System.out.println("[1]-- to nominate\n[2]-- to apply\n[3]-- view question\n[4] to exit");
            var choice = input.nextLine();
            if (choice.equals("1")) {
                nom.runner();
            } else if (choice.equals("2")) {
                app.runner();
            } else if (choice.equals("3")) {
                System.out.println("[1]-- view nomination questions\n[2]-- view application questions");
                Scanner q_input = new Scanner(System.in);
                var view_questions = q_input.nextLine();

                if (view_questions.equals("1")){
                    nom.viewNominationQuestions();
                }else if (view_questions.equals("2")){
                    app.viewApplicationQuestions();
                }else {
                    System.out.println("invalid response");
                }

            } else if (choice.equals("4")) {
                System.out.println("Have a good day!");
                System.exit(0);
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
