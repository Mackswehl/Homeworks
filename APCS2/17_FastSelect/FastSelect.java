/*
* Maxwell Vale
* APCS2 pd2
* 2018-03-12M
*/


public class FastSelect {

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
    //System.out.println("swapped: " + arr[x] + "," + arr[y]);
    int holder = arr[x];
    arr[x] = arr[y];
    arr[y] = holder;
  }

  /* Split Sort (?)
  * Takes a middle integer from the arr of ints and places the rest of the integers on either side of it depending on if it is greater or less than.
  * arr -> the array of integers
  * a -> lowest index, 0
  * b -> highest index, arr.length - 1
  * c -> middle index (?), arr.length / 2
  */

  public static int partition(int[] arr, int a, int b, int c){
    int v = arr[c];
    swap(arr, c, b);
    //System.out.println("Inital Swap: " + stringify(arr));
    int s = a;
    //System.out.println("s: " + s);
    //System.out.println("v: " + v);

    for (int i = a; i < b; i++){

      //System.out.println("i= " + i + ": "+ arr[i]);
      if (arr[i] < v){
        swap(arr, s, i);
        s += 1;
        //System.out.println("s: " + s);
      }
      //System.out.println("Iteration " + i + ": " + stringify(arr));
    }

    swap(arr,b,s);
    System.out.println("Final Swap: " + stringify(arr));
    //printOut(arr);
    return s;
  }//end mysterious

  /*
  * ySmall finds the yth smallest number in an array using the splitSort method
  * splitSort the middle index of the arr and check what index is returned
  * if the index is greater than y, update upperbound of splitsort so that it is below that index
  * if returned index is less, update lowerbound
  * keep doing this until the returned index is equal to y
  * return arr[y]
  */

  /*
   * Execution time: O(log2(n))
   * Time really depends on the initial setup of the array.
   * It utilizes a similar method as binary search, since you perform the method and check which side of the division the answer is on
   * Then you continue on that side and limit the search area further
   * Repeat until you end on the answer.
   */

  public static int fastSelect (int[] arr, int y) {
    int lower = 0;
    int higher = arr.length - 1;
    int n = partition(arr,0,arr.length - 1, arr.length / 2);

    while (n != y - 1) {
      if (n > y - 1) {
        higher = n;
      }
      else {
        lower = n + 1;
      }

      System.out.println("lower = " + lower);
      System.out.println(("middle = " + (higher - lower + 1) / 2));
      System.out.println("higher = " + higher);
      if (lower == higher) {
        n = lower;
        break;
      }
      else if (((higher - lower + 1) / 2) == higher) {
        n = y - 1;
        break;
      }
      else {
        n = partition(arr,lower,higher,(higher - lower + 1) / 2);
      }
    }
    return arr[n];

  }

  public static void main(String[] args){

    //testing with random sized arrays
    for (int i = 0; i < 1; i ++){
      int[] random = new int[(int)(Math.random() * 10)+1];
      populate(random);
      System.out.println("\nRandom Test#" + i + ": " +  stringify(random));
      System.out.println(fastSelect(random,3));
      //System.out.println(splitSort(random, 0, 1, 1));
    }


  }//end main()



}//end Mysterion
