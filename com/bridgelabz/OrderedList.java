package com.bridgelabz;

public class OrderedList<T extends Comparable<T>> extends LinkedList<T> {
	
	public void add1(T data) {
		Node<T> tempCurrent = root;
		Node<T> tempPrev = root;
		Node<T> newNode = new Node<T>(data);
		if (this.isEmpty()) {
			root = newNode;
			end = root;
		} else if (root.data.compareTo(data) > 0) {
			newNode.next = root;
			root = newNode;
		} else if (end.data.compareTo(data) < 0) {
			end.next = newNode;
			newNode.next = null;
			end=newNode;
		} else {
			while (tempCurrent != null) {
				if (tempCurrent.data.compareTo(data) > 0) {
					newNode.next = tempPrev.next;
					tempPrev.next = newNode;
					break;
				}
				tempPrev=tempCurrent;
				tempCurrent=tempCurrent.next;
			}
		}
	}

	public boolean search(int numSearch) {
		// TODO Auto-generated method stub
		return false;
	}

	public T pop(int numSearch) {
		return null;
		// TODO Auto-generated method stub
		
	}
    

}
