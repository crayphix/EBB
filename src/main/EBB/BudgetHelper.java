package main.EBB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Budget functions for data referencing
 */
public class BudgetHelper {
    /**
     * Parse string into date object
     * Pattern: "yyyy-MM-dd"
     * @param sDate
     * @return
     */
    public static Date makeDate(String sDate){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = fmt.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * This method will add elements to an array and return the resulting array
     * @param arr
     * @param elements
     * @return
     */
    public static String[] add(String[] arr, String... elements){
        String[] tempArr = new String[arr.length+elements.length];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);

        System.arraycopy(elements, 0, tempArr, arr.length, elements.length);
        return tempArr;
    }

    /**
     * Compare arrays to see if they contain and single string that is the same
     * Return true if they do
     * @param str
     * @param arr
     * @return
     */
    public static boolean containsString(String str, String[] arr){
        try{
            for(String str2: arr){
                    if(str2.equals(str)){
                        return true;
                    }
                }
            }catch(Exception ex){ex.printStackTrace();}
        return false;
    }
}
