import java.io.*;
import java.util.*;

class Main{

// This function assumes that a[] is 
// sorted. If a[] is not sorted, we need 
// to sort it first. 
public static int minCostToMakeElementEqual(int a[], 
											int n)
{
	
	// If there are odd elements, we choose 
	// middle element 
	int y; 
	
	if (n % 2 == 1) 
		y = a[n / 2]; 
	
	// If there are even elements, then we
	// choose the average of middle two. 
	else
		y = (a[n / 2] + a[(n - 2) / 2]) / 2; 
	
	// After deciding the final value, 
	// find the result. 
	int s = 0; 
	
	for(int i = 0; i < n; i++) 
		s += Math.abs(a[i] - y); 
	
	return s; 
}

// Driver code
public static void main (String[] args) 
{
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int a[] = new int[n];
    for(int i = 0; i < n;i++){
        a[i] = in.nextInt();
    }

	Arrays.sort(a);
	
	System.out.println(minCostToMakeElementEqual(a, n));
}
}

