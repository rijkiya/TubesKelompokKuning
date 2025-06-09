package LogisticProses;

public class ReceiverBarang {
    private String receiverId;
    private String receiverName;

    public ReceiverBarang(String receiverId, String receiverName) {
        this.receiverId = receiverId;
        this.receiverName = receiverName;
    }

    public void confirmReception() {
        System.out.println("Barang diterima oleh: " + receiverName);
    }

    public String getReceiverInfo() {
        return "Receiver ID: " + receiverId + ", Name: " + receiverName;
    }
}