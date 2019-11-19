import java.util.Calendar;
public class Task {
          private String name=new String();
          private String completion="not";
          private String note=new String();
          private String creatday=new String();
          private Calendar c=Calendar.getInstance();
          public Task() {
        	  this.creatday=String.valueOf(c.get(Calendar.YEAR))+String.valueOf(c.get(Calendar.MONTH))+String.valueOf(c.get(Calendar.DATE));
          }
          public  Task(String Name,String Note) {
        	  this.name=Name;
        	  this.note=Note;
        	  this.creatday=String.valueOf(c.get(Calendar.YEAR))+String.valueOf(c.get(Calendar.MONTH))+String.valueOf(c.get(Calendar.DATE));
          }
          public void setname(String Name) {
        	  this.name=Name;
          }
          public String getname() {
        	  return this.name;
          }
          public void setcompletion(String Completion) {
        	  this.completion=Completion;
          }
          public String getcompletion() {
        	  return this.completion;
          }
          public void setnote(String Note) {
        	  this.note=Note;
          }
          public String getnote() {
        	  return this.note;
          }
          public void setcreatday(String Creatday) {
        	  this.creatday=Creatday;
          }
          public String getcreatday() {
        	  return this.creatday;
          }
}
