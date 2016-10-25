//Room.java
//Is Room Object, keeps track of the room name, room description, room options.
class Room{
	public List options;
	private int num_options;
	private String description;
	private String tag;
	Room(){
		options=new List();
		num_options=0;
		description="";
		tag="";
	}
	public void insert_option(String txt){
		//12 letters max for options (a-l)
		if(num_options==12){ System.out.println("Error"); System.exit(0);} 
		//97=a in ascii, 98=b, etc
		options.insert((Character.toString((char)(97+num_options))+". ").concat(txt),this);
		num_options++;
	}
	public void addDescription(String txt){
		if(txt==null) return;
		else{
			description=description.concat("\n"+txt+"\n");
		}
	}
	public void addTag(String txt){
		if(tag.length()==0 || tag==null){
			//if theres no tag, then update it to txt
			tag=txt;
		}else{
			//otherwise do nothing
			return;
		}
	}
	public void printDescription(){
		System.out.println(this.description);
	}
	public String getTag(){
		return tag;
	}
	public void print_options(){
		System.out.println(description);
		System.out.println("******************************************");
		options.print();
		System.out.println("******************************************");
	}
	public Room findOption(char z){
		return(options.findOptionInfo(z));
	}
}