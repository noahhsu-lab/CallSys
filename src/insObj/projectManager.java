package insObj;

import java.util.ArrayList;
import java.util.Random;

import motherObj.CompanyMember;

public class projectManager extends CompanyMember {
	
	
	private ArrayList<technicalTL> mList; 
	
	public ArrayList<technicalTL> getmList() {
		return mList;
	}

//	public void setmList(ArrayList<technicalTL> mList) {
//		this.mList = mList;
//	}

	public void setMember(ArrayList<technicalTL> mList) {
		this.mList = mList;
	}
	
	public int holdinProcess(Job j) {
		// TODO Auto-generated method stub
		if(!this.isWorkingFlag()){
			if(WorkingDice.Dice(j.getCostSkill())) {
				//successFul
				//waiting for finished
				this.setWorkingFlag(true);
				this.workingProcess();
				return 0;
			}
		}
		//tranfer job to another one
		return 3;
	}

	@Override
	public void workingProcess() {
		// TODO Auto-generated method stub
		boolean flag = true;
		Random rand = new Random();
		int rand_int1 = rand.nextInt(10000000);
		int countTime = 0;
		while(flag) {
			countTime=countTime*3;
			if(countTime>=rand_int1) {
				flag = false;
			}
		}
		this.setWorkingFlag(false);
	}

}
