package Storage;

import java.time.LocalDate;

public class DataBarangMasuk {
    private String itemCode;
    private int quantityIn;
    private LocalDate dateIn;

    public DataBarangMasuk(String itemCode, int quantityIn, LocalDate dateIn) {
        this.itemCode = itemCode;
        this.quantityIn = quantityIn;
        this.dateIn = dateIn;
    }

    public void recordIn() {
        System.out.println("Item Masuk: " + itemCode + ", Qty: " + quantityIn);
    }

    public String getInDetails() {
        return "Masuk: " + itemCode + " - " + quantityIn + " on " + dateIn;
    }
}