import java.util.Stack;

public class BraceChecker {

    public boolean isValid(String braces) {

        //int arr[] = new int[3];

        //for(int i=0;i<3;i++) arr[i] =0;

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
            System.out.println(braces.charAt(i));
        }
        if(stack.isEmpty())  return true;
        else return false;
        // Add code here
        // return ((arr[0]==0)&&(arr[1]==0)&&(arr[2]==0));
    }
}

/***
//Other way:  Python ?!
function validBraces(braces){
    var stack = [];
    return braces.split('').map(b=> {
    if ('({['.indexOf(b)>=0) {
        stack.push(b);
        return true;
    } else {
        var e = stack.pop();
        return '({['.indexOf(e) == ')}]'.indexOf(b);
    }
  }).every(b=>b) && stack.length == 0;
}


    function validBraces(braces){
        while(braces.indexOf("{}") != -1 || braces.indexOf("()") != -1 || braces.indexOf("[]") != -1){
            braces = braces.replace("{}", "").replace("()", "").replace("[]", "");
        }
        return braces.length == 0;
    }


    function validBraces(braces){
        while(/\(\)|\[\]|\{\}/g.test(braces)){braces = braces.replace(/\(\)|\[\]|\{\}/g,"")}
        return !braces.length;
    }

***/

