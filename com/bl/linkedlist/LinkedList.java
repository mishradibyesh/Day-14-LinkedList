package com.bl.linkedlist;

public class LinkedList {


	Node head ,tail;
	int size ;

	// adding method at initial
	public void addAtFirst(int val) {
		Node node = new Node();
		node.setData(val);
		if(head==null) {
			head=node;	
		}
		else
		{
			node.setNext(head);
			head=node;
		}
		size++;
	}

	// append at last method
	public void appendAtLast(int val) {
		Node node = new Node();
		node.setData(val);
		if(head == null) {
			head = node ;
			tail = node ;
		}
		else {
			tail=head;
			while(tail.getNext() != null) {
				tail=tail.getNext();
			}
			tail.setNext(node);
		}

		size++;
	}

	// Insert At A position method
	public void insertAtPos(int pos , int val) {
		if(pos == 1) {
			addAtFirst(val);
		}
		else if(pos == size+1) {
			appendAtLast(val);
		}
		else if(pos>1 && pos <= size) {
			Node temp;
			Node node = new Node();
			node.setData(val);
			temp = head ;
			for(int i = 1; i<pos-1 ; i++) {
				temp = temp.getNext();
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
		}
		size++ ;
	}

	// delete at first method
	public void popAtFirst() {
		Node temp;
		temp=head;
		temp=temp.getNext();
		head = temp;
		size--;
	}

	// delete at last method
	public void popAtLast() {
		if(head == null) {
			System.out.println("list is empty");
		}
		else if (size == 1) {
			head = null;
			size--;
		}
		else {
			Node temp;
			temp=head;
			for(int i= 1 ; i < size-1;i++) {
				temp=temp.getNext();
			}
			temp.setNext(null);
			size--;
		}
	}

	//method to insert after a given value
	public void addAfterGivenValue(int prevValue , int value) {
		Node  temp;
		Node node = new Node();
		node.setData(value);
		temp = head ;
		while(temp.getData() != prevValue) {
			temp = temp.getNext();
		}
		node.setNext(temp.getNext());
		temp.setNext(node);
		size++;
	}
 
	//method to delete  given value 
	public void deleteGivenValue(int value) {
		Node preTemp , temp;
		temp = head;
		while(temp.getData() != value) {
			temp = temp.getNext();
		}
		preTemp = head;
		do {
			preTemp = preTemp.getNext();
		}
		while(preTemp.getData() == value);
		
		preTemp.setNext(temp.getNext());
		size--;
	}

	//search method
	public void searchValue(int val) {
		int index = 0 ;
		boolean status = false ;
		Node temp ;
		if(head == null) {
			System.out.println("List is empty");
		}
		else {
			temp = head ;
			while(temp != null) {
				if(temp.getData() == val) {
					status = true ;
					break;
				}
				index++;
				temp = temp.getNext();
			}
			if(status == true) {
				System.out.println("the element "+val+" is present at index number "+index);
			}
			else {
				System.out.println("element is not present in the list");
			}
		}
	}


	// display method
	public void display() {
		Node temp;
		temp=head;
		for(int i=0 ; i<size ; i++)
		{
			System.out.println(temp.getData()) ;
			temp = temp.getNext();
		}
	}

	//main method
	public static void main(String[] args) {
		// creating reference variable of class linkedlist
		LinkedList list = new LinkedList() ;

		//adding data in nodes at first
		list.addAtFirst(56);

		//adding data in nodes at last
		list.appendAtLast(70);

		//adding data in node at a position 2
		list.insertAtPos(2,30);

		//adding the next value after 30 and before 70
		list.addAfterGivenValue(30, 40);

		//displaying the added data in node
		list.display();
		
		list.deleteGivenValue(40);
		System.out.println("after deletion");
		list.display();


	}

}