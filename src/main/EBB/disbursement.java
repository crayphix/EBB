package main.EBB;
import java.util.Date;
/**
 * Disbursement object that tracks the following fields
 *  - Amount dispersed from funder
 *  - Date disbursed
 *  - Funder Id
 *  - unique Id
 */
public class disbursement {
    private int disAmt;
    private int funderId;
    private Date disDate;
    private int id;

    public disbursement(){}

    public disbursement(int disAmt, int funderId, Date disDate, int id) {
        this.disAmt = disAmt;
        this.funderId = funderId;
        this.disDate = disDate;
        this.id = id;
    }

    public int getDisAmt() {
        return disAmt;
    }

    public void setDisAmt(int disAmt) {
        this.disAmt = disAmt;
    }

    public int getFunderId() {
        return funderId;
    }

    public void setFunderId(int funderId) {
        this.funderId = funderId;
    }

    public Date getDisDate() {
        return disDate;
    }

    public void setDisDate(Date disDate) {
        this.disDate = disDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ("funderId: " + funderId + '\n' +
                " disbursement amount: " + disAmt + '\n' +
                " disbursement date: " + disDate + '\n' +
                " disbursement id: " + id);
    }
}
