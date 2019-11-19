public class PeriodicTask extends Task{
	   private String date=new String();
	   private String cycle=new String();
	   private String times=new String();
       public PeriodicTask() {
    	   super();
       }
	   public PeriodicTask(String Name,String Note,String Date,String Cycle,String Times) {
    	   super(Name,Note);
    	   this.date=Date;
    	   this.cycle=Cycle;
    	   this.times=Times;
       }
       public void setdate(String Date) {
    	   this.date=Date;
       }
       public String getdate() {
    	   return this.date;
       }
       public void setcycle(String Cycle) {
    	   this.cycle=Cycle;
       }
       public String getcycle() {
    	   return this.cycle;
       }
       public void settimes(String Times) {
    	   this.times=Times;
       }
       public String gettimes() {
    	   return this.times;
       }
}
