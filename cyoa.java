//cyoa.java
//main class for the choose your own adventure app
import java.io.IOException;
import java.util.Scanner;
class cyoa{
	public static Helper makeGame(String[] args){
		String file_name="";
		try{
			if(args[0].length()<9){System.out.println("Not a valid .adventure file"); System.exit(0);}
			
			if(args[0].substring((args[0].length())-10,args[0].length()).equals(".adventure")){
				file_name = args[0];
			}
			else{
				System.out.println("Not a .adventure file");
				System.exit(0);
			}
		}
		catch(Exception e){
			System.out.println("Please enter a file as an argument.");
			System.exit(0);
		}
		String[] lines=null;
		try{
			ReadFile file = new ReadFile(file_name);
			//lines is an array of Strings...ie lines[0]=first line in the text file, etc
			lines = file.OpenFile();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		LList lst = new LList();
		int numrms=0;
		//curr_room_file is the room that the lines array is currently on
		Room curr_room_file= new Room();
		//current_room will just be the first room added, so the player starts in that room
		Room current_room = new Room();
		for(int i=0;i<lines.length;i++){
			if(lines[i].length()==0) continue;
			switch(lines[i].charAt(0)){
				case 'r': boolean newRm = false;
						  Room rm;
						  if(lst.find(lines[i].substring(2,lines[i].length()))==null){
						  	//if there's no existing room with the tag, make a new room
						  	rm=new Room();
						  	numrms++;
						  	newRm=true;
						  	rm.addTag(lines[i].substring(2,lines[i].length()));
						  	lst.insert(rm);
						  	curr_room_file=rm;
						  	if(i==0) current_room=rm;
						  	break;
						  }
						  else{
						  	//if theres an existing room with the tag, edit that one (in fact, do nothing to it)
						  	rm=lst.find(lines[i].substring(2,lines[i].length()));
						  	curr_room_file=rm;
						  	break;
						  }
				case 'd': if(curr_room_file==null){System.out.println("Error2"); System.exit(0);}
						  //adds description to the room thats currently being edited (current_room_file)
						  curr_room_file.addDescription(lines[i].substring(2,lines[i].length()));
						  break;
				case 'o': if(curr_room_file==null){System.out.println("Error3"); System.exit(0);}
						  //inserts an option to the room thats currently being edited (current_room_file)
						  curr_room_file.insert_option(lines[i].substring(2,lines[i].length()));
						  break;
				case 't': Room r;
						  boolean newRoom=false;
						  //if theres no room with the tag (ie its later in the file), create the room
						  if(lst.find(lines[i].substring(2,lines[i].length()))==null){
							r = new Room();
							r.addTag(lines[i].substring(2,lines[i].length()));
							numrms++;
							newRoom=true;
						  }
						  //otherwise edit that room: have the most recent option lead to the room thats stated
						  else{
							r=lst.find(lines[i].substring(2,lines[i].length()));
						  }
						  if(curr_room_file==null){System.out.println("Error4"); System.exit(0);}
						  curr_room_file.options.updateHeadRm(r);
						  if(newRoom) lst.insert(r);
						  break;
				default: break;
			}
		}
		Helper help = new Helper(current_room, lst);
		return help;
	}
	public static void instantiateRoom(Room r){
		//just prints the tag and the options
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("******************************************");
		System.out.println("YOU ARE NOW IN THE " + r.getTag()+" ROOM \n");
		r.print_options();
	}
	public static void runGame(Helper help){
		Room current = help.rm;
		LList lst = help.lst;
		Scanner scan = new Scanner(System.in);
		Stack progress = new Stack();
		boolean yTrue = false;
		progress.push(current);
		while(true){
			instantiateRoom(current);
			if(yTrue){
				lst.printInfo();
				yTrue=false;
			}
			//only care about the first character of the input (a,b,c,d,...etc)
			char input = scan.nextLine().charAt(0);
			try{
				if(input=='y'){
					yTrue=true;
					continue;
				}				

				if(input=='q'){
					//exits game
					System.out.println("Thanks for playing!");
					System.exit(0);
					continue;
				}
				if(input=='r'){
					//resets game
					current=progress.firstRoom();
					progress.reset();
					progress.push(current);
					continue;
				}

				if(input=='z'){
					//undo's most recent choice
					current=progress.pop();
					continue;
				}
				//otherwise update the current room to be the room that the option (a-l) leads to
				if(current.options.returnSize()+96<(int)input){
					System.out.println("Error! Not a valid option!");
					continue;
				}
				if(current.findOption(input)!=null){
					current=current.findOption(input);
					progress.push(current);
					continue;
				}
				if(current.findOption(input)==null){
					System.out.println("??");
					continue;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args){
		runGame(makeGame(args));
	}
}