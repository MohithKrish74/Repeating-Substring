package com.keyword;

import java.util.*;

public class RepeatingSubstring {


    String[] stringList = new String[1000];
    ArrayList<String> wordList = new ArrayList<String>();


    RepeatingSubstring(String[] stringList) {
        this.stringList = stringList;
    }

    public void getStrings(String str)
    {
        for(int i = 0 ;i < str.length(); i++)
        {
            for(int j = str.length()-1; j > i; j--)
            {
                if(checkString(str.substring(i,j+1)) )
                {
                    wordList.add(str.substring(i,j+1).toLowerCase());
                }
            }
        }
    }


    public Boolean checkString(String temp)
    {
        int count = 0;
        for(String word : this.stringList)
        {
            for(int k = 0; k < word.length() - temp.length() + 1; k++)
            {
                if(word.substring(k, k + temp.length() ).toLowerCase().equals(temp.toLowerCase()))
                {
                    count += 1;
                }
                if(count > 1 )
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void clearDuplicates ()
    {
        ArrayList<String> temp = new ArrayList<String>();
        for(String str : new HashSet<String>(wordList))
        {
            Boolean flag = true;
            for(String subCheck: wordList)
            {
                if(subCheck.contains(str) && subCheck.equals(str) == false)
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                temp.add(str);
            }
        }
        wordList = temp;

    }

    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the sentence: ");
        String[] string = { in.nextLine() };
        RepeatingSubstring obj = new RepeatingSubstring(string);
        obj.getStrings(string[0]);
        obj.clearDuplicates();
        if(obj.wordList.size() > 0)
        {
            System.out.println(obj.wordList);
        }
        else
        {
            System.out.println("none");
        }


    }

}

