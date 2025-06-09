package LogisticProses;

import java.time.LocalDateTime;

public class ShipmentStatus {
    private String shipmentId;
    private String status;
    private LocalDateTime lastUpdate;

    public ShipmentStatus(String shipmentId, String status, LocalDateTime lastUpdate) {
        this.shipmentId = shipmentId;
        this.status = status;
        this.lastUpdate = lastUpdate;
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        this.lastUpdate = LocalDateTime.now();
    }

    public String getStatus() {
        return "Shipment " + shipmentId + " status: " + status + " (Last update: " + lastUpdate + ")";
    }
}