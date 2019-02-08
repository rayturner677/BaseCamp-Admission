import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private Scanner input = new Scanner(System.in);
    private String nomineeName;
    private String nomineeEmail;
    private String nomineeSchoolAttend;
    private Boolean isNomineeSenior;
    private Boolean isNomineeNominated;
    private Boolean isNomineeDrivingDistance;
    private  String nomineeSeniorResponse;
    private String nomineeNominatedResponse;
    private  String nomineeDistanceResponse;
    private String nomineeAge;
    private String nomineeNumber;
    private String nomineeGraduationDate;
    private String nomineeCurrentPlan;
    private ArrayList<String> threeElements = new ArrayList<>();
    public void runner(){
        nomineeInfo();
    }

    private void nomineeInfo(){
        System.out.println("The following section will be about the Nominee.");
        nomineeName = getName();
        System.out.println("1 of 11 completed");
        nomineeEmail = getEmail();
        System.out.println("2 of 11 completed");
        nomineeSchoolAttend = getSchoolAttend();
        System.out.println("3 of 11 completed");
        isNomineeSenior = getIsSenior();
        System.out.println("4 of 11 completed");
        isNomineeNominated = getIsNominated();
        System.out.println("5 of 11 completed");
        isNomineeDrivingDistance = getDrivingDistance();
        System.out.println("6 of 11 completed");
        nomineeAge = getAge();
        System.out.println("7 of 11 completed");
        getNumber();
        System.out.println("8 of 11 completed");
        nomineeGraduationDate = getGraduationDate();
        System.out.println("9 of 11 completed");
        nomineeCurrentPlan = getCurrentPlan();
        System.out.println("10 of 11 completed");
        getElements();
        System.out.println("11 of 11 completed");
        nomineeSeniorResponse = getSeniorResponse();
        nomineeNominatedResponse = getNominatedResponse();
        nomineeDistanceResponse = getNomineeDistanceResponse();
        writeToFile();
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
        File file = new File("src/nominations/"+nomineeName+".txt");
        Boolean exists = file.exists();
        while (true) {
            System.out.println("Are you nominated?\n[1]--YES\n[2]--NO");
            var choice = input.nextLine();
            if (choice.equals("1") && exists.equals(true)){
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

    public void getNumber(){
        String pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        System.out.println("Valid Phone Number Formats:\n1234567890\n123-456-7890\n(123)456-7890\n(123)4567890");
        var statement = true;
        while (statement) {
        System.out.println("Phone Number: ");
        var number = input.nextLine();
        if (number.matches(pattern)) {
            nomineeNumber = number;
            statement = false;
        } else {
            System.out.println("Invalid phone number!");
        }
    }
    }

    public String getGraduationDate(){
        System.out.println("Graduation Date (Example: May 2019): ");
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
        threeElements.add(answer1);

        System.out.println("Dedication/ Work Ethic/ Heart: \nPlease share a specific example of your dedication and work ethic. ");
        String answer2 = input.nextLine();
        threeElements.add(answer2);

        System.out.println("Passion/ Persistence: \nPlease tell us about something you are passionate about and have worked hard to achieve. This can be clubs, sports teams, hobbies, church groups, etc. ");
        String answer3 = input.nextLine();
        threeElements.add(answer3);
    }

    public void viewApplicationQuestions(){
        System.out.println("School you currently attend: ");
        System.out.println("Phone Number: ");
        System.out.println("Enter graduation date: ");
        System.out.println("Enter Age: ");
        System.out.println("Enter Name: ");
        System.out.println("Enter email: ");
        System.out.println("Enter you school district: ");
        System.out.println("Current plan to do after you graduate if it were not for Base Camp?");
        System.out.println("You will be asked about your aptitude, dedication, work ethic, heart, and passion.");
    }

    public String getSeniorResponse() {
        if (isNomineeSenior.equals(true)){
            return "I am a high school senior";
        } else {
            return "I am not a high school senior";
        }
    }
    public String getNominatedResponse() {
        if (isNomineeNominated.equals(true)){
            return "I have been nominated";
        } else {
            return "I have not been nominated";
        }
    }
    public String getNomineeDistanceResponse() {
        if (isNomineeDrivingDistance.equals(true)){
            return "I live within driving distance of Water Valley, MS";
        } else {
            return "I do not live within driving distance of Water Valley, MS";
        }
    }
    public void writeToFile(){
        try{
            String basicInfoString = "Applicant Info:\nName: "+nomineeName+"\nEmail Address: " + nomineeEmail  +"\nSchool Attending: "+ nomineeSchoolAttend;
            String eligibilityString ="\nHigh School Senior: "+nomineeSeniorResponse+"\nNominated: "+nomineeNominatedResponse+"\nLives in driving distance: "+nomineeDistanceResponse;
            String inDepthInfoString = "\nAge:" + nomineeAge +"\nPhone Number: "+nomineeNumber +"\nGraduation Date:"+ nomineeGraduationDate+"\nAlternate Plan: "+nomineeCurrentPlan;
            String threeElementString = "\nAptitude:\n"+threeElements.get(0)+"\nDedication/ Work Ethic/ Heart:\n"+threeElements.get(1)+"\nPassion/ Persistence:\n"+threeElements.get(2)+"\n";
            String string = basicInfoString+eligibilityString+inDepthInfoString+threeElementString;
            FileWriter writer = new FileWriter("src/applications/"+nomineeName+".txt");
            writer.write(string);
            writer.close();
        }catch(IOException ex){
            // Commented out for development ex.printStackTrace();
            System.out.println("File or Folder not found!");
        }
    }

    public void readFromFile(String currentStudent) {
        try{
            File file = new File("src/applications/" + currentStudent + ".txt");

            BufferedReader data = new BufferedReader(new FileReader(file));

            String str;
            while ((str = data.readLine()) != null)
                System.out.println(str);
        }
        catch (IOException ex){
//            Commented out for development ex.printStackTrace();
            System.out.println("Application does not exist");
        }
    }
}
