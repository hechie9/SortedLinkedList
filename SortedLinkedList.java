/**
 * @author Hechie#1558
 */

import java.util.*;

public class SortedLinkedList<E> implements SortedList<E> {

    private Node<E> head;
    private Comparator<E> comparator;

    /**
     * Constructor from class SortedLinkedList, sorts based on a comparator
     * @param comparator comparator to sort on the insertion
     */
    public SortedLinkedList(Comparator<E> comparator) {
        this.head = null;
        this.comparator = comparator;
    }

    /**
     * Constructor from class SortedLinkedList, sorts based on type's natural order
     */
    public SortedLinkedList() {
        this.head = null;
        this.comparator = (Comparator<E>) Comparator.naturalOrder();
    }

    /**
     * Adds a new element in the SortedLinkedList
     * @param elem element to be added in the SortedLinkedList
     */
    @Override
    public void add(E elem) {

        boolean switched = false;

        if (head == null) {
            head = new NodeClass<>(elem);
        }
        else {
            Node<E> current = head;
            Node<E> newNode = new NodeClass<>(elem);
            Node<E> previousNode = null;

            while (current != null) {

                if (comparator.compare(elem, current.getElem()) < 0) {
                    if (current.equals(head)) {
                        newNode.link(current);
                        head = newNode;
                        switched = true;
                        break;
                    }
                    else {
                        previousNode.link(newNode);
                        newNode.link(current);
                        switched = true;
                        break;
                    }
                }
                previousNode = current;
                current = current.next();
            }

            if (!switched)
                previousNode.link(newNode);
        }
    }

    /**
     * Obtains an element at the given index
     * @param index index of the element
     * @return element at the given index / null if index is out of bounds
     */
    @Override
    public E get(int index) {

        Node <E> current = head;

        for (int i = 0; current != null; i++) {
            if (i == index)
                return current.getElem();
            current = current.next();
        }

        return null;
    }

    /**
     * Obtains the index with the first occurence of the element
     * @param elem element to search
     * @return index with the first occurence of the element / -1 if the element does not exist
     */
    @Override
    public int indexOf(E elem) {

        Node<E> current = head;

        for (int i = 0; current != null; i++) {
            if (current.getElem().equals(elem))
                return i;
            current = current.next();
        }
        return -1;
    }

    /**
     * Obtains the size of the collection
     * @return size of the collection
     */
    @Override
    public int size() {

        Node<E> current = head;
        int i = 0;

        while (current != null) {
            current = current.next();
            i++;
        }
        return i;
    }

    /**
     * Removes the element at the given index
     * @param index index where the element is stored
     * @return true if the element was removed successfully / false otherwise
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {

        Node<E> current = head;
        Node<E> previous = null;
        Node<E> removed = null;

        for (int i = 0; current != null; i++) {
            if (i == index && i == 0) {
                removed = current;
                head = current.next();
                return removed.getElem();
            }
            else if (i == index) {
                removed = current;
                previous.link(current.next());
                return removed.getElem();
            }
            previous = current;
            current = current.next();
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * Obtains an iterator for the SortedLinkedList
     * @return iterator for the SortedLinkedList
     */
    @Override
    public Iterator<E> iterator() {

        List<E> elems = new ArrayList<>();
        Node<E> current = head;

        for (int i = 0; current != null; i++) {
            elems.add(i, current.getElem());
            current = current.next();
        }
        return elems.iterator();
    }

    /**
     * Auxiliar method to use print on SortedLinkedList
     * @return String to be printed
     */
    @Override
    public String toString() {

        StringBuilder elems = new StringBuilder();
        Node<E> current = head;

        if (head == null)
            return null;
        else {
            elems.append("[");
            while (true) {
                if (current.next() == null) {
                    elems.append(current.getElem());
                    break;
                }
                elems.append(current.getElem()).append(", ");
                current = current.next();
            }
            elems.append("]");
        }
        return elems.toString();
    }
}