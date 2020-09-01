package cn.com.agree.lib;

import java.util.Queue;

public class MyQueue<E> {


    private int front;//队头一端
    private int rear;//队尾一端

    private int max_size = 16;//
    private Object[] data;

    public MyQueue() {
        this(10);
    }

    public MyQueue(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("队列初始化失败，原因是：" + size);

        }
        this.max_size = size;
        front = rear = 0;
        data = new Object[max_size];
    }

    //判断是否为空
    public boolean isEmpty() {
        return rear == front ? true : false;

    }

    //入队
    public boolean add(E e) {
        if (rear == max_size) {
            throw new RuntimeException("队列满了");
        } else {
            data[rear++] = e;
            return true;
        }
    }

    //返回队首元素
    public E peek() {

        if (isEmpty()) {
            return null;
        }
        return (E) data[front];
    }

    //出队
    public E poll() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            E e = (E) data[front];
            data[front++] = null;
            return e;

        }
    }

    public int length() {
        return rear - front;
    }

    public static void main(String[] args) {

        MyQueue mMyQueue=new MyQueue();
        mMyQueue.add("h");
        mMyQueue.add(20);
        mMyQueue.add("hyplo");
        mMyQueue.add(10.0);
        mMyQueue.add("agree");
        int length=mMyQueue.length();
        for (int i = 0; i <length ; i++) {
            System.out.println(mMyQueue.poll());

        }
    }

}
