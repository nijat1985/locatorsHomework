package com.locatorsHomework.utilities;

public class StringUtility {
    public static void verifyContains(String checkInsideThis, String checkThis){
        if (checkInsideThis.contains(checkThis)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("checkThis = " + checkThis);
            System.out.println("checkInsideThis = " + checkInsideThis);
        }

    }

    public static void verifyEndsWith(String checkInsideThis, String checkThis){
        if (checkInsideThis.endsWith(checkThis)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("checkThis = " + checkThis);
            System.out.println("checkInsideThis = " + checkInsideThis);
        }

    }

    public static void verifyEquals(String str1, String str2){
        if (str1.equals(str2)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("str1 = " + str1);
            System.out.println("str2 = " + str2);
        }

    }

}
