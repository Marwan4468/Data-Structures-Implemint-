public class DoublyLinkedList {
    private static class Node{
        int data;
        Node next;
        Node brev;
        Node(int data){
            this.data = data;
        }
    }
    private Node head;
    private Node tail;
    public void insertLast(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.head = this.tail = newNode;
            return;
        }
        this.tail.next = newNode;
        newNode.brev = this.tail;
        this.tail = newNode;
    }
    public void inserFirst(int data){
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = this.tail = newNode;
            return;
        }
        this.head.brev = newNode;
        newNode.next = this.head;
        head = newNode;
    }
    public void insertAfter(int data, int after){
        Node nodeToInsertAfter = findNode(after);
        if(nodeToInsertAfter != null){
            Node newNode = new Node(data);
            newNode.next = nodeToInsertAfter.next;
            nodeToInsertAfter.next = newNode;
            newNode.brev = nodeToInsertAfter;
            if(nodeToInsertAfter == this.tail){
                this.tail = newNode;
            }
        }
    }
    public void insertBefore(int data, int before){
        Node nodeToInsertBefore = findNode(data);
        if(nodeToInsertBefore != null){
            Node newNode = new Node(data);
            newNode.brev = nodeToInsertBefore.brev;
            nodeToInsertBefore.brev = newNode;
            newNode.next = nodeToInsertBefore;
            if(nodeToInsertBefore == this.head){
                this.head = newNode;
            }
        }
    }
    private Node findNode(int data){
        for(Node currentNode = this.head; currentNode != null; currentNode = currentNode.next){
            if(currentNode.data == data){
                return currentNode;
            }
        }
        return null;
    }
    public int getHeadData(){
        if(this.head == null){return 0;}
        return head.data;
    }
    public int getTailData(){
        if(tail == null){return 0;}
        return this.tail.data;
    }
}
