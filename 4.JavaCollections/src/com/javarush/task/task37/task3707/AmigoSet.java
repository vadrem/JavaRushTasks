package com.javarush.task.task37.task3707;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AmigoSet <E> extends AbstractSet<E> implements Set<E>,Serializable, Cloneable{

    private  final static Object PRESENT = new Object();
    private  transient HashMap<E, Object> map;

    public AmigoSet(){
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection <? extends E> collection){
        this.map = new HashMap<>((int)Math.max(16, Math.ceil(collection.size()/.75f)));
        this.addAll(collection);
    }

    @Override
    public boolean add(E e) {
        Object result = this.map.put(e, PRESENT);

        if(result == null){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Iterator<E> iterator() {
        return this.map.keySet().iterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.map.containsKey(o);
    }

    @Override
    public boolean remove(Object o) {
        if(this.map.remove(o) == null) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public Object clone() {

        try{
            AmigoSet copy = (AmigoSet)super.clone();
            copy.map = (HashMap) map.clone();
            return copy;
        }catch(Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream oos) throws Exception {
        oos.defaultWriteObject();

        oos.writeObject(map.size());
        for(E e:map.keySet()){
            oos.writeObject(e);
        }
        oos.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        oos.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
    }

    private void readObject(ObjectInputStream ois) throws Exception {
        ois.defaultReadObject();

        int size = (int)ois.readObject();
        Set<E> set = new HashSet<>();
        for(int i =0;i<size;i++){
            set.add((E)ois.readObject());
        }
        int capacity = (int)ois.readObject();
        float loadFactor = (float)ois.readObject();
        map = new HashMap<>(capacity,loadFactor);
        for(E e:set){
            map.put(e,PRESENT);
        }

    }
}
