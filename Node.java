package SortedListP;

public interface Node<E> {

    /**
     * Links this node to another one
     * @param node node to be linked to this one
     */
    void link(Node<E> node);

    /**
     * Obtains the element on the node
     * @return element on the node
     */
    E getElem();

    /**
     * Obtains the linked node
     * @return linked node
     */
    Node<E> next();
}
