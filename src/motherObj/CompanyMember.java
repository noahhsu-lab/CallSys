package motherObj;

public abstract class CompanyMember {
	private String name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private boolean workingFlag = false;
	private String position = "";

	public boolean isWorkingFlag() {
		return workingFlag;
	}

	public void setWorkingFlag(boolean workingFlag) {
		this.workingFlag = workingFlag;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public abstract void  workingProcess();
	
}
