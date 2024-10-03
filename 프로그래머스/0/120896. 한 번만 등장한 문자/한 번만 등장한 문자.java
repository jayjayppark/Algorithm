import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> al = new ArrayList<>();
        
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == 1) {
             al.add(entry.getKey());   
            }
        }
        
        Collections.sort(al);
        
        for (char a : al) {
            sb.append(a);
        }
        
        return sb.toString();
    }
}