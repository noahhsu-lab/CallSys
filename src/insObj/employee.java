package insObj;

import java.util.Random;

import motherObj.CompanyMember;

public class employee extends CompanyMember {

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
		return 1;
	}

	@Override
	public void workingProcess() {
		// TODO Auto-generated method stub
		boolean flag = true;
		Random rand = new Random();
		int rand_int1 = rand.nextInt(1000000);
		int countTime = 0;
		while(flag) {
			countTime++;
			if(countTime>=rand_int1) {
				flag = false;
			}
		}
		this.setWorkingFlag(false);
	}

}
