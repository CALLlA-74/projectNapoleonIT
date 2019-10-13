package projectForNapoleonIT;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static Scanner in = new Scanner(System.in);
	public static int N = in.nextInt(); 							//общее кол-во чисел
	public static int numArray[] = new int[N]; 					//массив чисел
	public static void main(String[] args) {
		int iCount = 0;   	  								//кол-во чисел некратных 3 
		int iCountMultiplic = 0;							//кол-во чисел кратных 3 
		for(int i = 0;i < N;i++) {
			int num = in.nextInt();
			if(num%3 == 0) {
				numArray[iCountMultiplic] = num;
				iCountMultiplic++;
			}
			else {
				iCount++;
				numArray[N-iCount] = num;
			}
		}		
		int highMult = iCountMultiplic-1; 					 //индекс крайнего правого числа кратного 3
		int lowMult = 0;									 //индекс крайнего левого числа кратного 3
		int high = N-1;										 //индекс крайнего правого числа некратного 3
		int low = iCountMultiplic;						 	 //индекс крайнего левого числа некратного 3
		Main.quickSortMult(numArray, lowMult, highMult);	 //сортировка по возрастанию чисел кратных 3
		Main.quickSort(numArray, low, high);				 //сортировка по возрастанию чисел некратных 3
		for(int i = 0; i < N; i++) System.out.print(numArray[i] + " ");   // вывод
	}
	
	public static void quickSortMult(int[] array, int low, int high) {
		if(array.length == 0) return;
		if (low >= high)
            return;											 //завершить выполнение если уже нечего делить
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int theFirst = array[middle];
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < theFirst) {
                i++;
            }
            while (array[j] > theFirst) {
                j--;
            }
            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSortMult(array, low, j);
        if (high > i)
            quickSortMult(array, i, high);
	}
	
	public static void quickSort(int[] array, int low, int high)  {
		if (array.length == 0)
            return;
 
        if (low >= high)
            return;											//завершить выполнение если уже нечего делить
 
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int theFirst = array[middle];
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < theFirst) {
                i++;
            }
            while (array[j] > theFirst) {
                j--;
            }
            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
	}
}
