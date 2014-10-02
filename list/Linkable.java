package list;
/**
 * Objects that need to be managed through the SimpleLinkedList must extend this
 * class.
 * 
 * @author Dibyendu Majumdar
 * @since 06 Jan 2007
 */
 abstract class Linkable {

    Linkable next;

    Linkable prev;

    /**
     * Notes that the element is a member of a list.
     */
    Object owner;

    Linkable getNext() {
        return next;
    }

    void setNext(Linkable link) {
        next = link;
    }

    Linkable getPrev() {
        return prev;
    }

    void setPrev(Linkable link) {
        prev = link;
    }

    public final boolean isMemberOf(SimpleLinkedList<? extends Linkable> list) {
        return this.owner == list;
    }

    final void setOwner(SimpleLinkedList<? extends Linkable> list) {
        this.owner = list;
    }
}