package Data_struct;
import java.util.Arrays;

public class Dynamic_array<Data> {
    private Object[] list;

    @SuppressWarnings("unchecked")
    public Dynamic_array(Data ... items) {
        this.list = new Object[0];
        for (Data item : items) {
            add(item);
        }
    }

    public void add(Data item) {
        Object[] temp = Arrays.copyOf(list, list.length + 1);
        temp[temp.length - 1] = item;
        list = temp;
    }

    public void remove(int index) {
        Object[] temp = new Object[list.length - 1];
        
        int auxiliar = 0;
        for (int i = 0; i < list.length; i++){
            if (i == index) continue;
            temp[auxiliar] = list[i];
            auxiliar++;
        }
        list = temp;
    }

    public int indexOf(Data item) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return list.length;
    }
    

    public boolean contains(Data item) {
        return indexOf(item) != -1;
    }

    @SuppressWarnings("unchecked")
    public Data[] get() {
        return (Data[]) list;
    } 

    @SuppressWarnings("unchecked")
    public Data get(int index) {
        if (list.length <= index ) return null;
        return (Data) list[index];
    }

    public String toString() {
        return Arrays.toString(list);
    }

    public boolean isEmpty() {
        return list.length == 0;
    }

    public static void main(String[] args) {
        testAdd();
        testRemove();
        testIndexOf();
        testSize();
        testContains();
        testGet();
        printable();
        testIsEmpty();

        /* 
        // isso é bizarro, n sei o motivo de funcionar assim
        Dynamic_array<String> lista = new Dynamic_array<String>("1", "2", "3", "4", "5");
        System.out.println(Arrays.toString(lista.get()));
        System.out.println(lista.get());
        System.out.println(lista);
        */
    }

    private static void testAdd() {
        Dynamic_array<String> list = new Dynamic_array<String>("1", "2", "3", "4", "5");
        list.add("6");
        String[] expected = {"1", "2", "3", "4", "5", "6"};
        System.out.println("Add Test: " + Arrays.equals(expected, list.get()));
    }

    private static void testRemove() {
        Dynamic_array<String> list = new Dynamic_array<String>("1", "2", "3", "4", "5");
        list.remove(2);
        String[] expected = {"1", "2", "4", "5"};
        System.out.println("Remove Test: " + Arrays.equals(expected, list.get()));
    }

    private static void testIndexOf() {
        Dynamic_array<String> list = new Dynamic_array<String>("1", "2", "3", "4", "5");
        int index = list.indexOf("4");
        System.out.println("IndexOf Test: " + (index == 3));
    }

    private static void testSize() {
        Dynamic_array<String> list = new Dynamic_array<String>("1", "2", "3", "4", "5");
        int size = list.size();
        System.out.println("Size Test: " + (size == 5));
    }
    private static void testContains() {
        Dynamic_array<String> list = new Dynamic_array<String>("1", "2", "3", "4", "5");
        boolean contains = list.contains("4");
        System.out.println("Contains Test: " + contains);
    }

    private static void testGet() {
        Dynamic_array<String> list = new Dynamic_array<String>("1", "2", "3", "4", "5");
        String item = list.get(2);
        String[] expected = {"1", "2", "3", "4", "5"};
        System.out.println("Get Test: " + (item.equals("3") && Arrays.equals(list.get(), expected)));
    }

    private static void printable(){
        Dynamic_array<String> list = new Dynamic_array<String>("1", "2", "3", "4", "5");
        String expcted = "[1, 2, 3, 4, 5]";
        System.out.println("Printable Test: " +  (list.toString().equals(expcted)));
    }

    private static void testIsEmpty() {
        Dynamic_array<String> list = new Dynamic_array<String>();
        boolean isEmpty = list.isEmpty();
        System.out.println("IsEmpty Test: " + isEmpty);
    }
}
