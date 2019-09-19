package main.EBB;
import java.util.Date;

import static main.EBB.BudgetHelper.add;
import static main.EBB.BudgetHelper.hasSameString;

/**
 * Funder object that tracks the following fields
 *  - Total Funding amount
 *  - Funds Available
 *  - Funds Committed (Currently used)
 *  - Funding Restrictions
 *  - Unique Id
 *  - Date of funder state
 */
public class funder {
    private String name;
    private int id;
    private String[] fundCatRestrictions;
    private Date state;

    //Default Constructor
    public funder(){}

    /** Args Constructor*/
    public funder(String name, int id, Date state){
        this.name = name;
        this.id = id;
        this.state = state;
    }

    /**
     * return name of funder
     * @return
     */
    public String getName() { return name; }

    /**
     * set name of funder
     * @param name
     */
    public void setName(String name) { this.name = name; }

    /**
     * return Id of funder
     * @return
     */
    public int getId() { return id; }

    /**
     * set Id of funder
     * @param id
     */
    public void setId(int id) { this.id = id; }

    /**
     * Accept disbursement array and return current funds in funding pool
     * given the state of the funder
     * @param disbursements
     * @return
     */
    public int getCurrentFundTotal(disbursement[] disbursements) {
    int totalFundAmt = 0;
        for (disbursement disbursement: disbursements) {
            //add funds to funder if dispersed on or before funder state
            if (disbursement.getFunderId() == this.id &&
                    (disbursement.getDisDate().before(state) ||
                    disbursement.getDisDate().equals(state))) {
                totalFundAmt += disbursement.getDisAmt();
            }
        }
        return totalFundAmt;
    }

    /**
     * Add expenses applied to funder pool based on funder state
     * @return
     */
    public int getFundsCommitted(expense[] expenses) throws Exception {
        int fundsCommitted = 0;
        //add expenses to commited pool if by state of funder
        for (expense expense: expenses) {
            if (expense.getFunderId() == this.id &&
                    //check to see if categories restrict expense assignment
                    !hasSameString(expense.getFundCat(), this.fundCatRestrictions) &&
                    (expense.getExpDate().before(state) ||
                            expense.getExpDate().equals(state))) {
                fundsCommitted += expense.getExpAmt();
            }
        }
        return fundsCommitted;
    }

    /**
     * Return String array of Funding category restrictions
     * @return
     */
    public String[] getFundCatRestrictions() { return fundCatRestrictions; }

    /**
     * Set/overwrite funding category restrictions
     * @param fundRestrictions
     */
    public void setFundCatRestrictions(String[] fundRestrictions) {
        this.fundCatRestrictions = fundRestrictions;
    }

    /**
     * Accept new funding category restriction as a string and pass to
     * funding category restrictions array
     * @param fundRestriction
     */
    public void addFundCatRestrictions(String fundRestriction){
        this.fundCatRestrictions = add(fundCatRestrictions ,fundRestriction);
    }

    /**
     * Return funds available in funder pool
     * (total Funds Available - funds Committed)
     * @return
     */
    public int getFundsAvail(expense[] expenses, disbursement[] disbursements) throws Exception{
        return getCurrentFundTotal(disbursements) - getFundsCommitted(expenses);
    }

    /**
     * return date state of funder. This is key to understanding a time line of
     * expenses and distrobutions
     * @return
     */
    public Date getState() { return state; }

    /**
     * Set date state of funder
     * @param state
     */
    public void setState(Date state) { this.state = state; }

    @Override
    public String toString() {
        return ("funder name: " + name +
                " | funding Category Restrictions: " +
                    String.join(", ", fundCatRestrictions) +
                " | date state: " + state +
                " | id: " + id);
    }
}
