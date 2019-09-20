package main.EBB;
import java.util.Date;

import static main.EBB.BudgetHelper.add;

/**
 * Expense object that tracks the following fields
 *  - Funder Id
 *  - Expense Amount
 *  - Fund Category
 *  - Expense Date
 *  - unique Id
 */
public class expense {
    private String name;
    private int funderId;
    private int expAmt;
    private String category;
    private Date expDate;
    private int id;

    /**
     * Default Constructor
     */
    public expense(){}

    /**
     * Args Constructor
     * @param name
     * @param funderId
     * @param expAmt
     * @param category
     * @param expDate
     * @param id
     */
    public expense(String name, int funderId, int expAmt, String category, Date expDate, int id) {
        this.name = name;
        this.funderId = funderId;
        this.expAmt = expAmt;
        this.category = category;
        this.expDate = expDate;
        this.id = id;
    }

    /**
     * Return Expense name
     * @return
     */
    public String getName() { return name; }

    /**
     * Set Expense Name
     * @param name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Return FunderID associated with expense
     * @return
     */
    public int getFunderId() { return funderId; }

    /**
     * Set FunderID associated with expense
     * @param funderId
     */
    public void setFunderId(int funderId) { this.funderId = funderId; }

    /**
     * Return Expense amount
     * @return
     */
    public int getExpAmt() { return expAmt; }

    /**
     * Set Expense Amount
     * @param expAmt
     */
    public void setExpAmt(int expAmt) { this.expAmt = expAmt; }

    /**
     * return funding category of expense
     * @return
     */
    public String getCategory() { return category; }

    /**
     * set funding category(s) of expense
     * @param category
     */
    public void setCategory(String category) { this.category = category; }

    /**
     * Return date expense is posted
     * @return
     */
    public Date getExpDate() { return expDate; }

    /**
     * Set date expense is posted
     * @param expDate
     */
    public void setExpDate(Date expDate) { this.expDate = expDate; }

    /**
     * return expense id
     * @return
     */
    public int getId() { return id; }

    /**
     * Set Expense Id
     * @param id
     */
    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
       return ("expense name: " + name +
                " funderId: " + funderId +
                " expense amount: " + expAmt +
                " funding Category: " + category +
                " expense date: " + expDate +
                " expense id: " + id);
    }
}
