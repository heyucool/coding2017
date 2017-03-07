package com.coding.basic;

public class BinarySearchTree<T extends Comparable> {

	private T data;
	private BinarySearchTree leftChild;
	private BinarySearchTree rightChild;

	public BinarySearchTree() {
		super();
		this.data = null;
		this.leftChild = null;
		this.rightChild = null;
	}

	public BinarySearchTree(T data) {
		this();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public BinarySearchTree getLeftChild() {
		return leftChild;
	}

	public BinarySearchTree getRightChild() {
		return rightChild;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setLeftChild(BinarySearchTree leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(BinarySearchTree rightChild) {
		this.rightChild = rightChild;
	}

	public void insert(Object obj) {
		insert(obj, this);
	}

	private boolean insert(T element, BinarySearchTree node) {

		BinarySearchTree bstNode = new BinarySearchTree(element);


		return false;

	}

	public void inOrder(BinarySearchTree node) {

		if (node != null) {
			inOrder(node.getLeftChild());
			visit(node);
			inOrder(node.getRightChild());
		}

	}

	public void levelOrder(BinarySearchTree node) {
		Queue queue = new Queue();
		BinarySearchTree bstNode = null;
		queue.enQueue(node);

		while (!queue.isEmpty()) {
			bstNode = (BinarySearchTree) queue.deQueue();
			visit(bstNode);

			if (bstNode.getLeftChild() != null) {
				queue.enQueue(bstNode.getLeftChild());
			}

			if (bstNode.getRightChild() != null) {
				queue.enQueue(bstNode.getRightChild());
			}
		}
	}
	
	public void visit(BinarySearchTree node) {
		System.out.println(node.getData());
	}


}
