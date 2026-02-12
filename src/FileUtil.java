package src;
import java.io.*;
import java.util.*;

public class FileUtil {

     public  static void print(String s){
    System.out.print(s);
  }
  public static void printLine(String s){
    System.out.println(s);
  }
  private static  final String FILE_PATH= "data/users.txt";

  public static Map<String,User> loadUser(){

    int maxId=0;

    Map<String,User> userMap=new HashMap<>();

    try(BufferedReader br=new BufferedReader(new FileReader(FILE_PATH))){
      String line;
      while((line=br.readLine())!=null){

        String[] contents=line.split(",");
        if(contents.length<3) continue;
        int userId=Integer.parseInt(contents[0]);
        String userName=contents[1];
        String password=contents[2];
        User user=new User(userId,userName,password);
        userMap.put(userName, user);
        maxId=Math.max(maxId,userId);
      }
      User.setUserCount(maxId+1);

    }
    catch(IOException e){

      printLine("User Files are Not Found Sry :(");
    }


    return userMap;
  }




  public static void saveUser(User user){

    try( BufferedWriter bw=new BufferedWriter(new FileWriter(FILE_PATH,true))){

      bw.write(user.getUserId()+","+user.getUserName()+","+user.getPassword());
      bw.newLine();
    }
    catch(IOException e){

      printLine("User Files are Not Found Sry :(");
    }
  }
}
