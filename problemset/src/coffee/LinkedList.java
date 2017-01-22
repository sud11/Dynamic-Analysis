package coffee;

public class LinkedList {
	Node head;
	Node tail;
	LinkedList()
	{
		head=null;
		tail=null;
	}
	void printLinkedList()
	{
		Node temp;
		for(temp=head; temp!=null; temp=temp.next)
		{
			System.out.print(temp.data+" ");
			System.out.println();
		}
	}
	void insertatHead(int element)
	{
		if(head==null && tail==null)
		{
			head = new Node(element);
			tail=head;
		}
		else
		{
			Node temp;
			temp = new Node(element);
			temp.next=head;
			head=temp;
		}
	}
}
