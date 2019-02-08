import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nomination {
    private Scanner input = new Scanner(System.in);
    private String nominatorName;
    private String nominatorEmail;
    private String nominatorSchoolDistrict;
    private String nominatorPosition;
    private String nominatorRelation;
    private String nomineeName;
    private String nomineeAge;
    private String nomineeGraduationDate;
    private ArrayList<String> fourElements = new ArrayList<String>();
    private String extraComments = "";
    public void runner() {
        nominatorInfo();
        var statement = true;
        while (statement) {
            System.out.println("[1]-- to nominate\n[2]-- to exit");
            var choice = input.nextLine();
            if (choice.equals("1")) {
                nomineeInfo();
                writeToFile();
            } else if (choice.equals("2")) {
                statement = false;
            } else {
                System.out.println("Invalid input");
            }
        }

    }

    private void nominatorInfo() {
        System.out.println("The following section will be about you the Nominator.");
        nominatorName = getName();
        System.out.println("1 of 5 completed");
        getEmail();
        System.out.println("2 of 5 completed");
        nominatorSchoolDistrict = getDistrict();
        System.out.println("3 of 5 completed");
        nominatorPosition = getPosition();
        System.out.println("4 of 5 completed");
        nominatorRelation = getRelation();
        System.out.println("5 of 5 completed");
    }

    public String getPosition() {
        System.out.println("Enter your position in your district: ");
        var position = input.nextLine();
        return position;
    }

    private void nomineeInfo() {
        System.out.println("The following section will be about the Nominee.");
        Boolean statement = true;
        nomineeName = getName();
        nomineeAge = getAge();
        nomineeGraduationDate = getGraduationDate();
        getElements();
        while (statement) {
            System.out.println("[1] -- to make a comment\n[2] -- to not make a comment");
            String choice = input.nextLine();
            if (choice.equals("1")){
                System.out.println("Enter comment: ");
                extraComments = input.nextLine();
            } else if(choice.equals("2")){
                System.out.println("No comment made!");
                statement = false;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public void getElements() {
        System.out.println("Aptitude:\nDo you have any experiences when this student has\ndemonstrated a strong ability to think logically and/or strategically?");
        String answer1 = input.nextLine();
        System.out.println(answer1);
        fourElements.add(answer1);
        System.out.println("Perseverance:\nIs there any evidence of the applicant being engaged in something\nthey are passionate about?");
        String answer2 = input.nextLine();
        fourElements.add(answer2);
        System.out.println("Dedication:\nDo you think the applicant would be able to reliably\nattend the programs five days a week in Water Valley?");
        String answer3 = input.nextLine();
        fourElements.add(answer3);
        System.out.println("Work Ethic / Heart:\nWhy does this student deserve a position at Base Camp?");
        String answer4 = input.nextLine();
        fourElements.add(answer4);
    }

    public String getGraduationDate() {
        System.out.println("Enter graduation date (Example: May 2019): ");
        var date = input.nextLine();
        return date;
    }

    public String getAge() {
        System.out.println("Enter age: ");
        var age = input.nextLine();
        return age;
    }

    public String getName() {
        System.out.println("Enter Name: ");
        var name = input.nextLine();
        return name;
    }

    public void getEmail() {
        var statement = true;
        while (statement) {
        System.out.println("Enter email:");
        var email = input.nextLine();
        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        if (matcher.find()) {
            nominatorEmail = email;
            statement = false;
        } else {
            System.out.println("Invalid email");
        }
        }
    }

    public String getDistrict() {
        System.out.println("Enter your school district: ");
        var district = input.nextLine();
        return district;
    }

    public String getRelation() {
        System.out.println("Enter your relation to the nominee: ");
        var relation = input.nextLine();
        return relation;
    }

    public void viewNominationQuestions() {
        System.out.println("Enter your position in your district: ");
        System.out.println("Enter graduation date: ");
        System.out.println("Enter Age: ");
        System.out.println("Enter Name: ");
        System.out.println("Enter email: ");
        System.out.println("Enter you school district: ");
        System.out.println("Enter you relation to the nominee: ");
        System.out.println("Comments about the student's aptitude, perseverance, dedication, and the work ethic of the student. ");
        System.out.println();
    }

    public void writeToFile(){
        try{
            String nominatorInfoString = "Nominator Info:\nName: "+nominatorName+"\nEmail Address: " + nominatorEmail  +"\nSchool District: "+ nominatorSchoolDistrict+"\nPosition: "+nominatorPosition+"\nRelation to Nominee: "+nominatorRelation;
            String nomineeInfoString = "\nNominee Info\nName:" + nomineeName+"\nAge: "+nomineeAge +"\nGraduation Date:"+ nomineeGraduationDate;
            String fourElementString = "\nAptitude:\n"+fourElements.get(0)+"\nPerseverance:\n"+fourElements.get(1)+"\nDedication:\n"+fourElements.get(2)+"\nWork Ethic / Heart:\n"+fourElements.get(3);
            String commentString = "\nExtra Comments(can be blank):\n"+extraComments;
            String string = nominatorInfoString+nomineeInfoString+fourElementString+commentString;
            FileWriter writer = new FileWriter("src/nominations/"+nomineeName+".txt");
            writer.write(string);
            writer.close();
        }catch(IOException ex){
            // Commented out for development ex.printStackTrace();
            System.out.println("File or Folder not found!");
        }
    }

    public void nomReader(String currentStudent) {
        try{
            File file = new File("src/nominations/" + currentStudent + ".txt");

            BufferedReader data = new BufferedReader(new FileReader(file));

            String str;
            while ((str = data.readLine()) != null)
                System.out.println(str);
        }
        catch (IOException ex){
//            Commented out for development ex.printStackTrace();
            System.out.println("Nomination does not exist!");
        }
    }
}