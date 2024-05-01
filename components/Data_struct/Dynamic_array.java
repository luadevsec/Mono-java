package Data_struct;
import java.util.Arrays;

public class Dynamic_array {
    private int[] list = {};

    public Dynamic_array(int ... items) {
        for (int item : items) {
            add(item);
        }
    }

    public void add(int item) {
        int[] temp = Arrays.copyOf(list, list.length + 1);
        temp[temp.length - 1] = item;
        list = temp;
    }

    public void remove(int index) {
        int[] temp = new int[list.length - 1];
        
        int auxiliar = 0;
        for (int i = 0; i < list.length; i++){
            if (i == index) continue; //fail first
            temp[auxiliar] = list[i];
            auxiliar++;
        }
        list = temp;
    }

    public int indexOf(int item) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public int[] get() {
        return list;
    }
    public int get(int index) {
        if (list.length <= index ) return -1; // fail first
        return list[index];
    }
    

    public static void main(String[] args) {
        
        Dynamic_array list = new Dynamic_array(1, 2, 3, 4, 5);
        System.out.println(Arrays.toString(list.get()));
        list.add(6);
        System.out.println(Arrays.toString(list.get()));
        list.remove(2);
        System.out.println(Arrays.toString(list.get()));
        System.out.println(list.indexOf(4));
        System.out.println(list.get(list.indexOf(4)));
        System.out.println(list.contains(4));

    }
}
