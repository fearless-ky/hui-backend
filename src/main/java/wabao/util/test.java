package wabao.util;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	String str = "1.2-5.6万";
	String[] a = str.split("-");
	char[] b = a[1].toCharArray();
	str = "";
	for(int i = 0;i<b.length;i++)
	{	if(b[i] >= 48 &&b[i] <= 57)
	str= str + b[i];
	if(b[i] == '.')
		str= str + b[i];
	}
	System.out.println("str = "  + str);
	
	}


}
