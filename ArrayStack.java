public class ArrayStack implements Stack {
    Object[] arr = new Object[10];
    int top = -1;

    @Override
    public void push(Object item) {
        if(top ==arr.length-1){
            doubleArrSize();
        }
        arr[++top]= item;
    }

    @Override
    public Object pop() {
        if(!empty()){
            return arr[top--];
        }
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object peek() {
        if(!empty()){
            return arr[top];
        }
        else{
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean empty() {
        return (top == -1);
    }

    private void doubleArrSize(){
        Object[] newarr = new Object[arr.length*2];
        for(int i= 0;i<arr.length;i++){
            newarr[i]=arr[i];
        }
        arr = newarr;
    }
}
