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

        for(int i=0; i < elements.length; i++)
            tempArr[arr.length+i] = elements[i];
        return tempArr;
    }

    /**
     * Compare arrays to see if they contain and single string that is the same
     * Return true if they do
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean hasSameString(String[] arr1, String[] arr2)throws Exception{
        try{
            for(String str1: arr1){
                for(String str2: arr2){
                    if(str1.equals(str2)){
                        return true;
                    }
                }
            }
        } catch(Exception ex){}
        return false;
    }
}
