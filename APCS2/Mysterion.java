/*
Larry Wong
APCS2 pd8
HW16 -- About Face
2018-03-07
*/


public class Mysterion{

    public static int[] populate(int[]arr){
	for (int i = 0; i < arr.length; i++){
	    arr[i] = (int)(Math.random() * 100);
	}
	return arr;
    }
    public static String stringify(int[] arr){
	String s = "[ ";
	for (int z : arr){
	    s += Integer.toString(z);
	    s += " ";
	}
	s += "]";
	return s;
    }

    public static void printOut(int[] arr){
	System.out.print("\nResult: [ ");
	for (int z : arr){
	    System.out.print(z + " ");
	}
	System.out.println("]");
    }
    
    public static void swap(int[] arr, int x, int y){
	System.out.println("swapped: " + arr[x] + "," + arr[y]);
	int holder = arr[x];
	arr[x] = arr[y];
	arr[y] = holder;
    }
    
    public static int mysterious(int[] arr, int a, int b, int c){
	int v = arr[c];
	swap(arr, c, b);
	System.out.println("Inital Swap: " + stringify(arr));
	int s = a;
	System.out.println("s: " + s);
	System.out.println("v: " + v);
	
	for (int i = a; i < b; i++){

	    System.out.println("i= " + i + ": "+ arr[i]);
	    if (arr[i] < v){
		swap(arr, s, i);
		s += 1;
		System.out.println("s: " + s);
	    }
	    System.out.println("Iteration " + i + ": " + stringify(arr));
	}
	
	swap(arr,b,c);
	System.out.println("Final  Swap: " + stringify(arr));
	//printOut(arr);
	return s;
    }//end mysterious
    
    public static void main(String[] args){

	/*
	int[] test1 = { 7 , 1 , 5 , 12 , 3};
	System.out.println("\nTest1:" + stringify(test1));
	System.out.println(mysterious(test1,0,4,2));
	//running same array twice to see if anything changes
	System.out.println("\nTest1v2:" + stringify(test1));
	System.out.println(mysterious(test1,0,4,2));

	//testing an even array
	int[] test2 = { 0 , 7 , 1 , 5 , 12 , 3};
	System.out.println("\nTest2:" + stringify(test2));
	System.out.println(mysterious(test2,0,5,3));
	*/

	//testing with random sized arrays
	for (int i = 0; i < 20; i ++){
	    int[] random = new int[(int)(Math.random() * 20)+1];
	    populate(random);
	    System.out.println("\nRandom Test#" + i + ": " +  stringify(random));
	    System.out.println(mysterious(random,0,random.length-1,random.length/2));
	}
    }//end main()



}//end Mysterion
