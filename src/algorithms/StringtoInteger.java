package algorithms;

import java.util.HashSet;

public class StringtoInteger {
	static public int myAtoi(String str) {

		str = str.trim();

		if (str == null || str.equals(""))
			return 0;


		boolean sign = true;
		int index =0;
		if (str.charAt(0) == '+' || str.charAt(0) == '-') {
			index++;
			if (str.charAt(0) == '+')
				sign = true;
			else
				sign = false;
		}
		
		long number =0;

		for (;index<str.length();index++ ) {
			if(str.charAt(index)>='0'&&str.charAt(index)<='9'){
				number = number*10+(str.charAt(index)-'0');
			}else if(number==0&&(str.charAt(index)<'0'||str.charAt(index)>'9')){
				return 0;
			}
		}
		
		number =sign ? number : 0 - number;
		
		if(number>Math.pow(2, 31)-1)number =(long)Math.pow(2, 31)-1;
		if(number<-Math.pow(2, 31)) number =-(long)Math.pow(2, 31); 
		

		return (int)number;

	}

	public static void main(String[] args) {
//		System.out.println(myAtoi("42"));
//		System.out.println("   -42: " + myAtoi("   -42"));
//		System.out.println(myAtoi("4193 with words"));
		System.out.println("words and 987: "+myAtoi("words and 987"));
//		System.out.println(myAtoi("-91283472332"));

	}
}
