class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String lower = paragraph.toLowerCase();
        
        String[] words = lower.split("[^a-z]+");
        
        HashMap<String, Integer> map = new HashMap<>();
        
        HashSet<String> bannedSet = new HashSet<>();
        for(String b : banned) {
            bannedSet.add(b);
        }
        
        for(String word : words) {
            if(!bannedSet.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        
        String ans = "";
        int max = 0;
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                ans = entry.getKey();
            }
        }
        
        return ans;
    }
}