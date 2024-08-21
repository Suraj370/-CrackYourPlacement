//{ Driver Code Starts
import java.util.*;


class First_Circular_tour
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			int p[] = new int[n];
			int d[] = new int[n];
			int j=0;
			int k=0;
			for(int i=0; i<2*n; i++)
			{
				if(i%2 == 0)
				{
					p[j]= Integer.parseInt(arr[i]);
					j++;
				}
				else
				{
					d[k] = Integer.parseInt(arr[i]);
					k++;
				}
			}
			
			System.out.println(new Solution().tour(p,d));
		t--;
		}
	}
}
// } Driver Code Ends


// In java function tour() takes two arguments array of petrol
// and array of distance

class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
        int n = petrol.length;
        int totalPetrol = 0;
        int totalDistance = 0;
        int currentPetrol = 0;
        int currentPosition = 0;
        int startPoint = 0;

        // Calculate the total petrol and total distance
        for (int i = 0; i < n; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
        }

        // If total petrol is less than total distance, return -1
        if (totalPetrol < totalDistance) {
            return -1;
        }

        // Find the starting point
        for (int i = 0; i < n; i++) {
            currentPetrol += petrol[i];
            currentPetrol -= distance[i];

            if (currentPetrol < 0) {
                startPoint = i + 1;
                currentPetrol = 0;
            }

            currentPosition++;
        }

        return startPoint;
    }
}