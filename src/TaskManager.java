package src;
import java.util.*;
public class TaskManager {



   public  static void print(String s){
    System.out.print(s);
  }
  public static void printLine(String s){
    System.out.println(s);
  }


  Map<Integer,List<Task>> TaskMap=new HashMap<>();
  public void addTask(User user,Task task){
    TaskMap.computeIfAbsent(user.getUserId(), k-> new ArrayList<>());
  }
  public void removeTask(User user,Task task){
    if(TaskMap.containsKey(user.getUserId())){
      TaskMap.get(user.getUserId()).remove(task);
      printLine("Task : "+task.getTaskTitle()+"removed Succesfuly");
    }
    else{
      printLine("Invalid User");
    }
  }
  public void VeiwTasks(User user){

    printLine("TaskName"+'\t'+'\t'+'\t'+"TaskDescription"+'\t'+'\t'+'\t'+'\t'+"start Date"+'\t'+"EndDate");
    for(Task task:TaskMap.get(user.getUserId())){
      printLine(task.getTaskTitle()+'\t'+'\t'+'\t'+task.getTaskDescription()+'\t'+task.getStartDate()+'\t'+task.getEndDate());
    }
  }



}
