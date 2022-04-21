package com.example.dorainformation.ui.theme;


// Given two arrays: a, b
// Return an array containing strings that appear in either one of the input array but not both


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AakarshaTest
{

    public void test()
    {
        String[] input1_a = new String[] {"Abc", "lmn", "xyz"};
        String[] input1_b = new String[] {"pqr", "stc", "iug"};
        String[] expectedResult1 = new String[]{"Abc", "lmn", "xyz", "pqr", "stc", "iug"};
        String[] result1 = getDifference(input1_a, input1_b);
        test("Unique values in an array",result1, expectedResult1);

        String[] input2_a = new String[] {"Abc", "lmn", "xyz"};
        String[] input2_b = new String[] {"Abc", "stc", "iug"};
        String[] expectedResult2 = new String[]{"lmn", "xyz", "stc", "iug"};
        String[] result2 = getDifference(input2_a, input2_b);
        test("Removal of item from an array",result2, expectedResult2);

        String[] input3_a = new String[] {"Abc", "lmn", "xyz"};
        String[] input3_b = new String[] {"Abc", "stc", "iug"};
        String[] expectedResult3 = new String[]{"lmn", "xyz", "stc"};
        String[] result3 = getDifference(input3_a, input3_b);
        test("Failing test:  ",result3, expectedResult3);
    }


    private void test(String testcaseName, String[] result, String[] expectedResult) {
        Arrays.sort(result);
        Arrays.sort(expectedResult);

        Boolean res = Arrays.equals(result, expectedResult);
        if (res) {
            System.out.println(testcaseName + ": Pass");
        } else {
            System.out.println(testcaseName + ": Fail");
        }
    }


    private String[] getDifference(String[] s1, String[] s2) {
        Set<String> set1 = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();

        for (String s : s1) {
            set1.add(s);
        }

        Set<String> set2 = new HashSet<>();
        for (String s : s2) {
            set2.add(s);
        }

        for(String s : set1) {
            if (!set2.contains(s)) {
                result.add(s);
            }
        }

        for(String s : set2) {
            if (!set1.contains(s)) {
                result.add(s);
            }
        }

        return result.toArray(new String[0]);
    }

}