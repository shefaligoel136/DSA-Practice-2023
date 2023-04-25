package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeDeque {


    public static boolean checkPalindrome(String s){
        Deque<Character> deque = new ArrayDeque<>();

        for(Character c: s.toCharArray()){
            deque.add(c);
        }

        while(deque.size()>1){
            Character front = deque.removeFirst();
            Character rear = deque.removeLast();
            if(front!=rear)
                return false;
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(checkPalindrome("hello"));
        System.out.println(checkPalindrome("madam"));
    }

}
