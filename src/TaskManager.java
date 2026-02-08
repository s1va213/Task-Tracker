package src;
import java.util.*;
public class TaskManager {
  Map<Integer,List<Task>> TaskMap=new HashMap<>();
  public void addTask(User user,Task task){
    TaskMap.computeIfAbsent(user.getUserId(), k-> new ArrayList<>());
  }



}
