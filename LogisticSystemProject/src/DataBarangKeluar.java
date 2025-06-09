package Storage;

import java.time.LocalDate;

public class DataBarangKeluar {
    private String itemCode;
    private int quantityOut;
    private LocalDate dateOut;

    public DataBarangKeluar(String itemCode, int quantityOut, LocalDate dateOut) {
        this.itemCode = itemCode;
        this.quantityOut = quantityOut;
        this.dateOut = dateOut;
    }

    public void recordOut() {
        System.out.println("Item Keluar: " + itemCode + ", Qty: " + quantityOut);
    }

    public String getOutDetails() {
        return "Keluar: " + itemCode + " - " + quantityOut + " on " + dateOut;
    }
}