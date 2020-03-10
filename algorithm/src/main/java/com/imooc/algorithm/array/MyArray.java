package com.imooc.algorithm.array;


/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 封装数组
 * @date 2020/2/7 22:52
 */
public class MyArray<E> {

    /**
     * 版本2 支持动态扩容
     * 支持动态扩容需要考虑两个问题
     * 1.扩容的倍数
     * 2.数据的复制与释放问题
     */

    //数组元素数目
    private int size;

    // 容量
    private int capacity;

    private E[] data;

    /**
     * MyArray
     * @description 数组构造函数
     * @author liugaoyang
     * @date 2020/2/7 22:55
     * @version 1.0.0
     */
    public MyArray(int capacity) {
        this.capacity = capacity;
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    // 无参构造函数  容量为10
    public MyArray(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return capacity;
    }

    // 向数组中添加元素
    public void addLast(E item){
        insertItem(this.size, item);
    }

    // 数组扩容操作
    private void reSize(int size){
        E[] newData = (E[]) new Object[capacity*2];
        for (int i = 0;i<this.size; i++){
            newData[i] = this.data[i];
        }
        this.data = newData;
        this.capacity = capacity*2;
        System.out.printf("执行扩容操作！");
    }

    // 向指定位置插入元素  需要移动相关元素
    public void insertItem(int index, E item){
        if (size == capacity){
            reSize(this.capacity * 2);
        }
        if (index < 0 || index > size){
            throw new IllegalArgumentException("下标越界");
        }
        for (int i = size; i > index; i--){
            data[i] = data[i-1];
        }
        data[index] = item;
        size++;
    }

    // 在数组头部添加一个元素
    public void addFirst(E item){
        insertItem(0, item);
    }

    // 查询元素
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("坐标异常");
        }
        return data[index];
    }

    // 修改元素
    public void modify(int index, E item){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("坐标异常");
        }
        data[index] = item;
    }

    // 数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 数组是否包含某个元素
    public boolean contains(E item){
        for (int i = 0; i < size; i++){
            if (data[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    // 找到数组对应的下标
    public int find(E item){
        for (int i = 0; i < size; i++){
            if (data[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    public void deleteElement(E item){
        int index = find(item);
        if (index != -1){
            delete(index);
        }
    }

    // 删除index下标的元素 返回为删除元素的值
    public E delete(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("坐标异常");
        }
        E res = data[index];
        // 删除元素后需要前移其后的元素
        for(int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;// help gc
        // 数组容量进行缩小
        if (size < capacity/2){
            reSize(capacity/2);
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array size :%d capacity:%d \n", size, capacity));
        res.append("[");
        for (int i = 0; i < size; i++){
            res.append(data[i]);
            if (i != size-1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        MyArray<Integer> myArray = new MyArray<>(2);
        myArray.addFirst(10);
        myArray.addFirst(100);
        myArray.insertItem(2, 200);
        System.out.println(myArray.get(2));
        myArray.modify(2, -200);
        System.out.println(myArray.toString());
        myArray.delete(0);
        myArray.deleteElement(-200);
        System.out.println(myArray.toString());
    }
}
