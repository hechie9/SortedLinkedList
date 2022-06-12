package SpawnList;

public class NodeClass<E> implements Node<E> {

    private E elem;
    private Node<E> nextNode;

    /**
     * Constructor from class NodeClass
     * @param elem element to be added on the node
     */
    public NodeClass(E elem) {
        this.elem = elem;
        this.nextNode = null;
    }

    /**
     * Links this node to another one
     * @param node node to be linked to this one
     */
    @Override
    public void link(Node<E> node) {
        nextNode = node;
    }

    /**
     * Obtains the element on the node
     * @return element on the node
     */
    @Override
    public E getElem() {
        return elem;
    }

    /**
     * Obtains the linked node
     * @return linked node
     */
    @Override
    public Node<E> next() {
        return nextNode;
    }
}
