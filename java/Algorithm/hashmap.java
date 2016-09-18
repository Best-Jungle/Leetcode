package com.bryantchang.hashsearch;

import java.util.;


  Created by Bryant_Chang on 2016918.
 

class MapItemK, V{
    MapItemK, V next;
    K key;
    V value;
    int hash;

    MapItem(K k, V v, int hash){
        this.key = k;
        this.value = v;
        this.hash = hash;
    }
}

class MyHashMapK, V {
    private int size;当前容量
    private static int DEFAULT_CAPACITY = 16;默认容量
    private MapItemK, V[] itemTable;
    private static float LOAD_FACTOR = 0.75f;
    private int max;最大承载能力

    public MyHashMap(int init_capacity, float load_factor) {
        对于装载因子进行判断
        if(init_capacity  0) {
            throw new IllegalArgumentException(init_capacity illegal);
        }
        if(load_factor = 0  Float.isNaN(load_factor)) {
            throw new IllegalArgumentException(load_factor illegal);
        }

        this.LOAD_FACTOR = load_factor;
        max = (int)(init_capacity  load_factor);
        itemTable = new MapItem[init_capacity];
    }

    public MyHashMap() {
        this(DEFAULT_CAPACITY, LOAD_FACTOR);
    }

    public boolean setMapItem(MapItemK, V tmp, MapItem[] table) {
        int index = indexFor(tmp.hash, table.length);
        MapItemK, V entry = table[index];
        存在冲突
        if(null != entry) {
            while(null != entry) {
                若有相同的值则不存
                if(tmp.key == entry.key  tmp.key.equals(entry.key) &&
                        tmp.value == entry.value  tmp.value.equals(entry.value)&&
                        tmp.hash == entry.hash ){
                    return false;
                }
                else if(tmp.key != entry.key && tmp.value != entry.value) {
                    if(null == entry) {
                        break;
                    }
                    entry = entry.next;
                }
            }
            addEntry2Last(entry, tmp);
        }
        setFirstEntry(tmp, index, table);
        return true;
    }


    添加元素
    public boolean put(K k, V v) {
        计算k的hash值
        int hash_key = k.hashCode();
        MapItemK, V tmp = new MapItemK, V(k, v, hash_key);
       if(setMapItem(tmp, itemTable)) {
            size++;
           return true;
        }
        return false;
    }

    public V get(K k) {
        MapItemK, V item = null;
        int index = indexFor(k.hashCode(), itemTable.length);
        MapItemK, V entry = itemTable[index];
        if (null == entry) {
            return null;
        }
        while(null != entry) {
            if(entry.key == k  entry.key.equals(k)) {
                return entry.value;
            }
            entry = entry.next;

        }
        return null;
    }

    扩容方法
    private void reSize(int newSize) {
        MapItemK, V[] newTable = new MapItem[newSize];
        max = (int)(newSize  DEFAULT_CAPACITY);
        for(int j = 0; j  itemTable.length; j++) {
            MapItemK, V entry = itemTable[j];

            entry是linklist
            while(null != entry) {
                setMapItem(entry, newTable);
                entry = entry.next;
            }
        }
        itemTable = newTable;
    }

    将元素挂在队尾
    private void addEntry2Last(MapItemK, V entry, MapItemK, V tmp) {
        if(size  max) {
            reSize(itemTable.length  2);
        }
        entry.next = tmp;
    }

    根据hash码，容器长度计算hash码在数组中的下标值
    public int indexFor(int hashcode, int itemLength) {
        return hashcode & (itemLength - 1);
    }


    不冲突时直接添加元素
    private void setFirstEntry(MapItemK, V tmp, int index, MapItem[] table) {
        if(size  max) {
            reSize(table.length  2);
        }

        table[index] = tmp;
        tmp.next = null;
    }

}


public class Main {
    public static void main(String args[]) {
        MyHashMapString, Integer map = new MyHashMapString, Integer();
        map.put(BryantChang, 1);
        map.put(WangYueHan, 2);
        System.out.println(map.get(BryantChang));
        
    }
}
