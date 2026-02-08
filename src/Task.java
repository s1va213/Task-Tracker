package src;
// import java.util.*;
import java.time.*;
enum Status{
  COMPLETED,PENDING,DUE;
}
public class Task {
  String taskTitle;
  int taskId;
  String description;
  Status status;
  LocalDate start;
  LocalDate end;
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

  

}
