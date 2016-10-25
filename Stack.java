//Stack.java
//Stack of Rooms to keep track of progress in gameplay for CYOA app
class Stack{
	private Room[] rooms;
	private int num_rooms;
	Stack(){
		rooms = new Room[10];
		num_rooms=0;
	}
	public void push(Room r){
		if(num_rooms==rooms.length){
			Room[] temp= new Room[rooms.length*2];
			for(int i=0;i<rooms.length;i++){
				temp[i]=rooms[i];
			}
			rooms=temp;
		}
		rooms[num_rooms++]=r;
	}
	public Room pop(){
		if(num_rooms==0){
			System.out.println("Error, too few rooms");
			System.exit(0);
		}
		return rooms[--num_rooms];
	}
	public Room firstRoom(){
		if(num_rooms>0) return rooms[0];
		else{
			System.out.println("Not enough rooms!");
			System.exit(0);
			return null;

		}
	}
	public void reset(){
		rooms=new Room[10];
		num_rooms=0;
	}
}