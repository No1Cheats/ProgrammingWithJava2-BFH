package Generics;

import java.util.ArrayList;
import java.util.List;

public class Series<V> {

    private V initialValue;
    private V nextValue;
    private Function<V> updateFunc;
    private  Predicate<V> condition;

    public Series(V initialValue, Function<V> updateFunc, Predicate<V> condition){
        this.initialValue = initialValue;
        this.nextValue = initialValue;
        this.updateFunc = updateFunc;
        this.condition = condition;
    }

    public boolean hasNext(){
        return this.condition.test(this.nextValue);
    }

    public V next(){
        if(!this.hasNext()){
            throw new IllegalStateException();
        }
        V next = this.nextValue;
        this.nextValue = this.updateFunc.apply(this.nextValue);
        return  next;
    }

    public void reset(){
        this.nextValue = this.initialValue;
    }

    public List<V> toList(){
        List<V> list = new ArrayList<>();
        V nextValue = this.nextValue;
        this.nextValue = this.initialValue;
        while (this.hasNext()) {
            list.add(this.next());
        }
        this.nextValue = nextValue;
        return list;
    }

}

