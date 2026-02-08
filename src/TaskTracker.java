package src;
import java.util.*;

class TaskTracker{
  public  static void print(String s){
    System.out.print(s);
  }
  public static void printLine(String s){
    System.out.println(s);
  }
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    print("this is Task Tracker Application,Welcome!!!");
    print(
  "Enter any of the below numbers to proceed:\n" +
  "1 - Login\n" +
  "2 - Sign up\n" +
  "3 - Show Menu\n" +
  "4 - Exit\n"
);
  boolean flag=true;
    while(flag){
      int n=sc.nextInt();
    sc.nextLine();
    switch (n) {
      case 1:
        printLine("Login  Selected:)");
        printLine("Enter your UserName:");
        String name=sc.nextLine();
        printLine(" Enter the password:");
        String password=sc.nextLine();
        User tempuser= new User(name);
        LoginUser.login(tempuser,password);

        break;
      case 2:
        printLine("Sign up Selected");
        printLine("Welcome To Task Tracker:)");
        printLine("Enter the UserName:");
        String userName=sc.nextLine();
        printLine("Enter the Password");
        String password1=sc.nextLine();
        printLine("Renter the Password");
        String password2=sc.nextLine();
        while(!(password1.equals(password2))){
          printLine("Enter the password again!!");
          password1=sc.nextLine();
          printLine("Renter the password:");
          password2=sc.nextLine();
        }
        UserSignUp.SignUp(userName, password2);

        break;
      case 3:
        break;
      case 4:
        flag=false;
        break;

    
      default:
        print("enter the valid option !!!");
        break;
    }
    }


    
    sc.close();
    
  }
 

}