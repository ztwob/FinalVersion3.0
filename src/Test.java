import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class Test {     
	public static void main(String [] args) throws IOException{
		       ArrayList<TaskList> tasklistarray=new ArrayList<TaskList>();
        	   File file=new File("11.txt");
        	   if(!file.exists()) file.createNewFile();
        	   BufferedReader in=new BufferedReader(new FileReader(file));
        	   ArrayList<String> list=new ArrayList<String>();
        	   String s=new String();
        	   while((s=in.readLine())!=null) list.add(s);
        	   in.close();
        	   int i;
        	   int j=0;
        	   int len=list.size();
        	   for(i=0;i<len;i++) {
        		   if((list.get(i).indexOf("<"))>-1) {                          //读取任务清单
        			   String[] s1=list.get(i).split(" |<");
        			   TaskList task=new TaskList();
        			   if(s1[0]!=null) task.setname(s1[0]);
                       if(s1[1]!=null) task.settype(s1[1]);
                       tasklistarray.add(task);
                       j++;
        		   }
        		   /*else if(list.get(i).indexOf("长期任务")>-1) {                      //读取长期任务
        			   System.out.println("23333");
        			   for(i=i+1;list.get(i).indexOf("临时任务")<0&&list.get(i)!=null;i++) {
        				   String[] s2=list.get(i).split(" ");
        				   LongtermTask longtask=new LongtermTask();
        				   if(s2[0]!=null) longtask.setname(s2[0]);
        				   if(s2[1]!=null) longtask.setcompletion(s2[1]);
        				   if(s2[2]!=null) longtask.setdeadline(s2[2]);
        				   if(s2[3]!=null) longtask.setnote(s2[3]);
        				   if(s2[4]!=null) longtask.setcreatday(s2[4]);
        				   tasklistarray.get(j-1).longtaskarray.add(longtask);
        				   System.out.println(tasklistarray.get(j-1).longtaskarray.get(0).getname());
        			   }
        		   }*/
        		   if(list.get(i).indexOf("临时任务")>-1) {                   //读取临时任务
        			   System.out.println("123");
        			   for(i=i+1;list.get(i).indexOf("周期任务")<0;i++) {
        				   String[] s2=list.get(i).split("临时任务| ");
        				   TemporaryTask temtask=new TemporaryTask();
        				   if(s2[0]!=null) temtask.setname(s2[0]);
        				   if(s2[1]!=null) temtask.setcompletion(s2[1]);
        				   if(s2[2]!=null) temtask.setdeadline(s2[2]);
        				   if(s2[3]!=null) temtask.setnote(s2[3]);
        				   if(s2[4]!=null) temtask.setcreatday(s2[4]);
        				   tasklistarray.get(j-1).temtaskarray.add(temtask);
        			   }
        		   }
        		    /*if(list.get(i).indexOf("周期任务")>-1) {                  //读取周期任务
        			   System.out.println("555");
        			   i=i+1;
        			   for(;list.get(i).indexOf(">")<0&&i<len;i++) {
        				   String[] s2=list.get(i).split("周期任务| ");
        				   PeriodicTask pertask=new PeriodicTask();
        				   if(s2[0]!=null) pertask.setname(s2[0]);
        				   //if(s2[1]!=null) pertask.setcompletion(s2[1]);
        				   //if(s2[2]!=null) pertask.setdate(s2[2]);
        				   //if(s2[3]!=null) pertask.setcycle(s2[3]);
        				   //if(s2[4]!=null) pertask.settimes(s2[4]);
        				   //if(s2[5]!=null) pertask.setnote(s2[5]);
        				   //if(s2[6]!=null) pertask.setcreatday(s2[6]);
        				   tasklistarray.get(j-1).pertaskarray.add(pertask);
        			   }
        		   }*/
        	   }
        	   Scanner scan=new Scanner(System.in);
        	   String thein=new String();
        	   for(;;) {
        		   System.out.println("输入1进行清单操作,输入2打印所有任务,输入3将任务输出到文件,输入q退出程序");
        		   thein=scan.nextLine();
        		   if(thein.equals("q")) {
        			   scan.close();
        			   break;
        		   }
        		   if(thein.equals("1")) {
        			   for(;;){
        			   System.out.println("输入1创建清单,输入2删除清单，输入3修改清单，输入4选择清单排序,输入5返回上一界面");
        			   thein=scan.nextLine();
        			   if(thein.equals("1")) {
        				   TaskList t=new TaskList();
        				   thein=scan.nextLine();
        				   t.setname(thein);
        				   thein=scan.nextLine();
        				   t.settype(thein);
        				   tasklistarray.add(t);
        			   }
        			   else if(thein.equals("2")) {
        				   for(;;) {
        				   System.out.println("输入想要删除的清单或者输入q结束删除操作");
        				   thein=scan.nextLine();
        				   if(thein.equals("q"))break;
        				   int f1=0;
        				   for(i=0;i<tasklistarray.size();i++) {
        					   if(tasklistarray.get(i).getname().equals(thein)) break;
        					   else if(i==(tasklistarray.size()-1)) {
        						   System.out.println("没有找到该清单");
        						   f1=1;
        						   break;
        					   }
        				   }
        				   if(f1==1);
        				   else {
        					   tasklistarray.remove(i);
        					   System.out.println("删除成功");
        				   }
        			   }
        			   }
        			   else if(thein.equals("3")) {
        				   for(;;) {
        				   System.out.println("输入想要修改的清单或者输入q返回上一界面");
        				   thein=scan.nextLine();
        				   if(thein.equals("q")) break;
        				   int f1=0;
        				   for(i=0;i<tasklistarray.size();i++) {
        					   if(tasklistarray.get(i).getname().equals(thein)) break;
        					   else if(i==(tasklistarray.size()-1)) {
        						   System.out.println("没有找到该清单");
        						   f1=1;
        						   break;
        					   }
        				   }
        				   if(f1==1);
        				   else {
        					   for(;;) {
        					   System.out.println("输入1修改清单名称与类型，输入2修改长期任务，输入3修改临时任务，输入4修改周期任务,输入q返回上一界面");
        					   thein=scan.nextLine();
        					   if(thein.equals("q"))break;
        					   if(thein.equals("1")) {
        					   System.out.println("输入清单名称和类型");
        					   thein=scan.nextLine();
        					   tasklistarray.get(i).setname(thein);
        					   thein=scan.nextLine();
        					   tasklistarray.get(i).settype(thein);
        					   }else if(thein.equals("2")) {                             //修改长期任务
        						   System.out.println("输入1创建新长期任务，输入2删除，输出3修改，输入4排序");
        						   thein=scan.nextLine();
        						   if(thein.equals("1")) {
        							   LongtermTask longtask=new LongtermTask();
        							   thein=scan.nextLine();
        							   longtask.setname(thein);
        							   thein=scan.nextLine();
        							   longtask.setcompletion(thein);
        							   thein=scan.nextLine();
        							   longtask.setdeadline(thein);
        							   thein=scan.nextLine();
        							   longtask.setnote(thein);
        							   tasklistarray.get(i).longtaskarray.add(longtask);
        						   }
        						   else if(thein.equals("2")) {
        							   System.out.println("输入想要删除的长期任务");
        							   thein=scan.nextLine();
        							   int lt=0;
        							   int fl=0;
        							   for(lt=0;lt<tasklistarray.get(i).longtaskarray.size();lt++)
        							   {
        								   if(tasklistarray.get(i).longtaskarray.get(lt).getname().equals(thein)) break;
        								   else if(lt==tasklistarray.get(i).longtaskarray.size()-1)
										   {fl=1;
        								   System.out.println("没有找到该任务");}
        							   }
        							   if(fl==1); 
        							   else {
        								   tasklistarray.get(i).longtaskarray.remove(lt);
        								   System.out.println("删除成功");
        							   }
        						   }
        						   else if(thein.equals("3")) {
        							   System.out.println("输入想要修改的长期任务");
        							   thein=scan.nextLine();
        							   int lt=0;
        							   int fl=0;
        							   for(lt=0;lt<tasklistarray.get(i).longtaskarray.size();lt++)
        							   {
        								   if(tasklistarray.get(i).longtaskarray.get(lt).getname().equals(thein)) break;
        								   else if(lt==tasklistarray.get(i).longtaskarray.size()-1) fl=1;
        							   }
        							   if(fl==1);
        							   else {
        								   thein=scan.nextLine();
        								   tasklistarray.get(i).longtaskarray.get(lt).setname(thein);
        								   thein=scan.nextLine();
        								   tasklistarray.get(i).longtaskarray.get(lt).setcompletion(thein);
        								   thein=scan.nextLine();
        								   tasklistarray.get(i).longtaskarray.get(lt).setdeadline(thein);
        								   thein=scan.nextLine();
        								   tasklistarray.get(i).longtaskarray.get(lt).setnote(thein);
        							   }
        						   }
        						   else if(thein.equals("4")) {
        							   System.out.println("输入1按名称排序，2按创建时间排序，3按完成情况排序");
        							   thein=scan.nextLine();
        							   if(thein.equals("1")) {
        							   LongtermTask a=new LongtermTask();
        							   int n=0;
        		        	         	  for(n=1;n<tasklistarray.get(i).longtaskarray.size();i++) {
        		        	         		  a=tasklistarray.get(i).longtaskarray.get(n);
        		        	         		  int h;
        		        	         		  for(h=n;h>0&&tasklistarray.get(i).longtaskarray.get(h-1).getname().compareTo(a.getname())<0;h--) {
        		        	         			tasklistarray.get(i).longtaskarray.set(h,tasklistarray.get(i).longtaskarray.get(h-1));
        		        	         			tasklistarray.get(i).longtaskarray.set(h-1,a);
        		        	         		  }
        							   }
        							   }
        							   else if(thein.equals("2")) {
        							   LongtermTask a=new LongtermTask();
        							   int n=0;
        		        	         	  for(n=1;n<tasklistarray.get(i).longtaskarray.size();i++) {
        		        	         		  a=tasklistarray.get(i).longtaskarray.get(n);
        		        	         		  int h;
        		        	         		  for(h=n;h>0&&tasklistarray.get(i).longtaskarray.get(h-1).getcompletion().compareTo(a.getcompletion())<0;h--) {
        		        	         			tasklistarray.get(i).longtaskarray.set(h,tasklistarray.get(i).longtaskarray.get(h-1));
        		        	         			tasklistarray.get(i).longtaskarray.set(h-1,a);
        		        	         		  }
        							   }
        							   }
        							   else if(thein.equals("3")) {
        							   LongtermTask a=new LongtermTask();
        							   int n=0;
        		        	         	  for(n=1;n<tasklistarray.get(i).longtaskarray.size();i++) {
        		        	         		  a=tasklistarray.get(i).longtaskarray.get(n);
        		        	         		  int h;
        		        	         		  for(h=n;h>0&&tasklistarray.get(i).longtaskarray.get(h-1).getcreatday().compareTo(a.getcreatday())<0;h--) {
        		        	         			tasklistarray.get(i).longtaskarray.set(h,tasklistarray.get(i).longtaskarray.get(h-1));
        		        	         			tasklistarray.get(i).longtaskarray.set(h-1,a);
        		        	         		  }
        							   }
        							   }
        						   }
        					   }
        					   else if(thein.equals("3")) {                        //修改临时任务
        						   System.out.println("输入1创建新临时任务，输入2删除，输出3修改，输入4排序");
        						   thein=scan.nextLine();
        						   if(thein.equals("1")) {
        							   TemporaryTask longtask=new TemporaryTask();
        							   thein=scan.nextLine();
        							   longtask.setname(thein);
        							   thein=scan.nextLine();
        							   longtask.setcompletion(thein);
        							   thein=scan.nextLine();
        							   longtask.setdeadline(thein);
        							   thein=scan.nextLine();
        							   longtask.setnote(thein);
        							   tasklistarray.get(i).temtaskarray.add(longtask);
        						   }
        						   else if(thein.equals("2")) {
									   System.out.println("输入想要删除的临时任务");
									   thein = scan.nextLine();
									   int lt = 0;
									   int fl = 0;
									   for (lt = 0; lt < tasklistarray.get(i).temtaskarray.size(); lt++) {
										   if (tasklistarray.get(i).temtaskarray.get(lt).getname().equals(thein)) break;
										   else if (lt == tasklistarray.get(i).temtaskarray.size() - 1) {
											   fl = 1;
											   System.out.println("没有找到该任务");
										   }
										   if (fl == 1) ;
										   else {
											   tasklistarray.get(i).temtaskarray.remove(lt);
											   System.out.println("删除成功");
										   }
									   }
								   }
        						   else if(thein.equals("3")) {
        							   System.out.println("输入想要修改的临时任务");
        							   thein=scan.nextLine();
        							   int tt=0;
        							   int tl=0;
        							   for(tt=0;tt<tasklistarray.get(i).temtaskarray.size();tt++)
        							   {
        								   if(tasklistarray.get(i).temtaskarray.get(tt).getname().equals(thein)) break;
        								   else if(tt==tasklistarray.get(i).temtaskarray.size()-1) tl=1;
        							   }
        							   if(tl==1);
        							   else {
        								   thein=scan.nextLine();
        								   tasklistarray.get(i).temtaskarray.get(tt).setname(thein);
        								   thein=scan.nextLine();
        								   tasklistarray.get(i).temtaskarray.get(tt).setcompletion(thein);
        								   thein=scan.nextLine();
        								   tasklistarray.get(i).temtaskarray.get(tt).setdeadline(thein);
        								   thein=scan.nextLine();
        								   tasklistarray.get(i).temtaskarray.get(tt).setnote(thein);
        							   }
        						   }
        						   else if(thein.equals("4")) {
        							   System.out.println("输入1按名称排序，2按创建时间排序，3按完成情况排序");
        							   thein=scan.nextLine();
        							   if(thein.equals("1")) {
        							   TemporaryTask a=new TemporaryTask();
        							   int n=0;
        		        	         	  for(n=1;n<tasklistarray.get(i).temtaskarray.size();i++) {
        		        	         		  a=tasklistarray.get(i).temtaskarray.get(n);
        		        	         		  int h;
        		        	         		  for(h=n;h>0&&tasklistarray.get(i).temtaskarray.get(h-1).getname().compareTo(a.getname())<0;h--) {
        		        	         			tasklistarray.get(i).temtaskarray.set(h,tasklistarray.get(i).temtaskarray.get(h-1));
        		        	         			tasklistarray.get(i).temtaskarray.set(h-1,a);
        		        	         		  }
        							   }
        							   }
        							   else if(thein.equals("2")) {
        							   TemporaryTask a=new TemporaryTask();
        							   int n=0;
        		        	         	  for(n=1;n<tasklistarray.get(i).temtaskarray.size();i++) {
        		        	         		  a=tasklistarray.get(i).temtaskarray.get(n);
        		        	         		  int h;
        		        	         		  for(h=n;h>0&&tasklistarray.get(i).temtaskarray.get(h-1).getcompletion().compareTo(a.getcompletion())<0;h--) {
        		        	         			tasklistarray.get(i).temtaskarray.set(h,tasklistarray.get(i).temtaskarray.get(h-1));
        		        	         			tasklistarray.get(i).temtaskarray.set(h-1,a);
        		        	         		  }
        							   }
        							   }
        							   else if(thein.equals("3")) {
        							   TemporaryTask a=new TemporaryTask();
        							   int n=0;
        		        	         	  for(n=1;n<tasklistarray.get(i).temtaskarray.size();i++) {
        		        	         		  a=tasklistarray.get(i).temtaskarray.get(n);
        		        	         		  int h;
        		        	         		  for(h=n;h>0&&tasklistarray.get(i).temtaskarray.get(h-1).getcreatday().compareTo(a.getcreatday())<0;h--) {
        		        	         			tasklistarray.get(i).temtaskarray.set(h,tasklistarray.get(i).temtaskarray.get(h-1));
        		        	         			tasklistarray.get(i).temtaskarray.set(h-1,a);
        		        	         		  }
        							   }
        							   }
        						   }
        					   }else if(thein.equals("4")) {                     //修改周期任务
        						   System.out.println("输入1创建新周期任务，输入2删除，输出3修改，输入4排序");
        						   thein=scan.nextLine();
        						   if(thein.equals("1")) {
        							   PeriodicTask longtask=new PeriodicTask();
        							   thein=scan.nextLine();
        							   longtask.setname(thein);
        							   thein=scan.nextLine();
        							   longtask.setcompletion(thein);
        							   thein=scan.nextLine();
        							   longtask.setdate(thein);
        							   thein=scan.nextLine();
        							   longtask.setcycle(thein);
        							   thein=scan.nextLine();
        							   longtask.settimes(thein);
        							   thein=scan.nextLine();
        							   longtask.setnote(thein);
        							   tasklistarray.get(i).pertaskarray.add(longtask);
        						   }
        						   else if(thein.equals("2")) {
        							   System.out.println("输入想要删除的周期任务");
        							   thein=scan.nextLine();
        							   int lt=0;
        							   int fl=0;
        							   for(lt=0;lt<tasklistarray.get(i).pertaskarray.size();lt++)
        							   {
        								   if(tasklistarray.get(i).pertaskarray.get(lt).getname().equals(thein)) break;
        								   else if(lt==tasklistarray.get(i).pertaskarray.size()-1)
        								   {fl=1;
											   System.out.println("没有找到该任务");}
        							   }
        							   if(fl==1); 
        							   else {
        								   tasklistarray.get(i).pertaskarray.remove(lt);
        								   System.out.println("删除成功");
        							   }
        						   }
        						   else if(thein.equals("3")) {
        							   System.out.println("输入想要修改的周期任务");
        							   thein=scan.nextLine();
        							   int tt=0;
        							   int tl=0;
        							   for(tt=0;tt<tasklistarray.get(i).pertaskarray.size();tt++)
        							   {
        								   if(tasklistarray.get(i).pertaskarray.get(tt).getname().equals(thein)) break;
        								   else if(tt==tasklistarray.get(i).pertaskarray.size()-1) {tl=1;
											   System.out.println("没有找到该任务");}
        							   }
        							   if(tl==1);
        							   else {
        								   thein=scan.nextLine();
        								   tasklistarray.get(i).pertaskarray.get(tt).setname(thein);
        								   thein=scan.nextLine();
        								   tasklistarray.get(i).pertaskarray.get(tt).setcompletion(thein);
        								   thein=scan.nextLine();
        								   tasklistarray.get(i).pertaskarray.get(tt).setdate(thein);
        								   thein=scan.nextLine();
        								   tasklistarray.get(i).pertaskarray.get(tt).setcycle(thein);
        								   thein=scan.nextLine();
        								   tasklistarray.get(i).pertaskarray.get(tt).settimes(thein);
        								   thein=scan.nextLine();
        								   tasklistarray.get(i).pertaskarray.get(tt).setnote(thein);
        							   }
        						   }
        						   else if(thein.equals("4")) {
        							   System.out.println("输入1按名称排序，2按创建时间排序，3按完成情况排序");
        							   thein=scan.nextLine();
        							   if(thein.equals("1")) {
        							   PeriodicTask a=new PeriodicTask();
        							   int n=0;
        		        	         	  for(n=1;n<tasklistarray.get(i).pertaskarray.size();i++) {
        		        	         		  a=tasklistarray.get(i).pertaskarray.get(n);
        		        	         		  int h;
        		        	         		  for(h=n;h>0&&tasklistarray.get(i).pertaskarray.get(h-1).getname().compareTo(a.getname())<0;h--) {
        		        	         			tasklistarray.get(i).pertaskarray.set(h,tasklistarray.get(i).pertaskarray.get(h-1));
        		        	         			tasklistarray.get(i).pertaskarray.set(h-1,a);
        		        	         		  }
        							   }
        							   }
        							   else if(thein.equals("2")) {
        							   PeriodicTask a=new PeriodicTask();
        							   int n=0;
        		        	         	  for(n=1;n<tasklistarray.get(i).pertaskarray.size();i++) {
        		        	         		  a=tasklistarray.get(i).pertaskarray.get(n);
        		        	         		  int h;
        		        	         		  for(h=n;h>0&&tasklistarray.get(i).pertaskarray.get(h-1).getcompletion().compareTo(a.getcompletion())<0;h--) {
        		        	         			tasklistarray.get(i).pertaskarray.set(h,tasklistarray.get(i).pertaskarray.get(h-1));
        		        	         			tasklistarray.get(i).pertaskarray.set(h-1,a);
        		        	         		  }
        							   }
        							   }
        							   else if(thein.equals("3")) {
        							   PeriodicTask a=new PeriodicTask();
        							   int n=0;
        		        	         	  for(n=1;n<tasklistarray.get(i).pertaskarray.size();i++) {
        		        	         		  a=tasklistarray.get(i).pertaskarray.get(n);
        		        	         		  int h;
        		        	         		  for(h=n;h>0&&tasklistarray.get(i).pertaskarray.get(h-1).getcreatday().compareTo(a.getcreatday())<0;h--) {
        		        	         			tasklistarray.get(i).pertaskarray.set(h,tasklistarray.get(i).pertaskarray.get(h-1));
        		        	         			tasklistarray.get(i).pertaskarray.set(h-1,a);
        		        	         		  }
        							   }
        							   }
        						   }
        					   }
        					   }
        				   }
        			   }
        			   }
        			   else if(thein.equals("4")) {                            //清单排序
        				   System.out.println("输入1按名称排序输入2按类型排序");
        				   thein=scan.nextLine();
        				   if(thein.equals("1")) {
        					   for(i=1;i<tasklistarray.size();i++) {             //按名称进行清单排序
        						   TaskList t1=new TaskList();
        						   t1=tasklistarray.get(i);
        						   for(j=i;j>0&&(tasklistarray.get(j-1).getname().compareTo(t1.getname()))>0;j--) {
        							   tasklistarray.set(j,tasklistarray.get(j-1));
        							   tasklistarray.set(j-1,t1);
        						   }
        					   }
        				   }
        				   else if(thein.equals("2")) {                         //按类型进行清单排序
        					   for(i=1;i<tasklistarray.size();i++) {
        						   TaskList t1=new TaskList();
        						   t1=tasklistarray.get(i);
        						   for(j=i;j>0&&(tasklistarray.get(j-1).gettype().compareTo(t1.gettype()))>0;j--) {
        							   tasklistarray.set(j,tasklistarray.get(j-1));
        							   tasklistarray.set(j-1,t1);
        						   }
        					   }
        				   }
        			   }
        			   else if(thein.equals("5")) break;
        		   }
        	   }else if(thein.equals("2")) {
        			   for(j=0;j<tasklistarray.size();j++) {                       //输出任务清单及任务
        	        	   System.out.println(tasklistarray.get(j).getname()+" "+tasklistarray.get(j).gettype()+"<");
        	        	   TemporaryTask a=new TemporaryTask();
        	         	  for(i=1;i<tasklistarray.get(j).temtaskarray.size();i++) {
        	         		  a=tasklistarray.get(j).temtaskarray.get(i);
        	         		  int h;
        	         		  for(h=i;h>0&&tasklistarray.get(j).temtaskarray.get(h-1).getcompletion().compareTo(a.getcompletion())<0;h--) {
        	         			tasklistarray.get(j).temtaskarray.set(h,tasklistarray.get(j).temtaskarray.get(h-1));
        	         			tasklistarray.get(j).temtaskarray.set(h-1,a);
        	         		  }
        	         	  }
        	         	 System.out.println("长期任务:");
        	      	      for(i=0;i<tasklistarray.get(j).longtaskarray.size();i++) {
        	    			  System.out.print(tasklistarray.get(j).longtaskarray.get(i).getname()+" "+tasklistarray.get(j).longtaskarray.get(i).getcompletion()+" ");
        	    			  System.out.print(tasklistarray.get(j).longtaskarray.get(i).getdeadline()+" "+tasklistarray.get(j).longtaskarray.get(i).getnote()+" ");
        	    			  System.out.println(tasklistarray.get(j).longtaskarray.get(i).getcreatday());
        	    		  }
        	         	  System.out.println("临时任务:");
        	        	   for(i=0;i<tasklistarray.get(j).temtaskarray.size();i++) {
        	      			  System.out.print(tasklistarray.get(j).temtaskarray.get(i).getname()+" "+tasklistarray.get(j).temtaskarray.get(i).getcompletion()+" ");
        	      			  System.out.print(tasklistarray.get(j).temtaskarray.get(i).getdeadline()+" "+tasklistarray.get(j).temtaskarray.get(i).getnote()+" ");
        	      			  System.out.println(tasklistarray.get(j).temtaskarray.get(i).getcreatday());
        	      		  }
        	        	   System.out.println("周期任务:");
        	        	   for(i=0;i<tasklistarray.get(j).pertaskarray.size();i++) {
        	      			  System.out.print(tasklistarray.get(j).pertaskarray.get(i).getname()+" "+tasklistarray.get(j).pertaskarray.get(i).getcompletion()+" ");
        	      			  System.out.print(tasklistarray.get(j).pertaskarray.get(i).getdate()+" "+tasklistarray.get(j).pertaskarray.get(i).getcycle()+" ");
        	      			  System.out.print(tasklistarray.get(j).pertaskarray.get(i).gettimes()+" "+tasklistarray.get(j).pertaskarray.get(i).getnote()+" ");
        	      			  System.out.println(tasklistarray.get(j).pertaskarray.get(i).getcreatday());
        	      		  }
        	        	   System.out.println(">");
        	        	   }
        		   }else if(thein.equals("3")) {
        			   BufferedWriter out=new BufferedWriter(new FileWriter(file));
        			   for(j=0;j<tasklistarray.size();j++) {                       //输出任务清单及任务到文件
        	        	   out.write(tasklistarray.get(j).getname()+" "+tasklistarray.get(j).gettype()+"<\r\n");
        	        	   /*TemporaryTask a=new TemporaryTask();
        	         	  for(i=1;i<tasklistarray.get(j).temtaskarray.size();i++) {
        	         		  a=tasklistarray.get(j).temtaskarray.get(i);
        	         		  int h;
        	         		  for(h=i;h>0&&tasklistarray.get(j).temtaskarray.get(h-1).getcompletion().compareTo(a.getcompletion())<0;h--) {
        	         			tasklistarray.get(j).temtaskarray.set(h,tasklistarray.get(j).temtaskarray.get(h-1));
        	         			tasklistarray.get(j).temtaskarray.set(h-1,a);
        	         		  }
        	         	  }*/
        	         	 out.write("长期任务:\r\n");
        	      	      for(i=0;i<tasklistarray.get(j).longtaskarray.size();i++) {
        	      	    	out.write(tasklistarray.get(j).longtaskarray.get(i).getname()+" "+tasklistarray.get(j).longtaskarray.get(i).getcompletion()+" ");
        	      	    	out.write(tasklistarray.get(j).longtaskarray.get(i).getdeadline()+" "+tasklistarray.get(j).longtaskarray.get(i).getnote()+" ");
        	      	    	out.write(tasklistarray.get(j).longtaskarray.get(i).getcreatday()+"\r\n");
        	    		  }
        	      	    out.write("临时任务:\r\n");
        	        	   for(i=0;i<tasklistarray.get(j).temtaskarray.size();i++) {
        	        		   out.write(tasklistarray.get(j).temtaskarray.get(i).getname()+" "+tasklistarray.get(j).temtaskarray.get(i).getcompletion()+" ");
        	        		   out.write(tasklistarray.get(j).temtaskarray.get(i).getdeadline()+" "+tasklistarray.get(j).temtaskarray.get(i).getnote()+" ");
        	        		   out.write(tasklistarray.get(j).temtaskarray.get(i).getcreatday()+"\r\n");
        	      		  }
        	        	   out.write("周期任务:");
        	        	   for(i=0;i<tasklistarray.get(j).pertaskarray.size();i++) {
        	        		   out.write(tasklistarray.get(j).pertaskarray.get(i).getname()+" "+tasklistarray.get(j).pertaskarray.get(i).getcompletion()+" ");
        	        		   out.write(tasklistarray.get(j).pertaskarray.get(i).getdate()+" "+tasklistarray.get(j).pertaskarray.get(i).getcycle()+" ");
        	        		   out.write(tasklistarray.get(j).pertaskarray.get(i).gettimes()+" "+tasklistarray.get(j).pertaskarray.get(i).getnote()+" ");
        	        		   out.write(tasklistarray.get(j).pertaskarray.get(i).getcreatday()+"\r\n");
        	      		  }
        	        	   if(i==0) out.write("\r\n");
        	        	   out.write(">\r\n");
        		   }
        			   out.close();
        	   }
        	   /*for(j=0;j<tasklistarray.size();j++) {                       //输出任务清单及任务
        	   System.out.println(tasklistarray.get(j).getname()+" "+tasklistarray.get(j).gettype()+"<");
        	   TemporaryTask a=new TemporaryTask();
         	  for(i=1;i<tasklistarray.get(j).temtaskarray.size();i++) {
         		  a=tasklistarray.get(j).temtaskarray.get(i);
         		  int h;
         		  for(h=i;h>0&&tasklistarray.get(j).temtaskarray.get(h-1).getcompletion().compareTo(a.getcompletion())<0;h--) {
         			tasklistarray.get(j).temtaskarray.set(h,tasklistarray.get(j).temtaskarray.get(h-1));
         			tasklistarray.get(j).temtaskarray.set(h-1,a);
         		  }
         	  }
         	 System.out.println("长期任务:");
      	      for(i=0;i<tasklistarray.get(j).longtaskarray.size();i++) {
    			  System.out.print(tasklistarray.get(j).longtaskarray.get(i).getname()+" "+tasklistarray.get(j).longtaskarray.get(i).getcompletion()+" ");
    			  System.out.print(tasklistarray.get(j).longtaskarray.get(i).getdeadline()+" "+tasklistarray.get(j).longtaskarray.get(i).getnote()+" ");
    			  System.out.println(tasklistarray.get(j).longtaskarray.get(i).getcreatday());
    		  }
         	  System.out.println("临时任务:");
        	   for(i=0;i<tasklistarray.get(j).temtaskarray.size();i++) {
      			  System.out.print(tasklistarray.get(j).temtaskarray.get(i).getname()+" "+tasklistarray.get(j).temtaskarray.get(i).getcompletion()+" ");
      			  System.out.print(tasklistarray.get(j).temtaskarray.get(i).getdeadline()+" "+tasklistarray.get(j).temtaskarray.get(i).getnote()+" ");
      			  System.out.println(tasklistarray.get(j).temtaskarray.get(i).getcreatday());
      		  }
        	   System.out.println("周期任务:");
        	   for(i=0;i<tasklistarray.get(j).pertaskarray.size();i++) {
      			  System.out.print(tasklistarray.get(j).pertaskarray.get(i).getname()+" "+tasklistarray.get(j).pertaskarray.get(i).getcompletion()+" ");
      			  System.out.print(tasklistarray.get(j).pertaskarray.get(i).getdate()+" "+tasklistarray.get(j).pertaskarray.get(i).getcycle()+" ");
      			  System.out.print(tasklistarray.get(j).pertaskarray.get(i).gettimes()+" "+tasklistarray.get(j).pertaskarray.get(i).getnote()+" ");
      			  System.out.println(tasklistarray.get(j).pertaskarray.get(i).getcreatday());
      		  }
        	   System.out.println(">");
        	   }*/
           }
}
}
