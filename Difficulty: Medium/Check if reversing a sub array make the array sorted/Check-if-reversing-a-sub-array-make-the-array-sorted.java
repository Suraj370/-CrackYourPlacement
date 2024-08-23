import java.util.*;
class Main { 

static void reverse(int[] a,int x,int y) 
{ 
	while(x<y) 
	{ 
	int temp = a[x]; 
	a[x] = a[y]; 
	a[y] = temp; 
	x++; 
	y--; 
	} 
} 
static boolean sortArr(int[] a, int n) 
{ 
	int x = -1; 
	int y = -1; 

	for (int i = 0; i < n - 1; i++) { 
	if (a[i] > a[i + 1]) { 
		if (x == -1) { 
		x = i; 
		} 
		y = i + 1; 
	} 
	} 

	if (x != -1) { 
	reverse(a,x,y); 
	for (int i = 0; i < n - 1; i++) { 
		if (a[i] > a[i + 1]) { 
		return false; 
		} 
	} 
	} 

	return true; 
} 

// Driver Code 
public static void main (String[] args) 
{ 
    Scanner in = new Scanner(System.in);
	int n = in.nextInt(); 

    int arr[] = new int[n]; 
    
    for(int i = 0; i < n; i++){
        arr[i] = in.nextInt();
    }
	if(sortArr(arr, n)) 
	{ 
	System.out.println("Yes"); 
	} 
	else
	{ 
	System.out.println("No"); 
	} 
} 
} 

// This code is contributed by aditya942003patil
