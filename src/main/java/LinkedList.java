import java.util.ArrayList;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        if (this.head == null)
            return false;

        if (this.head.value == _value) {
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
            return true;
        }

        Node prev = this.head;
        Node curr = this.head.next;
        while (curr != null) {
            if (curr.value == _value) {
                prev.next = curr.next;
                if (curr == this.tail)
                    this.tail = prev;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }

        return false;

    }

    public void removeAll(int _value)
    {
        if (this.head == null) {
            return;
        }

        while (this.head != null && this.head.value == _value) {
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
        }

        if (this.head == null) {
            return;
        }

        Node prev = this.head;
        Node curr = this.head.next;

        while (curr != null) {
            if (curr.value == _value) {
                prev.next = curr.next;
                if (curr == this.tail)
                    this.tail = prev;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

    }

    public void clear()
    {
        head = null;
        tail = null;
    }

    public int count()
    {
        int count = 0;
        Node node = this.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }


    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeToInsert == null) {
            return;
        }

        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            if (this.tail == null) {
                this.tail = _nodeToInsert;
            }
            return;
        }

        Node node = this.head;
        while (node != null) {
            if (node == _nodeAfter) {
                _nodeToInsert.next = node.next;
                _nodeAfter.next = _nodeToInsert;

                if (node == this.tail) {
                    this.tail = _nodeToInsert;
                }
                return;
            }
            node = node.next;
        }

    }

}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}

