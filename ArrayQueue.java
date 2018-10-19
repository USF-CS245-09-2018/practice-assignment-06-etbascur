public class ArrayQueue implements Queue{
    Object[] arr= new Object[10];
    int head=0;
    int tail=0;

    @Override
    public Object dequeue() {
        if (empty()){
            try {
                throw new Exception();
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
        Object item = arr[head];
        head = head+1;
        if(head>= arr.length){
            head=0;
        }
        return item;
    }

    @Override
    public void enqueue(Object item) {
        if((tail+1)%arr.length==head){
            doubleArraySize();
        }
        if(tail>=arr.length){
            tail = tail%arr.length;
        }
        arr[tail]= item;
        tail = tail +1;
    }

    @Override
    public boolean empty() {
        if (head == tail)
            return true;
        return false;
    }

    private void doubleArraySize(){
        Object[] newarr = new Object[arr.length*2];
        int count =0;
        if(tail<head){
            for(int i = head;i<arr.length;i++){
                newarr[count]=arr[i];
                count++;
            }
        }
        for(int i = 0;i<tail;i++) {
            newarr[count] = arr[i];
            count++;
        }
        head=0;
        tail=count;
        arr = newarr;
    }
}
