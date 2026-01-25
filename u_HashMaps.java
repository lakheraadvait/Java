import java.util.HashMap;

class u_HashMaps {
    public static void main(String[] args) {
        HashMap<String, Double> map = new HashMap();
        map.put("apple", 1.5);
        map.put("banana", 1.0);
        map.remove("banana");
        System.out.println(map.get("apple"));
        System.out.println(map.containsKey("banana"));
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map);
    }
}
