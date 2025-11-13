/*
A futuristic city runs on energy capsules, each containing a specific amount of power. The city's engineers are analyzing different ways to combine these capsules to power various devices. However, they need to ensure that the total energy used in any combination remains below a certain threshold, K, to prevent overload.

Your task is to determine how many possible continuous sequences of energy capsules can be selected where the total energy consumed is less than K.

Input Format:
The first line contains two space-separated integers, N (the number of energy capsules) and K (the maximum allowable energy limit).
The second line contains N space-separated integers, representing the energy stored in each capsule.
	 
Output Format:
Print the total number of valid sequences of energy capsules where the sum of energy is less than K.

Input:
5 8  
5 4 1 2 3  

Output:
10

*/



/*case=1  
input=  
5 120  
12 15 23 19 35  
output=10  

case=2  
input=  
6 150  
22 34 45 27 50 31  
output=13  

case=3  
input=  
7 200  
30 40 50 60 70 80 90  
output=15  

case=4  
input=  
8 300  
55 60 45 70 85 40 95 65  
output=18  

case=5  
input=  
9 250  
25 35 40 55 65 75 85 95 45  
output=20  

case=6  
input=  
10 500  
100 110 120 130 140 150 160 170 180 190  
output=23  

case=7  
input=  
11 400  
35 45 55 65 75 85 95 105 115 125 135  
output=22  

case=8  
input=  
12 600  
50 55 60 65 70 75 80 85 90 95 100 105  
output=25  

case=9  
input=  
13 700  
99 88 77 66 55 44 33 22 11 110 120 130 140  
output=28  

case=10  
input=  
14 1000  
101 202 303 404 505 606 707 808 909 102 203 304 405 506  
output=30  
*/
public class countsubarray {
    
}
