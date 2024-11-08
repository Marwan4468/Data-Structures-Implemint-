public class SingleLinkedList{
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    private Node head;
    private Node tail;
    public void insertLast(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            head = tail = newNode;
            return;
        }
        this.tail.next = newNode;
        tail = newNode;
    }
    public void inserFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void insertAfter(int data, int after){
        Node newNode = new Node(data);
        Node currentNode = find(after);
        if(currentNode!=null){
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            if(currentNode == tail){
                tail = newNode;
            }
            return;
        }
        System.out.println("there is no "+after+" in the linkedlist");
    }
    public void insertBefore(int data, int before){
        Node newNode = new Node(data);
        Node currentNode = find(before);
        if(currentNode != null){
            Node nodeParent = findParent(before);
            newNode.next = currentNode;
            if(nodeParent == null){
                head = newNode;
                return;
            }
            nodeParent.next = newNode;
            return;
        }
        System.out.println("there is no "+before+" in the linkedlist");
    }
    public void delete(int data){
        if(head == null){
            return;
        }
        Node currentNode = find(data);
        if(currentNode!=null){
            if(currentNode == head && currentNode == tail){ 
                head = tail = null;
                return;
            }
            if(currentNode == head){
                head = currentNode.next;
                return;
            }
            Node nodeParent = findParent(data);
            if(currentNode == tail){
                tail = nodeParent;
            }
            nodeParent.next = currentNode.next;
        }
    }
    public void deleteTail(){
        if(head == null){
            return;
        }
        if(head == tail){
            head = tail = null;
            return;
        }
        Node tailParent = findParent(tail.data);
        tail = tailParent;
        tail.next = null;
    }
    private Node find(int data){
        Node currentNode;
        for(currentNode=head; currentNode!=null; currentNode=currentNode.next){
            if(currentNode.data == data){
                return currentNode;
            }
        }
        return null;
    }
    private Node findParent(int data){
        Node currentNode;
        for(currentNode=head; currentNode!=null; currentNode=currentNode.next){
            if(currentNode.next!=null){
                if(currentNode.next.data == data){
                    return currentNode;
                }
            }
        }
        return null;
    }
    public void print(){
        for(Node currentNode=head; currentNode!=null; currentNode=currentNode.next){
            System.out.print(currentNode.data+"->");
        }
    }
    public int getHeadData(){
        if(head == null){return 0;}
        return this.head.data;
    }
    public int getTailData(){
        if(tail == null){return 0;}
        return this.tail.data;
    }
}