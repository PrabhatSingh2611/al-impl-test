package customArrayKist.ravi;

import java.util.*;

/**
 * This is the custom arraylist class by Ravi Raj
 * there might be some errors as it's not completely finished yet
 *
 * @param <E>
 */

public class ArrayListCustom<E> implements List<E> {

    //defining the initial capacity and size of the array
    private static final int INITIAL_ARRAY_CAPACITY = 10;
    private int size = 0;
    private Object[] listData;
    private Scanner sc;

    //Constructor og this class
    public ArrayListCustom() {
        listData = new Object[INITIAL_ARRAY_CAPACITY];
        sc = new Scanner(System.in);
    }

    @Override

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (Object o : listData
        ) {
            if (o != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (Object obj : listData) {
            if (obj == null) {
                break;
            }
            if (obj.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] temp = Arrays.copyOf(listData, size);
        return temp;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * this will a new element at the end of the list
     *
     * @param e
     * @return
     */
    @Override
    public boolean add(E e) {
        if (size == listData.length) {
            increaseCapacity();
        }
        listData[size++] = e;
        return true;
    }

    /**
     * This method increases the size of our array (doubles the size) and assign it to the same list data.
     */
    private void increaseCapacity() {
        int newLength = listData.length * 2;
        listData = Arrays.copyOf(listData, newLength);
    }

    /**
     * this method removes the object from list by comparing the object name
     *
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) {

        Object[] temp = new Object[listData.length];
        for (int i = 0, j = 0; i < size; i++) {
            if (listData[i].equals(o)) {
                continue;
            }
            temp[j] = listData[i];
            j++;
        }
        listData = temp;
        size--; //this makes the size reduced by 1 as one element is out
        return true;
    }

    /**
     * this method compares the collection item with our array list and gives the output
     *
     * @param c
     * @return
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> itr = c.iterator();
        boolean loopFlag = true;
        boolean whileLoop = true;
        for (Object o : listData
        ) {
            while (itr.hasNext()) {
                Object cElement = itr.next();
                if (cElement == o) {
                    loopFlag = true;
                }
                whileLoop = true;
            }
            if (!whileLoop) {
                return true;
            }
            if (!loopFlag) {
                break;
            }
            loopFlag = false;
            whileLoop = false;
        }
        return false;
    }

    /**
     * this method will add element at end of our arraylist
     *
     * @param c
     * @return
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (E e : c) {
            if (size == listData.length) {
                increaseCapacity();
            }
            listData[size++] = e;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (c.isEmpty() || index >= size) {
            return false;
        }
        for (E e : c) {
            if (size == listData.length) {
                increaseCapacity();
            }
            for (int i = size++ - 1; i >= index; i--) {
                if (size == listData.length) {
                    increaseCapacity();
                }
                listData[i + 1] = listData[i];
            }
            listData[index++] = e;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<?> itr = c.iterator();
        for (int i = 0; i < size; i++) {
            while (itr.hasNext()) {
                Object cElement = itr.next();
                if (cElement == listData[i]) {
                    listData[i] = null;
                    size--;
                }
            }
        }
        nullRemover();
        return false;
    }

    /**
     * This will remove the null data from between the list
     */
    private void nullRemover() {
        Object[] tmp = new Object[listData.length];
        for (int i = 0, j = 0; i < size; i++) {
            if (listData[i] == null) {
                continue;
            }
            tmp[j] = listData[i];
            j++;
        }
        listData = tmp;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * this method clears the list by taking a final permission
     */
    @Override
    public void clear() {
        System.out.print("Are you Sure to clear the list press (Y/N)   :   ");
        String ch = sc.next();
        if (ch.toLowerCase(Locale.ROOT).equals("y")) {
            for (int i = 0; i < size; i++) {
                listData[i] = null;
            }
            size = 0;
        } else {
            System.out.println("This operation is cancelled");
        }
    }

    /**
     * this method gives the element at given index
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index : " + index);
        }
        return (E) listData[index];
    }

    /**
     * sets an element at given index
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        if (element == null || index >= size) {
            return null;
        }
        listData[index] = element;
        return null;
    }

    /**
     * This method will add an element at given index and move rest arraylist to the right
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        if (element == null || index >= size) {

        } else {
            for (int i = size++ - 1; i >= index; i--) {
                if (size == listData.length) {
                    increaseCapacity();
                }
                listData[i + 1] = listData[i];
            }
            listData[index] = element;
            size++;
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Object removedElement = listData[index];
        Object[] temp = new Object[listData.length];
        for (int i = 0, j = 0; i < size; i++) {
            if (listData[i].equals(removedElement)) {
                continue;
            }
            temp[j] = listData[i];
            j++;
        }
        listData = temp;
        size--; //this makes the size reduced by 1 as one element is out
        return (E) removedElement;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (listData[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (listData[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    public void display() {
        System.out.println("Displaying the Array list below");
        for (int i = 0; i < size; i++) {
            System.out.println(listData[i]);
        }
        System.out.println("Size of list is = " + size);
    }
}
