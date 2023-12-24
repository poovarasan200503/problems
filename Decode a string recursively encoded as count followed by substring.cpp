// You are using GCC
#include<iostream>
#include<bits/stdc++.h>
using namespace std;
string result (string str)
{
    stack<string>strstack;
    stack<int>intstack;
    int num=0;
    string temp;
    for(char ch:str)
    {
        if(ch>='0'&&ch<='9')
        {
            num=num*10+(ch-'0');
        }
        else if(ch=='[')
        {
                strstack.push(temp);
                intstack.push(num);
                num=0;
                temp="";
        }
        else if(ch==']')
        {
            int count = intstack.top();
            string temp2=strstack.top();
            intstack.pop();
            strstack.pop();
            for(int i=0;i<count;i++)
            {
                    temp2+=temp;
            }
            temp=temp2;
        }
        else
        {
            temp+=ch;
        }
    }
    return temp;
}
int main()
{
    string str;
    cin>>str;
    cout<<result(str);
}
