//
//Write a function that takes a string of braces, and determines if the order of the braces is valid. It should return true if the string is valid, and false if it's invalid.
//
//        This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}. Thanks to @arnedag for the idea!
//
//        All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.
//
//        What is considered Valid?
//        A string of braces is considered valid if all braces are matched with the correct brace.
//
//        Examples
//        "(){}[]"   =>  True
//        "([{}])"   =>  True
//        "(}"       =>  False
//        "[(])"     =>  False
//        "[({})](]" =>  False

import java.util.Stack;

public class ValidBraces {

    public boolean isValid(String braces) {

        Stack<Character> stack = new Stack<Character>();
        int len = braces.length();
        for(int i=0;i<len;i++) {
            switch(braces.charAt(i)) {
                case '(' : stack.push('('); break;
                case ')' : if(!(stack.isEmpty())&&(stack.pop()=='(')) continue; else return false;
                case '{' : stack.push('{'); break;
                case '}' : if(!(stack.isEmpty())&&(stack.pop()=='{')) continue; else return false;
                case '[' : stack.push('['); break;
                case ']' : if(!(stack.isEmpty())&&(stack.pop()=='[')) continue; else return false;
            }
        }
        if(stack.isEmpty())  return true;
        else return false;

    }

}