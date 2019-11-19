import java.util.ArrayList;
import java.util.Calendar;
public class SmallTask {
	     private String name=new String();
	     private String deadline=new String();
	     private String creatday=new String();
	     private String completion="not";
         private Calendar c=Calendar.getInstance();
         private ArrayList<SmallTask> taskarray;
         public SmallTask() {
        	 taskarray=new ArrayList<SmallTask>();
        	 this.creatday=String.valueOf(c.get(Calendar.YEAR))+String.valueOf(c.get(Calendar.MONTH))+String.valueOf(c.get(Calendar.DATE));
         }
         public SmallTask(String Name,String Deadline){
        	 this.name=Name;
        	 this.deadline=Deadline;
        	 this.taskarray=new ArrayList<SmallTask>();
        	 this.creatday=String.valueOf(c.get(Calendar.YEAR))+String.valueOf(c.get(Calendar.MONTH))+String.valueOf(c.get(Calendar.DATE));
         }
         public void setname(String Name) {
        	 this.name=Name;
         }
         public String getname() {
        	 return this.name;
         }
         public void setdeadline(String Deadline) {
        	 this.deadline=Deadline;
         }
         public String getdeadline() {
        	 return this.deadline;
         }
         public void addtask(SmallTask task) {
        	 taskarray.add(task);
         }
         public String getcreatday() {
       	  return this.creatday;
         }
         public void setcompletion(String Completion) {
       	  this.completion=Completion;
         }
         public String getcompletion() {
       	  return this.completion;
         }
}
