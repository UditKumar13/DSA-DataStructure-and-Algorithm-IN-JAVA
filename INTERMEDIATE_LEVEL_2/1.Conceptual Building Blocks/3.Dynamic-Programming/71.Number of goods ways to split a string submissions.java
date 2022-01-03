class Solution {
    public int numSplits(String s) {
      
        int n = s.length () ; 
        int [] freq = new int [26] ;
      
        int [] pref = new int [n];
      
        int [] suff= new int [n] ;
      
      int count = 0 ;
      
      
      for (int i=0 ; i< n ; i++){
        int ch = s.charAt(i) - 'a' ;
        
        freq[ch] ++ ; 
        
        if (freq[ch] == 1){
          count ++ ; 
        }
        
        pref[i] = count ; 
      }
       
      
    
  
  freq = new int [26] ;
  
  count = 0 ; 
  
  for(int i = n-1 ; i>=0 ; i--){
    int ch = s.charAt(i) - 'a';
    
    freq[ch] ++  ;
    
    if (freq[ch] == 1){
      count ++ ; 
    }
    
    suff[i] = count ; 
  
  }
  
 int splits = 0 ; 
  
  for (int i =0 ; i <n-1; i++){
    if (pref[i] == suff[i+1]){
      splits ++ ; 
    }
  }
return splits ; 
}


}