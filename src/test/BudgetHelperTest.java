package test;

import main.EBB.expense;
import main.EBB.funder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static main.EBB.BudgetHelper.*;

public class BudgetHelperTest {

    @Test public void testMakeDate() {
        Date date1 = makeDate("2019-01-01");
        Assert.assertNotNull(date1);
    }

    @Test public void testAdd() {
        String[] arr = new String[]{"test1", "test2"};
        String str = "test3";
        arr = add(arr,str);
        Assert.assertEquals("test3",arr[2]);
    }

    @Test public void testContainsString() {
        //Setup arrays
        String[] catRestrictions = new String[]{"Cat1", "Cat2"};
        String category = "Cat2";

        //Initialize funder
        funder funder1 = new funder("funder1",1, makeDate("2019-03-02"));
        funder1.setFundCatRestrictions(catRestrictions);

        //Initialize expense
        expense expense1 = new expense("expense1", 1, 220, category, makeDate("2019-01-01"), 1);

        //Compare
        try {
            boolean actual = containsString(expense1.getCategory(), funder1.getFundCatRestrictions());
            Assert.assertTrue(actual);
        }catch(Exception ex){System.out.println("Contains String error");}
    }
}