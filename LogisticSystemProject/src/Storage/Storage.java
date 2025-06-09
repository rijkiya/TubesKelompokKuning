package Storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private String storageId;
    private String location;
    private int capacity;
    private Map<String, Integer> stock;

    public Storage(String storageId, String location, int capacity) {
        this.storageId = storageId;
        this.location = location;
        this.capacity = capacity;
        this.stock = new HashMap<>();
    }

    public void storeItem(String item, int qty) {
        stock.put(item, stock.getOrDefault(item, 0) + qty);
        System.out.println(qty + " " + item + " stored.");
    }

    public boolean checkAvailability(String item) {
        return stock.getOrDefault(item, 0) > 0;
    }

    public void printStorageReport() {
        System.out.println("Storage Report: " + stock.toString());
    }
}