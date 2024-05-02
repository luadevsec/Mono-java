package Data_struct;
import java.util.ArrayList;
import Data_struct.Dynamic_array;
import Node.GenericNode_2;

public class Index_Linkedlist<D> {
    private Dynamic_array<GenericNode_2<D>> nodes;

    @SuppressWarnings("unchecked")
    public Index_Linkedlist() {
        this.nodes = new Dynamic_array<GenericNode_2<D>>();
    }
    @SuppressWarnings("unchecked")
    public Index_Linkedlist(GenericNode_2<D> ... nodes) {
        this.nodes = new Dynamic_array<GenericNode_2<D>>();
        add(nodes);
    }
    @SuppressWarnings("unchecked")
    public Index_Linkedlist(D ... data) {
        this.nodes = new Dynamic_array<GenericNode_2<D>>();
        add(data);
    }

    public void add(GenericNode_2<D> node) {
        if (nodes.isEmpty()) {
            nodes.add(node);
            return;
        }
        tail().next(node);
        node.previous(tail());
        nodes.add(node);
    }

    public void add(D data) {
        add(new GenericNode_2<>(data));
    }

    @SuppressWarnings("unchecked")
    public void add(D ... data) {
        for (D item : data) {
            add(item);
        }
    }

    @SuppressWarnings("unchecked")
    public void add(GenericNode_2<D> ... nodes) {
        for (GenericNode_2<D> node : nodes) {
            add(node);
        }
    }

    public GenericNode_2<D> head() {
        if (nodes.isEmpty()) return null;
        return nodes.get(0);
    }

    public GenericNode_2<D> tail() {
        if (nodes.isEmpty()) return null;
        return nodes.get(nodes.size() - 1);
    }

    public void remove(int index) {
        if (nodes.isEmpty()) return;
        GenericNode_2<D> target = get(index);
        nodes.remove(index);
        if (target == head().previous()) {
            head().previous(null);
            return;
        }
        if (target == tail().next()){
            tail().next(null);
            return;
        }
        target.previous().next(target.next());
        target.next().previous(target.previous());
    }

    public void remove(int index, boolean safes) {
        if (nodes.isEmpty()) return;
        if (index < 0 || index >= nodes.size()) return;

        if (safes) get(index).data(null);
        remove(index);
    }


    public GenericNode_2<D>[] get() {
        return nodes.get();
    }
    public GenericNode_2<D> get(int index) {
        return nodes.get(index);
    }

    @SuppressWarnings("unchecked")
    public Dynamic_array<D> getValues(){
        Dynamic_array<D> values = new Dynamic_array<D>();
        for (int i = 0; i < nodes.size(); i++) {
           values.add(nodes.get(i).data());
        }
        return values;
    }

    public D getValueOf(int index) {
        return nodes.get(index).data();
    }

    public int size() {
        return nodes.size();
    }

    public int indexOf(GenericNode_2<D> node) {
        return nodes.indexOf(node);
    }

    public int indexOf(D data) {
        return nodes.indexOf(new GenericNode_2<D>(data));
    }

    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    public boolean testDeIntegridade() {
        if (nodes.size() == 0) 
            return head() == null && tail() == null;
        boolean teste = true;
        GenericNode_2<D> pointer = head();
        int i = 0;
        while (teste) {
            i++;
            if (pointer.next() == null) {
                teste = false;
            }
            pointer = pointer.next();
        }
        boolean testHeadToTail = i == nodes.size();

        teste = true;
        i = 0;
        pointer = tail();
        while (teste) {
            i++;
            if (pointer.previous() == null) {
                teste = false;
            }
            pointer = pointer.previous();
            
        }
        boolean testTailToHead = i == nodes.size();
        return testHeadToTail && testTailToHead;
    }


    
    public static void main(String[] args) {
        testAdd();
        testRemove();
        testRemoveSafe();
        testgetValueOf();
        testSize();
        testHeadTail();
        testIsEmpty();
        
    }

    private static void testAdd() {
        Index_Linkedlist<String> list = new Index_Linkedlist<String>("a", "b", "c", "d");
        list.add("e");
        String expected = "[a, b, c, d, e]";
        System.out.println("Add Test: " + (list.getValues().toString().equals(expected) && list.testDeIntegridade()));
    }

    private static void testRemove() {
        Index_Linkedlist<String> list = new Index_Linkedlist<String>("a", "b", "c", "d", "e");
        list.remove(2);
        String expected = "[a, b, d, e]";
        boolean test1 = list.getValues().toString().equals(expected);
        list.remove(0);
        expected = "[b, d, e]";
        boolean test2 = list.getValues().toString().equals(expected);
        list.remove(2);
        expected = "[b, d]";
        boolean test3 = list.getValues().toString().equals(expected);
        
        System.out.println("Remove Test: " + (test1 && test2 && test3 && list.testDeIntegridade()));
    }

    private static void testRemoveSafe(){
        Index_Linkedlist<String> list = new Index_Linkedlist<String>("a", "b", "c", "d", "e");
        GenericNode_2<String> target = list.get(2);
        list.remove(2, true);
        boolean test1 = (target.data() == null);

        target = list.get(0);
        list.remove(0, false);
        boolean test2 = target.data().equals("a");
        System.out.println("RemoveSafe Test: " + (test1 && test2 && list.testDeIntegridade()));
    }

    private static void testgetValueOf() {
        Index_Linkedlist<String> list = new Index_Linkedlist<String>("a", "b", "c", "d", "e");
        String expected = "c";
        System.out.println("getValueOf Test: " + list.getValueOf(2).equals(expected));
    }

    private static void testSize() {
        Index_Linkedlist<String> list = new Index_Linkedlist<String>("a", "b", "c", "d", "e");
        int size = list.size();
        System.out.println("Size Test: " + (size == 5));
    }

    private static void testHeadTail(){
        Index_Linkedlist<String> list = new Index_Linkedlist<String>("a", "b", "c", "d", "e");
        String expectedHead = "a";
        String expectedTail = "e";
        boolean headTest1 = list.head().data().equals(expectedHead);
        boolean tailTest1 = list.tail().data().equals(expectedTail);
        expectedHead = "b";
        expectedTail = "d";
        list.remove(list.indexOf(list.head()));
        list.remove(list.indexOf(list.tail()));
        boolean headTest2 = list.head().data().equals(expectedHead);
        boolean tailTest2 = list.tail().data().equals(expectedTail);
        System.out.println("Head Test: " + (headTest1 && headTest2));
        System.out.println("Tail Test: " + (tailTest1 && tailTest2));



    }

    private static void testIsEmpty() {
        Index_Linkedlist<String> list = new Index_Linkedlist<String>();
        boolean isEmpty = list.isEmpty();
        System.out.println("IsEmpty Test: " + (isEmpty && (list.size() == 0) && list.testDeIntegridade()));
    }


}
