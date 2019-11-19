import java.util.ArrayList;
public class LongtermTask extends Task{
	     private String deadline=new String();
	     private ArrayList<SmallTask> t;
         public LongtermTask() {
        	 super();
         }
	     public LongtermTask(String Name,String Note,String Deadline) {
        	 super(Name,Note);
        	 this.deadline=Deadline;
        	 t=new ArrayList<SmallTask>();
}
         public void setdeadline(String Deadline) {
        	 this.deadline=Deadline;
         }
         public String getdeadline() {
        	 return this.deadline;
         }
         public void addtask(SmallTask task) {
        	 t.add(task);
         }
         public void smalltasksortday() {     //按创建时间输出子任务
       	  int i=0;
       	  int j=0;
       	  int l=t.size();
       	  SmallTask a=new SmallTask();
       	  for(i=0;i<l;i++) {
       		  a=t.get(l);
       		  for(j=i;j>0&&t.get(j-1).getcreatday().compareTo(a.getcreatday())>0;j--) {
       			  t.set(j,t.get(j-1));
       			  t.set(j-1,a);
       		  }
       		  for(i=0;i<l;i++) {
       			  System.out.print(t.get(i).getname()+" "+t.get(i).getcompletion()+" "+t.get(i).getdeadline()+" ");
       			  System.out.print(t.get(i).getcreatday()+"\n");
       		  }
       	  }
         }
}
