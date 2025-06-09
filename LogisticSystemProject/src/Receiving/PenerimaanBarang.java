package Receiving;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PenerimaanBarang extends Receiving {
    private List<String> itemList;
    private int totalItems;

    public PenerimaanBarang(String receivingId, LocalDate date, String supplierName) {
        super(receivingId, date, supplierName);
        this.itemList = new ArrayList<>();
        this.totalItems = 0;
    }

    public void addItem(String item) {
        itemList.add(item);
        totalItems++;
    }

    public List<String> getItemList() {
        return itemList;
    }

    public int getTotalItems() {
        return totalItems;
    }
}