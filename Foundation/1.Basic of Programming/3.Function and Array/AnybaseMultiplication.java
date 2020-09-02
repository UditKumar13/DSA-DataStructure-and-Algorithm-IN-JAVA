 public static int getSum(int b, int n1, int n2){
       // write ur code here
       int rv=0;
       int p=1;
       int carry=0;
       while(n1>0 || n2>0 || carry > 0){
           int d1 = n1%10;
           int d2 = n2%10;
           n1=n1/10;
           n2=n2/10;
           
           //logic to calculate digit sum and next carry 
           int d  = d1 + d2 + carry;
           carry = d/b;
           d = d % b;
           
           rv+=d*p;
           p=p*10;
           
           
           
       }
       return rv;
   }