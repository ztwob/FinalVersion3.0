public class TemporaryTask extends Task{
         private String deadline=new String();
         public TemporaryTask() {
        	 super();
         }
         public TemporaryTask(String Name,String Note,String Deadline) {
        	 super(Name,Note);
        	 this.deadline=Deadline;
         }
         public void setdeadline(String Deadline) {
        	 this.deadline=Deadline;
         }
         public String getdeadline() {
        	 return this.deadline;
         }
}
