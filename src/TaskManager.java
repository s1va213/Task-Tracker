package src;
import java.util.*;
public class TaskManager {



   public  static void print(String s){
    System.out.print(s);
  }
  public static void printLine(String s){
    System.out.println(s);
  }


   static Map<Integer,List<Task>> TaskMap=new HashMap<>();
  public static void addTask(User user,Task task){
    TaskMap.computeIfAbsent(user.getUserId(), k-> new ArrayList<>()).add(task);
  }
  public static void removeTask(User user,Task task){
    if(TaskMap.containsKey(user.getUserId())){
      TaskMap.get(user.getUserId()).remove(task);
      printLine("Task : "+task.getTaskTitle()+"removed Succesfuly");
    }
    else{
      printLine("Invalid User");
    }
  }
  public static void VeiwTasks(User user){

    printLine("TaskID"+'\t'+"TaskName"+'\t'+'\t'+'\t'+"TaskDescription"+'\t'+'\t'+'\t'+'\t'+"start Date"+'\t'+"EndDate");
    List<Task> TaskList=TaskMap.get(user.getUserId());

    if(TaskList==null || TaskList.isEmpty()) {
      printLine("No Tasks Found ,Add some Tasks :)");
      return;
    }
    for(Task task:TaskList){
      printLine(task.getTaskId()+"."+'\t'+task.getTaskTitle()+'\t'+'\t'+'\t'+task.getTaskDescription()+'\t'+task.getStartDate()+'\t'+task.getEndDate());
    }
  }
  public static Task findTask( User user ,int taskId){
    Task result=null;
    List<Task> list=TaskMap.get(user.getUserId());
    if( list==null || list.isEmpty() ){
      printLine("No tasks Found");
    }
    for(Task t:list){
      if(t.getTaskId()==taskId){
        return t;
      }
    }
    return result;
  }
  public static void editTaskTitle(Task task,String TaskTitle){
    task.setTaskTitle( TaskTitle);
  }

  public static void editTaskDescription(Task task ,String description){
    task.setTaskdescription( description);
  }


}
