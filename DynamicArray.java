public class DynamicArray<T extends Comparable<T>> {
    private T []arr;
    private int initial_size;
    private int capasity;
    public Array(){
        this.initial_size = 5;
        this.arr = (T[])new Comparable[initial_size];
        this.capasity = 0;
    }
    public void add(T data){
        resizeOrNot();
        this.arr[capasity++] = data;
    }
    public void set(T data, int index){
        this.arr[index] = data;
    }
    public T getItem(int index){
        return this.arr[index];
    }
    public T removeAt(int index){
        if(index < 0 || index >= this.arr.length){throw new IndexOutOfBoundsException("illegal index");}
        T []newArray = (T[])new Comparable[this.capasity-1];
        T data = this.arr[index];

        for(int i=0,j=0; j<this.capasity; i++,j++){
            if(i == index){
                i--;
            }
            else{
                newArray[i] = this.arr[j];
            }
        }
        this.arr = newArray;
        return data;
    }
    public boolean remove(T data){
        int index = indexOf(data);
        if(index == -1){return false;}
        removeAt(index);
        return true;
    }
    public int indexOf(T data){
        for(int i=0; i<this.arr.length; i++){
            if(this.arr[i] == data){
                return i;
            }
        }
        return -1;
    }
    private void resizeOrNot(){
        if(this.capasity < this.arr.length){
            return;
        }
        T []newArray = (T[])new Comparable[this.arr.length+this.initial_size];
        copyToNewArray(newArray);
        this.arr = newArray; 
    }
    private void copyToNewArray(T []newArray){
        for(int i=0; i<this.arr.length; i++){
            newArray[i]= this.arr[i];
        }
    }
    public int getSize(){
        return this.capasity;
    }
    public boolean hasData(){
        return capasity != 0;
    }
}
