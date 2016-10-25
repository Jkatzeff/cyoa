//StringStack.java
//Simple Stack for Strings
class StringStack{
	private String[] items;
	private int num_items;
	StringStack(){
		items = new String[12];
		num_items=-1;
	}
	public void push(String r){
		items[++num_items]=r;
	}
	public void pop(){
		if(isEmpty()){ return;}
		if(items[num_items]==null){num_items--;}
		System.out.println(items[num_items--]);
	}
	public boolean isEmpty(){
		if(num_items==-1) return true;
		return false;
	}
}