class Solution {
    public String mergeAlternately(String word1, String word2) {
        
       StringBuilder builder = new StringBuilder();

       int i= 0;
       int j =0;

    // Take one character from each string
       while(i < word1.length() && j < word2.length()){
        builder.append(word1.charAt(i));
        builder.append(word2.charAt(j));
        i++;
        j++;
       }

       // Append remaining characters of word1
       while(i < word1.length()){
        builder.append(word1.charAt(i));
        i++;
       }
       
     // Append remaining characters of word2
        while(j < word2.length()){
         builder.append(word2.charAt(j));
         j++;
       }

       return builder.toString();
    }

}