import java.util.*;

public class Main{

public static void main(String[] args) {

    int i = 10;
    if(i++ == i)
 	 System.out.println(i + " is good");
    else
 	 System.out.println(i + " is bad");
 
    int j = 20;
    if(++j == j)
 	 System.out.println(j + " is good");
    else
 	 System.out.println(j + " is bad");

 }
}

/*part1
The if condition in following code processes left to right
i++ changes the value of i to 11, but returns old value which is 10. This is compared by == to i (the current value at i's location, which is 11)
Hence the condition is false and we get 11 is bad.
part2
The if condition in following code processes left to right
++j changes the value of j to 21, and returns new value which is 21. This is compared by == to j (the current value at j's location, which is 21)
Hence the condition is true and we get 21 is bad.
*/