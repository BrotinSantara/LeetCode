class Solution {
    int longestChararcter(string& s, int k){
        if(k < 0) return 0 ;
        int maxFreq = 0;
        int ans = 0;
        unordered_map<char, int>mpp ;
        int left = 0, right = 0;
        int n = s.length() ;

        while(right < n){
            mpp[s[right]]++ ;
            maxFreq = max(maxFreq, mpp[s[right]]) ;

            int len = right - left + 1 ;
            if( (len - maxFreq) <= k){
                ans = max(ans, len) ;
            }
            else{
                 mpp[s[left]]-- ;
                 left++ ;
                }
            right++ ;
        }
        return ans ;
    }
public:
    int characterReplacement(string s, int k) {
        return longestChararcter(s, k);
    }
};