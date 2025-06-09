package LogisticProses;

import java.time.LocalDate;

public class ReturnBarang {
    private String returnId;
    private String reason;
    private LocalDate dateReturned;

    public ReturnBarang(String returnId, String reason, LocalDate dateReturned) {
        this.returnId = returnId;
        this.reason = reason;
        this.dateReturned = dateReturned;
    }

    public void processReturn() {
        System.out.println("Return processed: " + returnId);
    }

    public String getReturnInfo() {
        return "Return ID: " + returnId + ", Reason: " + reason + ", Date: " + dateReturned;
    }
}