package projectForNapoleonIT;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static Scanner in = new Scanner(System.in);
	public static int N = in.nextInt(); 							//����� ���-�� �����
	public static int numArray[] = new int[N]; 					//������ �����
	public static void main(String[] args) {
		int iCount = 0;   	  								//���-�� ����� ��������� 3 
		int iCountMultiplic = 0;							//���-�� ����� ������� 3 
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
		int highMult = iCountMultiplic-1; 					 //������ �������� ������� ����� �������� 3
		int lowMult = 0;									 //������ �������� ������ ����� �������� 3
		int high = N-1;										 //������ �������� ������� ����� ���������� 3
		int low = iCountMultiplic;						 	 //������ �������� ������ ����� ���������� 3
		Main.quickSortMult(numArray, lowMult, highMult);	 //���������� �� ����������� ����� ������� 3
		Main.quickSort(numArray, low, high);				 //���������� �� ����������� ����� ��������� 3
		for(int i = 0; i < N; i++) System.out.print(numArray[i] + " ");   // �����
	}
	
	public static void quickSortMult(int[] array, int low, int high) {
		if(array.length == 0) return;
		if (low >= high)
            return;											 //��������� ���������� ���� ��� ������ ������
        // ������� ������� �������
        int middle = low + (high - low) / 2;
        int theFirst = array[middle];
        // ��������� �� ����������, ������� ������ � ������ �������� ��������
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < theFirst) {
                i++;
            }
            while (array[j] > theFirst) {
                j--;
            }
            if (i <= j) {//������ �������
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // ����� �������� ��� ���������� ����� � ������ �����
        if (low < j)
            quickSortMult(array, low, j);
        if (high > i)
            quickSortMult(array, i, high);
	}
	
	public static void quickSort(int[] array, int low, int high)  {
		if (array.length == 0)
            return;
 
        if (low >= high)
            return;											//��������� ���������� ���� ��� ������ ������
 
        // ������� ������� �������
        int middle = low + (high - low) / 2;
        int theFirst = array[middle];
        // ��������� �� ����������, ������� ������ � ������ �������� ��������
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < theFirst) {
                i++;
            }
            while (array[j] > theFirst) {
                j--;
            }
            if (i <= j) {//������ �������
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // ����� �������� ��� ���������� ����� � ������ �����
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
	}
}
