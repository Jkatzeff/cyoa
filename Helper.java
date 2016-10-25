//Helper.java
//Simple class used to hold 2 return values (because functions can only return 1 value otherwise)
class Helper{
	public LList lst;
	public Room rm;
	Helper(Room rm, LList lst){
		this.lst=lst;
		this.rm=rm;
	}
}