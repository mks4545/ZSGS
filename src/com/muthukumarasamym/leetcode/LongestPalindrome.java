package com.muthukumarasamym.leetcode;

import java.util.Scanner;

public class LongestPalindrome {

	public static void main(String[] args) {
		
		Scanner mc= new Scanner(System.in);
		System.out.print("Enter the string : ");
		String str =mc.nextLine();	
		
		LongestPalindrome l =new LongestPalindrome();
		System.out.println(l.longestPalindrome(str));
		
	}

	 public  String longestPalindrome(String s) {
	        if (s == null || s.length() < 1) {
	            return "";
	        }
	        int start = 0, end = 0;
	        
	        for (int i = 0; i < s.length(); i++) {
	            int len1 = expand(s, i, i);
	            int len2 = expand(s, i, i + 1);
	            int len = Math.max(len1, len2);
	            
	            
	            if (len > end - start) {
	                start = i - (len - 1) / 2;
	                end = i + len / 2;
	            }
	        }

	        return s.substring(start, end + 1);
	    }

	    private int expand(String s, int left, int right) {
	        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
	            left--;
	            right++;
	        }
	        return right - left - 1;
	    }


}
