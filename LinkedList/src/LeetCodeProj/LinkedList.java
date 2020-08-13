package LeetCodeProj;

public class LinkedList<E> {

    //设置节点为链表的内部类
    private class Node {
        public Node next;
        public E e;


        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        //当前用户只传来一个节点
        public Node(E e) {
            this(e, null);
        }

        //当用户什么都不传
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }


    }

    //设置链表的头结点和链表的尺寸
    private Node dummyHead;
    private int size;

    //当链表中什么也没有时候
    public LinkedList() {
        dummyHead = new Node(null, null);
    }

    //获取链表中的元素个数
    public int  getsize() {
        //返回它的链表尺寸
        return size;

    }

    //设置返回链表是否为空
    public boolean isEmpty() {
        return size==0;
    }

    //向链表头添加一个元素
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//        //new出一个新的node节点e，
//        // 然后这个节点指向（node.next=head）当前的head头结点
//        //然后再将这个Node node（e）赋值给head
//        //head=new Node(e,head);
//        size++;

        add(0, e);

    }



    //向链表中添加一个元素,就是在索引index位置处添加一个元素e
    public void add(int index, E e) {
        //第一步判断index位置的合法性
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("LinkedList is Illegal");
        }

            //初始化pre指针，初始化和head在同一个地方
            Node pre=dummyHead;
            for(int i =0;i<index;i++){
                //pre指针向前寻找到index-1位置处
                pre = pre.next;
            }
        Node node = new Node(e);
        node.next = pre.next;
        pre.next=node;

        //合成一句,先new处一个新节点e，然后该节点指向pre.next节点
        //pre.next节点指向新new的节点e
        // pre.next = new Node(e, pre.next);

            size++;

    }

    //向链表末尾添加节点
    public void addLast(E e) {
        add(size, e);
    }

    //查询链表中是否有元素e
    public boolean contain(E e) {
        //设置链表的中的当前节点
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        Node prev = dummyHead;
        for(int i = 0 ; i < index ; i ++)
            prev = prev.next;

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.e;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // // 从链表中删除元素e
    public void remove(E e) {

        //初始化虚拟头结点
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.e.equals(e)) {
                break;
            }
            pre = pre.next;
        }

        if (pre.next != null) {
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
            size--;
        }

    }


//    public String tostring() {
//        StringBuilder stu = new StringBuilder();
//        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
//            stu.append(cur + "->");
//        }
//        stu.append("Null");
//
//        return stu.toString();
//    }
@Override
public String toString(){
    StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
    for(Node cur = dummyHead.next ; cur != null ; cur = cur.next)
    {
        res.append(cur + "->");
    }
    res.append("NULL");

    return res.toString();
}



}
