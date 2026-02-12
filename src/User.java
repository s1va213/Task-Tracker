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
    public User(int id,String name,String password ){
      userId=id;
      this.name=name;
      this.password=password;

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
    public String getPassword(){
      return password;    }
    
      
      public  static void setUserCount(int n){
        userCount=n;
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
  public static  User login(User user,String password){
    User storedUser=null;
     String nameKey=user.getUserName();
  boolean flag1=userMap.containsKey(nameKey);
  if(!flag1) {
    print("User Not Found :(");
    return storedUser; 
  }
  storedUser =userMap.get(nameKey);
  boolean flag2=storedUser.checkPassword(password);
  if(!flag2) printLine("Wrong password");
  else printLine("Logged In Successfully\n\n\n");
  return storedUser;
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
        FileUtil.saveUser(newUser);
        printLine("User Created successfully :)\n\n");
  }
  }
}

