package cn.com.agree.lib;

import java.util.Queue;

public class MyQueueDemo <E> {

    private  int front;//队首
    private int rear;//队尾

    private int max_size=16;
    private Object []data;

    private MyQueueDemo(){

    }

    private MyQueueDemo( int size){

        if (size<0){
            throw  new IllegalArgumentException("队列初始化失败"+size);

        }
        this.max_size=size;
        front=rear=0;
        data=new Object[max_size];

    }

    //判断是否为空
    public boolean isEmpty(){
        return  rear==front?true:false;

    }
    //入队
    public boolean add(E e){
        if (rear==max_size){
            throw new RuntimeException("队列满了");
        }else {
            data[rear++]=e;

            return true;
        }
    }
    //出队
    public  E poll (){
        if (isEmpty()){
            throw  new RuntimeException("队列为空");

        }
        else {
            E mE=(E)data[front];
            data[front++]=null;
            return mE;
        }
    }
    public int length(){
        return  rear-front;
    }

}
