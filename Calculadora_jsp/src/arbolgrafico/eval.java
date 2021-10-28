package arbolgrafico;

import java.util.Stack;


class eval
{

    public static double calculation(String a)
    {
        Stack<Double> values=new Stack<Double>();
        Stack<Character> op=new Stack<Character>();
        for(int i=0;i<a.length()-1;i++)
        {
            if(a.charAt(i)>='0'&&a.charAt(i)<='9')
            {
                String add="";
                while(i<a.length()-1&&a.charAt(i)>='0'&&a.charAt(i)<='9')

                    add=add+a.charAt(i++);
                values.push((double) Double.parseDouble(add));
                i--;
            }
            else if(a.charAt(i)=='(')
                op.push(a.charAt(i));
            else if(a.charAt(i)==')')
            {
                while(op.peek()!='(')
                    values.push((double) calculate(op.pop(),values.pop(),values.pop()));
                op.pop();
            }
            else if(a.charAt(i)=='+'||a.charAt(i)=='-'||a.charAt(i)=='*'||a.charAt(i)=='%'||a.charAt(i)=='/'||a.charAt(i)=='^' )
            {
                while(!op.empty()&&check(a.charAt(i),op.peek()))
                    values.push((double) calculate(op.pop(),values.pop(),values.pop()));
                op.push(a.charAt(i));
            }
        }
        while (!op.empty())
            values.push((double) calculate(op.pop(), values.pop(), values.pop()));

        return values.pop();
    }
    public static double calculate(char op,double b,double a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
            case '^':
                return Math.pow(a, b);

            case '%':
               return  (a/100)*b;

        }
        return 0;
    }
    public static boolean check(char op1,char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if (( op1=='%' ||op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-' ))
            return false;
        if ((op1 == '^') && (op2 == '+' || op2 == '-'))
            return false;
        if ((op1 == '^') && (op2=='%' ||op2 == '*' || op2 == '/' ))
            return false;
        if(op1=='^'&& op2=='^')
            return true;
        else
            return true;
    }
}