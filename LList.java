//LList.java
//Used for storing a bunch of different rooms in one data structure
class LList{
	private class Node{
		Node next;
		Room rm;
	}
	private Node head;
	public void printInfo(){
		Node nd =head;
		while(nd!=null){
			System.out.println(nd.rm.getTag());
			nd.rm.options.printOptions();
			nd=nd.next;
		}
	}
	public void insert(Room r){
		if(head==null){
			head = new Node();
			head.rm=r;
		}
		else{
			Node nd = new Node();
			nd.rm=r;
			nd.next=head;
			head=nd;
		}
	}
	public Room find(String s){
		Node nd = head;
		while(nd!=null){
			if(nd.rm.getTag().equals(s)){
				return nd.rm;
			}
			nd=nd.next;
		}
		return null;
	}
}