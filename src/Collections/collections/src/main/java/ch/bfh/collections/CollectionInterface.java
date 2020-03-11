package ch.bfh.collections;

import java.util.*;

public interface CollectionInterface<E, K, V> {

    // interface Collection<E>

    boolean isEmpty();          // true if the collection is empty
    int size();                 // number of elements in the collection
    //boolean add(E e);           // add item e to the collection
    //boolean remove(Object e);   // removes e from the collection
    //boolean contains(Object e); // true if the collection contains e
    void clear();               // removes all elements from the collection
    Object[] toArray();         // returns an array containing the elements of the collection

    // inherited from Iterable<E>
    Iterator<E> iterator();     // returns an iterator over all elements

    // -------------------------------

    // interface List<E>

    // positional retrieving 
    E get(int i);               // returns element at index i

    // positional manipulation
    E set(int index, E e);      // replaces the element at the specified index 
    void add(int i, E e);       // inserts e at the specified index
    E remove(int i);            // removes element at the specified index

    // finding positions of items
    int indexOf(Object e);      // returns index of first occurence of e
    int lastIndexOf(Object e);  // returns the index of last occurence of e

    // -------------------------------

    // interface Set<E>

    boolean contains(Object x);                 // tests if x element-of X
    boolean containsAll(Collection<?> y);       // tests if Y subset-of X
    boolean addAll(Collection<? extends E> y);  // computes X union Y
    boolean retainAll(Collection<?> y);         // computes X intersection Y
    boolean removeAll(Collection<?> y);         // computes X minus Y

    // -------------------------------

    // interface Set<E>

    E first();                       // returns the minimal element
    E last();                        // returns the maximal element 
    SortedSet<E> tailSet(E e);       // returns elements that are greater or equal to e
    SortedSet<E> headSet(E e);       // returns elements that are strictly less than e
    SortedSet<E> subSet(E e1, E e2); // returns elements that range from e1 (inclusive) to e2 (exclusive)
    
    // -------------------------------

    // interface Queue<E>

    E element();         // retrieves first element without removing it
    E peek();            // dito
    boolean add(E e);    // adds e to the queue
    boolean offer(E e);  // dito
    E remove();          // retrieves and removes first element
    E poll();            // dito

    // -------------------------------

    // interface Deque<E>
    E getFirst();           // retrieves first element without removing it
    E peekFirst();          // dito
    E getLast();            // retrieves last element without removing it
    E peekLast();           // dito
    void addFirst(E e);     // adds e at the front 
    void offerFirst(E e);   // dito
    void push(E e);         // dito
    void addLast(E e);      // add e at the end
    void offerLast(E e);    // dito
    E removeFirst();        // retrieves and removes first element
    E pollFirst();          // dito
    E pop();                // dito
    E removeLast();         // retrieves and removes first element
    E pollLast();           // dito

    // -------------------------------

    // interface Map<K,V>

    boolean containsKey(Object key);    // returns true if a mapping with the given key exists
    boolean containsValue(Object key);  // returns true if a mapping for the given value exists
    V get(Object key);                  // returns the value of the mapping for the given key
                                        // (or null if the key does not exist) 
    V put(K key, V value);              // adds a new mapping or replaces the value of an existing mapping 
    V remove(Object key);               // removes the mapping if the given key exists 
    V replace(K key, V value);          // replaces the value in the mapping if the given key exists 
    Collection<V> values();             // returns a collection of all values 
    Set<K> keySet();                    // returns a set of all keys 


    // -------------------------------

    // unmodifiable collections
    
    Collection<E> unmodifiableCollection(Collection<E> collection);
    List<E> unmodifiableList(List<E> list);
    Set<E> unmodifiableSet(Set<E> set);
    Map<K,V> unmodifiableMap(Map<K,V> map); 
    SortedSet<E> unmodifiableSortedSet(SortedSet<E> set);
    SortedMap<K,V> unmodifiableSortedMap(SortedMap<K,V> map);

}