import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public Scanner input = new Scanner(System.in);
    public String nomineeName;
    public String nomineeEmail;
    public String nomineeSchoolAttend;
    public Boolean isNomineeSenior;
    public Boolean isNomineeNominated;
    public Boolean isNomineeDrivingDistance;
    public String nomineeAge;
    public String nomineeNumber;
    public String nomineeGraduationDate;
    public String nomineeCurrentPlan;
    public ArrayList<String> threeElements = new ArrayList<String>();
    public void runner(){
        nomineeInfo();
    }

    private void nomineeInfo(){
        System.out.println("The following section will be about the Nominee.");
        nomineeName = getName();
        nomineeEmail = getEmail();
        nomineeSchoolAttend = getSchoolAttend();
        isNomineeSenior = getIsSenior();
        isNomineeNominated = getIsNominated();
        isNomineeDrivingDistance = getDrivingDistance();
        nomineeAge = getAge();
        nomineeNumber = getNumber();
        nomineeGraduationDate = getGraduationDate();
        nomineeCurrentPlan = getCurrentPlan();
        getElements();
    }

    public String getName(){
        System.out.println("Name: ");
        var name = input.nextLine();
        return name;
    }

    public String getEmail(){
        System.out.println("Email: ");
        var email = input.nextLine();
        return email;
    }

    public String getSchoolAttend(){
       System.out.println("School you currently attend: ");
       var school = input.nextLine();
       return school;
    }

    public Boolean getIsSenior(){
        while (true) {
       System.out.println("Are you a senior?\n[1]--YES\n[2]--NO");
       var choice = input.nextLine();

       if (choice.equals("1")){
           return true;
       } else if (choice.equals("2")) {
           return false;
       } else {
           System.out.println("Invalid choice");
        }
       }
    }

    public Boolean getIsNominated(){
        while (true) {
            System.out.println("Are you nominated?\n[1]--YES\n[2]--NO");
            var choice = input.nextLine();
            if (choice.equals("1")){
                return true;
            } else if (choice.equals("2")) {
                return false;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    public Boolean getDrivingDistance(){
        while (true) {
            System.out.println("Do you live within driving distance of Water Valley?\n[1]--YES\n[2]--NO");
            var choice = input.nextLine();
            if (choice.equals("1")){
                return true;
            } else if (choice.equals("2")) {
                return false;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    public String getAge(){
        System.out.println("Age: ");
        var age= input.nextLine();
        return age;
    }

    public String getNumber(){
        System.out.println("Phone Number: ");
        var number = input.nextLine();
        return number;
    }

    public String getGraduationDate(){
        System.out.println("Graduation Date: ");
        var date= input.nextLine();
        return date;
    }

    public String getCurrentPlan(){
        System.out.println("What do you plan to do after you graduate high school if it were not for Base Camp? ");
        var plan = input.nextLine();
        return plan;
    }

    public void getElements(){
        System.out.println("Aptitude: \nPlease share a specific example of when you were a strong problem solver. ");
        String answer1 = input.nextLine();
        System.out.println(answer1);
        threeElements.add(answer1);

        System.out.println("Dedication/ Work Ethic/ Heart: \nPlease share a specific example of your dedication and work ethic. ");
        String answer2 = input.nextLine();
        System.out.println(answer2);
        threeElements.add(answer2);

        System.out.println("Passion/ Persistence: \nPlease tell us about something you are passionate about and have worked hard to achieve. This can be clubs, sports teams, hobbies, church groups, etc. ");
        String answer3 = input.nextLine();
        System.out.println(answer3);
        threeElements.add(answer3);
    }
}
