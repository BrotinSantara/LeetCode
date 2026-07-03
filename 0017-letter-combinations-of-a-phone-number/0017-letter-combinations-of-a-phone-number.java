class Solution {

    static final String[] MAP = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        return padReturn("",digits);
    }
        static ArrayList<String> padReturn(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        
        int digit = up.charAt(0) - '0';//converting char to int
        String letters=MAP[digit];
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < letters.length();i++ ){
            char ch = letters.charAt(i);
            list.addAll(padReturn(p + ch, up.substring(1)));
        }
        return list;
    }
        
    }

