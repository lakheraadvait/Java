import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class v_ArrayLists {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Tomato");
        list.add("Orange");
        list.add("Apple");
        list.remove(0);

        Collections.sort(list, Collections.reverseOrder());
    }
}
