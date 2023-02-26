/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package MainFlow;

import Function.GetData;
import java.util.Date;

/**
 *
 * @author duy20
 */
public class Main {
    public static void main(String[] args) {
        //Step 1: User enter the first date with [dd/mm/yyyy] format
        Date firstDate = GetData.getDateWith_dd_mm_yyyy_Format("first");
        //Step 2: User enter second date with [dd/mm/yyyy] format
        Date secondDate = GetData.getDateWith_dd_mm_yyyy_Format("second");
        //Step 3: Get result of compare two date
        String result = GetData.getResultOfCompareTwoDate(firstDate, secondDate);
        //Step 4: Display the result
        GetData.display(result);
    }
}























