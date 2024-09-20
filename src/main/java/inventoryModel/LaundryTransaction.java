package inventoryModel;

import java.sql.Date;

public class LaundryTransaction {

    private int transactionId;
    private int towelQuantity;
    private int bedsheetQuantity;
    private int pillowcaseQuantity;
    private int blanketQuantity;
    private Date date;
    private String status;

    public LaundryTransaction() {
    }

    public LaundryTransaction(int transactionId, int towelQuantity, int bedsheetQuantity, int pillowcaseQuantity, int blanketQuantity, Date date, String status) {
        this.transactionId = transactionId;
        this.towelQuantity = towelQuantity;
        this.bedsheetQuantity = bedsheetQuantity;
        this.pillowcaseQuantity = pillowcaseQuantity;
        this.blanketQuantity = blanketQuantity;
        this.date = date;
        this.status = status;
    }

    public LaundryTransaction(int towelQuantity, int bedsheetQuantity, int pillowcaseQuantity, int blanketQuantity, Date date, String status) {
        this.towelQuantity = towelQuantity;
        this.bedsheetQuantity = bedsheetQuantity;
        this.pillowcaseQuantity = pillowcaseQuantity;
        this.blanketQuantity = blanketQuantity;
        this.date = date;
        this.status = status;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getTowelQuantity() {
        return towelQuantity;
    }

    public void setTowelQuantity(int towelQuantity) {
        this.towelQuantity = towelQuantity;
    }

    public int getBedsheetQuantity() {
        return bedsheetQuantity;
    }

    public void setBedsheetQuantity(int bedsheetQuantity) {
        this.bedsheetQuantity = bedsheetQuantity;
    }

    public int getPillowcaseQuantity() {
        return pillowcaseQuantity;
    }

    public void setPillowcaseQuantity(int pillowcaseQuantity) {
        this.pillowcaseQuantity = pillowcaseQuantity;
    }

    public int getBlanketQuantity() {
        return blanketQuantity;
    }

    public void setBlanketQuantity(int blanketQuantity) {
        this.blanketQuantity = blanketQuantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
