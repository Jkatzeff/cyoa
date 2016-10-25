//List.java
//Used for holding the different options for the Room class
class List{
	private class Node{
		Node next;
		String str;
		Room destination;
	}	
	private Node head;
	public int size=0;
	public int returnSize(){
		return size;
	}
	public void printOptions(){
		Node nd = head;
		while(nd!=null){
			System.out.println("\t"+nd.str);
			System.out.println("\t\t Goes to: "+nd.destination.getTag());
			nd=nd.next;
		}
	}
	public void print(){
		Node nd = head;
		StringStack stk = new StringStack();
		while(nd!=null){
			stk.push(nd.str);
			nd=nd.next;
		}
		if(returnSize()!=0){System.out.println("What do you do?");}
		while(!stk.isEmpty()){
			stk.pop();
		}
	}
	public void updateHeadRm(Room r){
		head.destination=r;
	}
	public void insert(String s, Room r){
		size++;
		if(head==null){
			//if theres no head, make it
			head=new Node();
			head.str=s;
			head.destination=r;
		}
		else{
			//otherwise make a new node and have it point to the head, then make the just added one the head
			Node x = new Node();
			x.destination=r;
			x.str=s;
			x.next=head;
			head=x;
		}
	}
	//z here is the letters a,b,c,... for the options
	public Room findOptionInfo(char z){
		Node tmp = head;
		while(tmp!=null){
			if(tmp.str.length()>0){
				if(tmp.str.charAt(0)==z){
					return tmp.destination;
				}
			}
			tmp=tmp.next;
		}
		return null;
	}
}