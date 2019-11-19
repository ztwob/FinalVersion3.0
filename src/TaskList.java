import java.util.ArrayList;
public class TaskList {
      private String name=new String();
      private String type=new String();
      private String creatday=new String();
      public ArrayList<TemporaryTask> temtaskarray;
      public ArrayList<PeriodicTask> pertaskarray;
      public ArrayList<LongtermTask> longtaskarray;
      public TaskList() {
    	  temtaskarray=new ArrayList<TemporaryTask>();
    	  pertaskarray=new ArrayList<PeriodicTask>();
    	  longtaskarray=new ArrayList<LongtermTask>();
      }
      public TaskList(String Name,String Type,String Creatday) {
    	  this.name=Name;
    	  this.type=Type;
    	  this.creatday=Creatday;
    	  temtaskarray=new ArrayList<TemporaryTask>();
    	  pertaskarray=new ArrayList<PeriodicTask>();
    	  longtaskarray=new ArrayList<LongtermTask>();
      }
      public void setname(String Name) {
    	  this.name=Name;
      }
      public String getname() {
    	  return this.name;
      }
      public void settype(String Type) {
    	  this.type=Type;
      }
      public String gettype() {
    	  return this.type;
      }
      public void addtemtaskarray(TemporaryTask task) {
    	  temtaskarray.add(task);
      }
      public void addpertaskarray(PeriodicTask task) {
    	  pertaskarray.add(task);
      }
      public void addlongtaskarray(LongtermTask task) {
    	  longtaskarray.add(task);
      }
      public void setcreatday(String Creatday) {
    	  this.creatday=Creatday;
      }
      public String getcreatday() {
    	  return this.creatday;
      }
      public static void temtasksortday(ArrayList<TemporaryTask> t) {     //按创建时间排序临时任务
    	  int i=0;
    	  int j=0;
    	  int l=t.size();
    	  for(i=1;i<l-1;i++) {
    		  TemporaryTask a=new TemporaryTask();
    		  a=t.get(l);
    		  for(j=i;j>0&&t.get(j-1).getcreatday().compareTo(a.getcreatday())>0;j--) {
    			 t.set(j,t.get(j-1));
    			 t.set(j-1,a);
    		  }
    	  }
      }
      public static void pertasksortday(ArrayList<PeriodicTask> t) {     //按创建时间排序周期任务
    	  int i=0;
    	  int j=0;
    	  int l=t.size();
    	  for(i=1;i<l-1;i++) {
    		  PeriodicTask a=new PeriodicTask();
    		  a=t.get(l);
    		  for(j=i;j>0&&t.get(j-1).getcreatday().compareTo(a.getcreatday())>0;j--) {
    			  t.set(j,t.get(j-1));
    			  t.set(j-1,a);
    		  }
    	  }
      }
      public static void longtasksortday(ArrayList<LongtermTask> t) {     //按创建时间排序长期任务
    	  int i=0;
    	  int j=0;
    	  int l=t.size();
    	  for(i=1;i<l;i++) {
    		  LongtermTask a=new LongtermTask();
    		  a=t.get(l);
    		  for(j=i;j>0&&t.get(j-1).getcreatday().compareTo(a.getcreatday())>0;j--) {
    			  t.set(j,t.get(j-1));
    			  t.set(j-1,a);
    		  }
    	  }
      }
      public static void temtasksortf(ArrayList<TemporaryTask> t) {         //按是否完成排序临时任务
    	  int i=0;
    	  int j=0;
    	  int l=t.size();
    	  for(i=1;i<l-1;i++) {
    		  TemporaryTask a=new TemporaryTask();
    		  a=t.get(i);
    		  for(j=i;j>0&&t.get(j-1).getcompletion().compareTo(a.getcompletion())>0;j--) {
    			  t.set(j,t.get(j-1));
    			  t.set(j-1,a);
    		  }
    	  }
      }
      public static void pertasksortf(ArrayList<PeriodicTask> t) {     //按是否完成排序周期任务
    	  int i=0;
    	  int j=0;
    	  int l=t.size();
    	  for(i=1;i<l-1;i++) {
    		  PeriodicTask a=new PeriodicTask();
    		  a=t.get(l);
    		  for(j=i;j>0&&t.get(j-1).getcompletion().compareTo(a.getcompletion())>0;j--) {
    			  t.set(j,t.get(j-1));
    			  t.set(j-1,a);
    		  }
    	  }
      }
      public static void longtasksortf(ArrayList<LongtermTask> t) {     //按是否完成排序长期任务
    	  int i=0;
    	  int j=0;
    	  int l=t.size();
    	  for(i=1;i<l;i++) {
    		  LongtermTask a=new LongtermTask();
    		  a=t.get(l);
    		  for(j=i;j>0&&t.get(j-1).getcompletion().compareTo(a.getcompletion())>0;j--) {
    			  t.set(j,t.get(j-1));
    			  t.set(j-1,a);
    		  }
    	  }
      }
      public static void temtasksortname(ArrayList<TemporaryTask> t) {         //按名称排序临时任务
    	  int i=0;
    	  int j=0;
    	  int l=t.size();
    	  for(i=1;i<l-1;i++) {
    		  TemporaryTask a=new TemporaryTask();
    		  a=t.get(i);
    		  for(j=i;j>0&&t.get(j-1).getname().compareTo(a.getname())>0;j--) {
    			  t.set(j,t.get(j-1));
    			  t.set(j-1,a);
    		  }
    	  }
      }
      public static void pertasksortname(ArrayList<PeriodicTask> t) {     //按名称排序周期任务
    	  int i=0;
    	  int j=0;
    	  int l=t.size();
    	  for(i=1;i<l-1;i++) {
    		  PeriodicTask a=new PeriodicTask();
    		  a=t.get(l);
    		  for(j=i;j>0&&t.get(j-1).getname().compareTo(a.getname())>0;j--) {
    			  t.set(j,t.get(j-1));
    			  t.set(j-1,a);
    		  }
    	  }
      }
      public static void longtasksortname(ArrayList<LongtermTask> t) {     //按名称排序长期任务
    	  int i=0;
    	  int j=0;
    	  int l=t.size();
    	  for(i=1;i<l;i++) {
    		  LongtermTask a=new LongtermTask();
    		  a=t.get(l);
    		  for(j=i;j>0&&t.get(j-1).getname().compareTo(a.getname())>0;j--) {
    			  t.set(j,t.get(j-1));
    			  t.set(j-1,a);
    		  }
    	  }
      }
      public  void addtemtask(TemporaryTask temtask) {
    	  temtaskarray.add(temtask);
      }
      public void addlongtask(LongtermTask longtask) {
    	  longtaskarray.add(longtask);
      }
      public void addpertask(PeriodicTask pertask) {
    	  pertaskarray.add(pertask);
      }
}
