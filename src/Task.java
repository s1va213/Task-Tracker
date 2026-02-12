package src;
// import java.util.*;
import java.time.*;
enum Status{
  COMPLETED,PENDING,DUE;
}
public class Task {
  private String taskTitle;
  private int taskId;
   private String description;
  Status status;
  private LocalDate start;
  private LocalDate end;
  private  static int taskCount=1;

  public Task(String title,String description){
    taskTitle=title;
    taskId=generateTaskId();
    this.description=description;
    start =LocalDate.now();
    this.end=start.plusDays(5);
    this.status=Status.PENDING;
  }
  private static int generateTaskId(){
    return taskCount++;
  }
  public String getTaskTitle(){
    return taskTitle;
  }
  public String getTaskDescription(){
    return description;
  }
  public LocalDate getStartDate(){
    return start;
  }
  public LocalDate getEndDate(){
    return end;
  }
  public int getTaskId(){
    return taskId;
  }
  public  void setTaskTitle(String title){
    taskTitle=title;
  }
  public  void setTaskdescription(String description){
    this.description=description;
  }

  

}
