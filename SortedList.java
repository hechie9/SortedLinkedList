package SpawnList;

import java.util.Iterator;

public interface SortedList<E> {

    /**
     * Adds a new element in the SortedLinkedList
     * @param elem element to be added in the SortedLinkedList
     */
    void add(E elem);

    /**
     * Obtains an element at the given index
     * @param index index of the element
     * @return element at the given index
     */
    E get(int index);

    /**
     * Obtains the index with the first occurence of the element
     * @param elem element to search
     * @return index with the first occurence of the element / -1 if the element does not exist
     */
    int indexOf(E elem);

    /**
     * Obtains the size of the collection
     * @return size of the collection
     */
    int size();

    /**
     * Removes the element at the given index
     * @param index index where the element is stored
     * @return true if the element was removed successfully / false otherwise
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    E remove(int index) throws IndexOutOfBoundsException;

    /**
     * Obtains an iterator for the SortedLinkedList
     * @return iterator for the SortedLinkedList
     */
    Iterator<E> iterator();
}
