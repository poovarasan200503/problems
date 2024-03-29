// You are using Java
import java.util.*;
class Operation 
{
    public int add(int a,int b)
    {
        int carry=0;
        while(b!=0)
        {
            carry=a&b;
            a=a^b;
            b=carry<<1;
        }
        return a;
    }
    
    public int sub(int a,int b)
    {
        int borrow=0;
        while(b!=0)
        {
            borrow=(~a)&b;
            a=a^b;
            b=borrow<<1;
        }
        return a;
    }
    
    public int multi(int a,int b)
    {
        int mul=0;
        while(b!=0)
        {
            if((b&1)!=0)
            {
                mul=add(mul,a);
            }
            a=a<<1;
            b=b>>1;
        }
        return mul;
    }
    
    public int div(int a,int b)
    {
        if(b==0)
        {
            return Integer.MAX_VALUE;
        }
        int sign=((a<0)^(b<0))?-1:1;
        a=Math.abs(a);
        b=Math.abs(b);
       int q=0;
       
       while(a>=b)
       {
           a=sub(a,b);
           ++q;
       }
       if(sign==-1)
       {
           q=-q;
       }
       return q;
    }
    
}
class main
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n1=10;
        int n2=2;
        Operation o=new Operation();
        System.out.println(o.add(n1,n2));
        System.out.println(o.sub(n1,n2));
        System.out.println(o.multi(n1,n2));
        System.out.println(o.div(n1,n2));
    }
}
