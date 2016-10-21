Josephus Loop.java

public class Solution {
	public static void main(String[] args) {
		   josephusSol(6, 3);

	}
	
	public static void josephusSol(int totalNum, int cycleNum) {
		Node header = new Node(1);
		Node pointer = header;

		for(int i =2; i <=totalNum ; i ++){
			pointer. next = new Node(i );
			pointer = pointer. next;
		}
		pointer.next = header;
		System.out.println("The initial NO. is " +pointer.val +"  " );	//在链表的末尾
		//到这里位置，初始化链表结束

		while(pointer !=pointer .next ){
			for(int i = 1; i <cycleNum ; i ++){
					pointer = pointer. next;
			}
			System.out.println("The Get Out NO. is " +pointer.next.val +"  ");
			pointer.next = pointer. next. next;	//next的指向在这里改变
		}

		System.out.println("The Final NO. is " +pointer.val );
	}
	
	public static class Node {
		public int val ;
		public Node next ;
	  
		public Node(int val ) {
			this.val = val ;
			next = null;
		}
	}
} 