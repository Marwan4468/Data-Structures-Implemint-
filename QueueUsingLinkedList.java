public class QueueUsingLinkedList {
    private Linkedlist l = new Linkedlist();
    private int size = 0 ;
    public void enqueue(int data){
        l.inserFirst(data);
        size++;
    }
    public int dequeue(){
        if(size == 0){return 0;}
        int data = l.getTailData();
        l.deleteTail();
        size--;
        return data;
    }
    public int peek(){
        int data = l.getTailData();
        return data;
    }
    public boolean hasData(){
        return size != 0;
    }
    public int size(){
        return size;
    }
}
