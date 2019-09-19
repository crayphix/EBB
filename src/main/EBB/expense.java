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
    private String[] fundCats;
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
     * @param fundCats
     * @param expDate
     * @param id
     */
    public expense(String name, int funderId, int expAmt, String[] fundCats, Date expDate, int id) {
        this.name = name;
        this.funderId = funderId;
        this.expAmt = expAmt;
        this.fundCats = fundCats;
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
    public String[] getFundCat() { return fundCats; }

    /**
     * set funding category(s) of expense
     * @param fundCats
     */
    public void setFundCat(String[] fundCats) { this.fundCats = fundCats; }

    /**
     * Add funding category funding categories array
     * @param fundcat
     */
    public void addFundCat(String fundcat){this.fundCats = add(fundCats, fundcat); }

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
       return ("expense name: " + name + '\n' +
                " funderId: " + funderId + '\n' +
                " expense amount: " + expAmt + '\n' +
                " funding Categories: " + String.join(", ", fundCats) + '\n' +
                " expense date: " + expDate + '\n' +
                " expense id: " + id);
    }
}
