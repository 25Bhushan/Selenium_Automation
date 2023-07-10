package javaprogramfile;

class Institute {
	
	private int studId;
	private String studName;
	private long studMobile;
	
	public void setStudInfo(int studId, String studName, long studMobile)
	{
		this.studId=studId;
		this.studName=studName;
		this.studMobile=studMobile;
	}
	
	public void getStudInfo()
	{
		System.out.println(studId);
		System.out.println(studName);
		System.out.println(studMobile);
	}
}

class Enquiry
{
	public static void main(String[] args) {
		Institute stud1=new Institute();
		stud1.setStudInfo(101, "rahul", 12345);
		stud1.getStudInfo();
	}
}
