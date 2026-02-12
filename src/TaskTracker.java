package src;
import java.util.*;

class TaskTracker{
  public  static void print(String s){
    System.out.print(s);
  }
  public static void printLine(String s){
    System.out.println(s);
  }
  static User currentUser=null;
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    LoginUser.userMap=FileUtil.loadUser();
    print("\n\n\nthis is Task Tracker Application,Welcome!!! :)");
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
         User loggedUser =LoginUser.login(tempuser,password);
         if(loggedUser!=null) currentUser=loggedUser;
         showMenu();

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
        if(currentUser==null) printLine("please login to show the menu :)");
        else{
          showMenu();
        }
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
  public static void showMenu(){
    Scanner sc=new Scanner(System.in);
    boolean flag=true;
    int n;
    while(flag){
      printLine("\n\nPlease Enter Option\n"+
        "1-view tasks\n"+
        "2-add tasks\n"+
        "3-remove tasks\n"+
        "4-edit tasks\n"+
        "5-exit"
      );
      n=sc.nextInt();
      sc.nextLine();
      switch (n) {
        case 1:
          TaskManager.VeiwTasks(currentUser);
          break;
        case 2:
          TaskManager.VeiwTasks(currentUser);
          printLine("Enter the taskName");
          String taskName=sc.nextLine();
          printLine("Enter the task description");
          String taskDescription=sc.nextLine();
          Task newTask=new Task(taskName, taskDescription);
          TaskManager.addTask(currentUser,newTask);
          TaskManager.VeiwTasks(currentUser);
          break;
          // yet to complete
        case 3:
          TaskManager.VeiwTasks(currentUser);
          printLine("Enter the taskId to be removed:");
          int TaskId=sc.nextInt();
          sc.nextLine();
          Task task=TaskManager.findTask(currentUser, TaskId);
          if(task!=null){
            TaskManager.removeTask(currentUser, task);
            TaskManager.VeiwTasks(currentUser);
          }
          else printLine("Enter a valid task to remove !!");

          
          break;
        case 4:
          TaskManager.VeiwTasks(currentUser);
          printLine("Enter the TaskId to  change");
          int TaskId2=sc.nextInt();
          Task editTask=TaskManager.findTask(currentUser, TaskId2);
          printLine("Enter the options"+"1-change name "+" 2- change description");
          int ch=sc.nextInt();
          sc.nextLine();
          boolean flag2 =true;
          while(flag2){
            if(ch==1){
            printLine("Enter the new name");
            String newTitle=sc.nextLine();
            TaskManager.editTaskTitle(editTask,newTitle);
            flag2=false;
          }
          else if(ch==2){
            printLine("enter the new task description:");
            String newDes =sc.nextLine();
            TaskManager.editTaskDescription(editTask, newDes);
            flag2=false;
          }
          else printLine("enter the valid option");
          }

          break;
        case 5:
          printLine("Thank You :)");
          return;
        default:
          break;
      }
      
    }
    sc.close();
  }
 

}