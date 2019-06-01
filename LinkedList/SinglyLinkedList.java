class Node{
    private int data;
    private Node next;
    public Node(int data){this.data = data;}
    public int getData(){return data;}
    public Node getNext(){return next;}
    public void setData(int data){this.data = data;}
    public void setNext(Node n){this.next = n;}
}
class SinglyLL{
    private int length;
    private Node head = null;

    public SinglyLL(){
        this.length = -1;
    }
    //Inserting a new Node at Head
    public void insertFront(int data)
    {
        if(head == null){
            head = new Node(data);
        }
        else{
            Node temp = new Node(data);
            temp.setNext(head);
            this.head = temp;
        }
        this.length++;
    }
    //Inserting an element after tail.
    public void insertBack(int data){
        Node temp = this.head;
        if(temp == null){
            this.head = new Node(data);
        }
        else{
            while(temp.getNext() != null) temp = temp.getNext();
            temp.setNext(new Node(data));
        }
        this.length++;
    }
    //Inserting an element at a given position in LinkedList
    public void insert(int data , int location){
        if(location <= 0){
            insertFront(data);
        }
        else if(location > length){
            insertBack(data);
        }
        else{
            Node prev = null;
            Node curr = head;
            for(int i = 0 ;i < location; i++)
            {
                prev = curr;
                curr = curr.getNext();
            }

            prev.setNext(new Node(data));
            prev.getNext().setNext(curr);

        }
        length++;
    }
    //Deleting Head.
    public void removeHead(){
        if(length < 0){head = null;}
        else{
        this.head = head.getNext();
        }
        length--;
    }
    //Deleting Tail.
    public void removeTail(){
        if(length <= 0)
        {
            removeHead();
            return;
        }
        Node temp = head;
        Node prev = null;
        while(temp.getNext() != null)
        {
            prev = temp;
            temp = temp.getNext();
        }
        prev.setNext(null);
        length--;
    }
    //Deleting a particular location
    public void remove(int location){
       if(location <= 0){
            removeHead();
        }
        else if(location > length){
            removeTail();
        }
        else{
            Node prev = null;
            Node curr = head;
            for(int i = 0 ;i < location; i++)
            {
                prev = curr;
                curr = curr.getNext();
            }

            prev.setNext(curr.getNext());
            length--;
        } 
    }
    //Print all the elements in the Linked List
    public void printall()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }
    public static void main(String[] args){
        SinglyLL mySLL = new SinglyLL();
        mySLL.insertBack(10);
        mySLL.insertBack(20);
        mySLL.insertBack(30);
        mySLL.insert(15, 1);
        mySLL.removeHead();
        mySLL.removeTail();
        mySLL.removeHead();
        mySLL.removeHead();
        mySLL.printall();

    }

}
