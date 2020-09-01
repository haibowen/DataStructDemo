public class MyLink {


    Node head=null;//头节点
    /**
     * 链表中的节点
     */
    static class Node {

        Node next=null;//节点的应用指向下一个节点
        int data;//数据

        public Node(int data){
            this.data=data;

        }
    }

    /**
     * 向链表中插入节点
     */
    public  void  addNode(Node node){
        Node temp=head;
        while (temp.next!=null){//遍历单链表，直到遍历到最后一个则跳出循环
            temp=temp.next;
        }
        temp.next=node;
    }

    /**
     * 插入节点到指定的位置
     */
    public void  insertNode(int index,Node node){
        //对特殊值进行判断
        if (index<1||index>length()+1){
            System.out.println("插入的位置不正确");
            return;
        }

        int  length=1; //记录遍历到第几个节点了
        Node temp=head;
        while (head.next!=null){
            if (index==length++){

                //注意这里的temp是代表当前位置的前一个节点

                //前一个节点   当前节点    下一个节点
               // temp         temp.next   temp.next.next

                node.next=temp.next;
                temp.next=node;
                return;
            }
            temp=temp.next;
        }
    }

    /**
     * 删除指定的节点
     *
     */

    public  void deleteNode(int index){

        //判断index是否合理
        if (index<1||index>length()){
            System.out.println("删除的节点不存在");
            return;
        }
        int length=1;
        Node temp=head;
        while (temp.next!=null){
            if (index==length++){
                //删除操作
                temp.next=temp.next.next;
                return;
            }
            temp=temp.next;
        }
    }

    /**
     * 单链表进行选择排序
     */

    public void  selectSortNode(){
        //特值进行判断
        if (length()<2){
            return;
        }
        Node temp=head;
        while (temp.next!=null){
            Node secondTemp=temp.next;
            while (secondTemp.next!=null){
                if (temp.next.data>secondTemp.next.data){
                    int t=secondTemp.next.data;
                    secondTemp.next.data=temp.next.data;
                    temp.next.data=t;

                }
                secondTemp=secondTemp.next;

            }
            temp=temp.next;
        }
    }

    /**
     * 在不知道头结点的情况下删除指定的节点
     */

    public boolean deletedNoHead(Node node){
        if (node==null||node.next==null){
            return false;
        }
        int tmp=node.data;
        node.data=node.next.data;
        node.next.data=tmp;
        node.next=node.next.next;
        System.out.println("删除成功");
        return true;

    }

    /**
     * 返回链表的长度
     */

    public  int length(){

        int length=0;
        Node temp=head;
        while (temp!=null){
            length++;
            temp=temp.next;

        }
        return length;
    }

    public static void main(String[] args) {

        MyLink mMyLink=new MyLink();
        mMyLink.addNode(new Node(5));
        mMyLink.addNode(new Node(7));
        mMyLink.addNode(new Node(8));
        mMyLink.addNode(new Node(2));
        System.out.println("链表的长度"+mMyLink.length());

        System.out.println("head.data"+mMyLink.head.data);



    }




}
