class Solution {
    public String decodeString(String s) {
        Stack<Integer>intstack=new Stack<>();
        Stack<String>strstack=new Stack<>();
        int num=0;
        String str=new String();
        for(char ch:s.toCharArray())
        {A
            if(ch>='0'&&ch<='9')
            {
                num=(num*10)+(ch-'0');
            }
            else if(ch=='[')
            {
                intstack.push(num);
                strstack.push(str);
                num=0;
                str=new String();
            }
            else if(ch==']')
            {
                int count=intstack.pop();
                String temp=strstack.pop();
                for(int i=0;i<count;i++)
                {
                    temp+=str;
                }
                str=temp;
            }
            else
            {
                str+=ch;
            }
        }
        return str;
    }
}
