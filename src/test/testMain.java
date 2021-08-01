package test;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import insObj.Job;
import insObj.employee;
import insObj.projectManager;
import insObj.technicalTL;
public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//init
		employee emp1 = new employee();
		emp1.setName("Tim");
		emp1.setPosition("New");
		emp1.setWorkingFlag(false);
		employee emp2 = new employee();
		emp2.setName("Alice");
		emp2.setPosition("New");
		emp2.setWorkingFlag(false);
		
		technicalTL tl = new technicalTL();
		tl.setName("Adam");
		tl.setPosition("TL");
		ArrayList<employee> mList = new ArrayList<employee>();
		mList.add(emp1);
		mList.add(emp2);
		tl.setMember(mList);
		
		projectManager pm = new projectManager();
		pm.setName("Alice");
		pm.setPosition("PM");
		ArrayList<technicalTL> tList = new ArrayList<technicalTL>();
		tList.add(tl);
		pm.setMember(tList);
		ArrayList<projectManager> pList = new ArrayList<projectManager>();
		pList.add(pm);
		//job
		Job job1 = new Job();
		job1.setCostSkill(10);
		Job job2 = new Job();
		job2.setCostSkill(80);
		Job job3 = new Job();
		job3.setCostSkill(50);
		Job job4 = new Job();
		job4.setCostSkill(40);
		Job job5 = new Job();
		job5.setCostSkill(60);
		Job job6 = new Job();
		job6.setCostSkill(30);
		ArrayList<Job> jList = new ArrayList<Job>();
		
		jList.add(job1);
		jList.add(job2);
		jList.add(job3);
		jList.add(job4);
		jList.add(job5);
		jList.add(job6);
		
		Executor executor = Executors.newFixedThreadPool(4);
		
		
		//Give Job to call center for allocate job
		for(int i=0; i<jList.size() ;i++) {
			executor.execute(new Work(i,pList,jList.get(i)));
		}
		
		
		
		
		
	}
	
	public static class Work implements Runnable {
		private int id;
		private ArrayList<projectManager> mList;
		private Job job;
		private int result;
		private boolean flag = false;
		public Work(int id,ArrayList<projectManager> mList,Job job) {
			this.id = id;
			this.mList = mList;
			this.job = job;
		}

		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<mList.size();i++) {
				projectManager pm = mList.get(i);
				//belong TL
				for(int j=0;j<pm.getmList().size();j++) {
					technicalTL tl = pm.getmList().get(j);
					//belong New emp
					for(int k=0; k<tl.getmList().size(); k++) {
						employee emp = tl.getmList().get(k);
						result = emp.holdinProcess(job);
							
						if(result==1) {
							//give another one
							continue;
						}else {
							//result == 0
							//emp finish job
							flag = true;
							break;
						}
					}
					
					//all emp can't do job or all emp have task
					if(!flag) {
						result = tl.holdinProcess(job);
						if(result==2) {
							//give another one
							continue;
						}else {
							//result == 0
							//emp finish job
							flag = true;
							break;
						}
					}else if(flag) {
						break;
					}
				}
				
				//all tl can't do job or all emp have task
				if(!flag) {
					result = pm.holdinProcess(job);
					if(result==3) {
						//give another one
						continue;
					}else {
						//result == 0
						//emp finish job
						flag = true;
						break;
					}
				}else if(flag) {
					break;
				}
				
				if(!flag&&i==mList.size()-1) {
					System.out.println("All the team can't finish this job");
				}
			}
		}
	}

}
