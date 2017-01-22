package coffee;

public class Queue {
	Node frontNode;
	Node rearNode;
	Queue()
	{
		this.frontNode=null;
		this.rearNode=null;
	}
	Queue createQueue()
	{
		return new Queue();
	}
	boolean isEmpty()
	{
		return (frontNode==null);
	}
	void enQueue(int data)
	{
		Node newNode = new Node(data);
		if(rearNode!=null)
			rearNode.next=newNode;
		rearNode=newNode;
		if(frontNode == null)
			frontNode=rearNode;
	}
	int deQueue()
	{
		int data = null;
		if(isEmpty())
		{
			throw new EmptyQueueException("Queue Empty");
		}
		else{
			data = frontNode.data;
			frontNode = frontNode.next;
		}
		return data;
	}
}
