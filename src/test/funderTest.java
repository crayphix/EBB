package test;

import main.EBB.disbursement;
import main.EBB.expense;
import main.EBB.funder;
import org.junit.Assert;
import org.junit.Test;
import java.util.Date;
import static main.EBB.BudgetHelper.makeDate;

public class funderTest {
    @Test public void setName(){
        funder funder1 = new funder("funder1", 1, makeDate("2019-03-02"));
        funder1.setName("funder2");
        Assert.assertEquals("funder2", funder1.getName());
    }

    @Test public void getName(){
        funder funder1 = new funder("funder1", 1, makeDate("2019-03-02"));
        Assert.assertEquals("funder1", funder1.getName());
    }

    @Test public void getId() {
        funder funder1 = new funder("funder1",1, makeDate("2019-03-02"));
        Assert.assertEquals(funder1.getId(), 1); }

    @Test public void setId() {
        funder funder1 = new funder("funder1",1, makeDate("2019-03-02"));
        funder1.setId(2);
        Assert.assertEquals(funder1.getId(), 2); }

    @Test public void getCurrentFundTotal() {
        //Funder test object
        funder funder1 = new funder("funder1",1, makeDate("2019-03-02"));

        //Disbursement test list
        disbursement[] disbursements = new disbursement[]{
                new disbursement(500, 1, makeDate("2019-01-01"), 1),
                new disbursement(500, 3, makeDate("2019-01-05"), 2),
                new disbursement(500, 1, makeDate("2019-03-01"), 3)
        };
        int expected = 1000;
        int actual = funder1.getCurrentFundTotal(disbursements);
        Assert.assertEquals(expected, actual);
    }

    @Test public void getFundsCommitted() throws Exception { //TODO
        //Setup arrays
        String[] catRestrictions = new String[]{"Cat1", "Cat2"};
        String[] categories1 = new String[]{"Cat2", "Cat3"};
        String[] categories2 = new String[]{"Cat4", "Cat5"};

        //Initialize funder
        funder funder1 = new funder("funder1", 1, makeDate("2019-03-02"));
        funder1.setFundCatRestrictions(catRestrictions);

        //Initialize expense array
        expense[] expenses = new expense[]{
            //Scenario: has cat restriction
            new expense("expense1", 1, 220, categories1, makeDate("2019-01-01"), 1),
            //Scenario: not a match for funder
            new expense("expense2", 2, 220, categories2, makeDate("2019-01-01"), 1),
            //Scenario: meets criteria
            new expense("expense3", 1, 220, categories2, makeDate("2019-01-01"), 1),
            //Scenario: falls outside of funder date state
            new expense("expense4", 1, 220, categories2, makeDate("2019-05-01"), 1)
        };

        //get funds committed
        int expected = 220;
        int actual = funder1.getFundsCommitted(expenses);
        Assert.assertEquals(expected, actual);
    }

    @Test public void getFundCatRestrictions() {
        funder funder1 = new funder("funder1",1, makeDate("2019-03-02"));
        String[] catRestrictions = new String[]{"Cat1", "Cat2"};
        funder1.setFundCatRestrictions(catRestrictions);
        String expected = "Cat1, Cat2";
        String actual = String.join(", ", funder1.getFundCatRestrictions());
        Assert.assertEquals(expected, actual);
    }

    @Test public void setFundCatRestrictions() {
        funder funder1 = new funder("funder1",1, makeDate("2019-03-02"));
        String[] catRestrictions = new String[]{"Cat2", "Cat3"};
        funder1.setFundCatRestrictions(catRestrictions);
        String expected = "Cat2, Cat3";
        String actual = String.join(", ", funder1.getFundCatRestrictions());
        Assert.assertEquals(expected, actual);
    }

    @Test public void addFundCatRestrictions() {
        funder funder1 = new funder("funder1", 1, makeDate("2019-03-02"));

        String[] catRestrictions = new String[]{"Cat2", "Cat3"};
        funder1.setFundCatRestrictions(catRestrictions);

        funder1.addFundCatRestrictions("Cat4");
        String[] actual = funder1.getFundCatRestrictions();

        Assert.assertEquals("Cat4", actual[2]);
    }

    @Test public void getFundsAvail() throws Exception {
        //Setup arrays
        String[] catRestrictions = new String[]{"Cat1", "Cat2"};
        String[] categories1 = new String[]{"Cat2", "Cat3"};
        String[] categories2 = new String[]{"Cat4", "Cat5"};

        //Initialize funder
        funder funder1 = new funder("funder1", 1, makeDate("2019-03-02"));
        funder1.setFundCatRestrictions(catRestrictions);

        //Disbursement test list
        disbursement[] disbursements = new disbursement[]{
                new disbursement(500, 1, makeDate("2019-01-01"), 1),
                new disbursement(500, 3, makeDate("2019-01-05"), 2),
                new disbursement(500, 1, makeDate("2019-03-01"), 3)
        };

        //Initialize expense array
        expense[] expenses = new expense[]{
                //Scenario: has cat restriction
                new expense("expense1", 1, 220, categories1, makeDate("2019-01-01"), 1),
                //Scenario: not a match for funder
                new expense("expense2", 2, 220, categories2, makeDate("2019-01-01"), 1),
                //Scenario: meets criteria
                new expense("expense3", 1, 220, categories2, makeDate("2019-01-01"), 1),
                //Scenario: falls outside of funder date state
                new expense("expense4", 1, 220, categories2, makeDate("2019-05-01"), 1)
        };

        int expected = 780;
        int actual = funder1.getFundsAvail(expenses,disbursements);

        Assert.assertEquals(expected, actual);
    }

    @Test public void getState() {
        funder funder1 = new funder("funder1",1, makeDate("2019-03-02"));
        Date expected = makeDate("2019-03-02");
        Assert.assertEquals(funder1.getState(), expected);
    }

    @Test public void setState() {
        funder funder1 = new funder("funder1",1, makeDate("2019-03-02"));
        funder1.setState(makeDate("2019-03-03"));
        Date expected = makeDate("2019-03-03");
        Assert.assertEquals(funder1.getState(), expected);
    }

    @Test public void testToString() {
        funder funder = new funder("funder1",1, makeDate("2019-03-02"));;
        String[] catRestrictions = new String[]{"Cat1", "Cat2"};
        funder.setFundCatRestrictions(catRestrictions);
        String expected = "funder name: funder1 | funding Category Restrictions: " +
                "Cat1, Cat2 | date state: Sat Mar 02 00:00:00 EST 2019 | id: 1";
        Assert.assertEquals(expected, funder.toString());
    }
}