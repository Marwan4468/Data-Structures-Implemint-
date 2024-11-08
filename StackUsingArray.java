public class StackUsingArray {
    private int []arr;
    private int initial_size;
    private int top_index;
    public StackA(){
        this.initial_size = 5;
        this.arr = new int[this.initial_size];
        this.top_index = -1;
    }
    public void push(int data){
        resizeOrNot();
        arr[++top_index] = data;
    }
    private void resizeOrNot(){
        if(top_index < arr.length-1){return;}
        int []newArray = new int[arr.length+initial_size];
        for(int i=0; i<arr.length; i++){
            newArray[i] = arr[i];
        }
        arr = newArray;
    }
    public int peek(){
        if(top_index == -1){return 0;}
        return arr[top_index];
    }
    public int pop(){
        if(top_index == -1){return 0;}
        int data = arr[top_index];
        arr[top_index] = 0;
        return data;
    }
    public int size(){
        return top_index+1;
    }
    public boolean hasData(){return this.top_index!=-1;}
}