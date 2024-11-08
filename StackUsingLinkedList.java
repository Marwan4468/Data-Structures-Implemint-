public class StackUsingLinkedList {
    private Linkedlist l = new Linkedlist();
    private int size = 0;
    public void push(int data){
        l.insertLast(data);
        size++;
    }
    public int pop(){
        if(size == 0){
            return 0;
        }
        int data = l.getTailData();
        l.deleteTail();
        size--;
        return data;
    }
    public int peek(){
        int data = l.getTailData();
        return data;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
}
