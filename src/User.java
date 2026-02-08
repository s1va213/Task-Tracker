package src;
import java.util.*;

public class User {



public  static void print(String s){
    System.out.print(s);
  }
  public static void printLine(String s){
    System.out.println(s);
  }


  private int userId;
  private String name;
  private String password;
  private int age;
  private  static int  userCount=1;

  public User(String name,String password ){
    this.name=name;
    this.password=password;
    this.userId=generateUserId();
    }
    public User(String name){
      this.name=name;
    }


    public int getUserId(){
      return userId;
    }
    public String getUserName(){
      return name;
    }
    public boolean checkPassword(String password){
      return password.equals(this.password);
    }
    static int generateUserId(){
      return userCount++;
    }
    public void setAge(int age){
      this.age=age;
    }
    public int getAge(){
      return age;
    }
    
}


class LoginUser {

public  static void print(String s){
    System.out.print(s);
  }
  public static void printLine(String s){
    System.out.println(s);
  }





  public static Map<String,User> userMap=new HashMap<>();

  public LoginUser(User user,String password){
     
  }
  public static  void login(User user,String password){
     String nameKey=user.getUserName();
  boolean flag1=userMap.containsKey(nameKey);
  if(!flag1) {
    print("User Not Found :(");
    return; 
  }
  User storedUser =userMap.get(nameKey);
  boolean flag2=storedUser.checkPassword(password);
  if(!flag2) printLine("Wrong password");
  else printLine("Logged In Successfully");

  }
 
}
class UserSignUp{
  

  public  static void print(String s){
    System.out.print(s);
  }
  public static void printLine(String s){
    System.out.println(s);
  }

  public static void SignUp(String name,String password){
    User newUser =new User(name,password);
    if(LoginUser.userMap.containsKey(name)) printLine("User already exists!!");
    else{
        LoginUser.userMap.put(name,newUser);
        printLine("User Created successfully :)");
  }
  }
}

