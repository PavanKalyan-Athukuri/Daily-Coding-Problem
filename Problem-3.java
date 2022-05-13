Given a string s, find the length of the longest substring without repeating characters.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0,max =0,j = 0 ;
        while(i<s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i++));
                max =Math.max(max,set.size());
            }else{
                set.remove(s.charAt(j++));
            }
        }
        return max;
    }
}