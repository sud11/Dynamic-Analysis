package coffee;

public class Node {
	int data;
	Node next;
	Node(int element)
	{
		data=element;
		next=null;
	}
	Node(int element, Node ptr)
	{
		data = element;
		next = ptr;
	}
	
}
