package org.nenapu.java.sort;

/**
 * <p>
 * Its an implementation of quicksort algorithm by taking the
 * last element as the pivot.
 * </p>
 * <p>
 * Taking last element as the pivot makes implementation simpler and in
 * some situation performs better than taking pivot as middle element.
 * </p>
 * @author Kirana NS
 */
public class QuickSort {
	
	public void sort(int[] input){
		doSort(input, 0, input.length-1);
	}
	
	private void doSort(int[] input, int low, int high){
		if(low >= high){
			return;
		}
		
		int index = low;
		int pivot = input[high];
		int highestNumberIndexMarker = -1;
		int currentPivotIndex = high;
		
		while(index < high){
			if(input[index] > pivot){
				if(highestNumberIndexMarker == -1){
					highestNumberIndexMarker = index;
				}
			}
			else if(input[index] <= pivot){
				if(highestNumberIndexMarker != -1){
					swap(input, highestNumberIndexMarker, index);
					highestNumberIndexMarker++;
				}
			}
			index++;
		}
		
		if(highestNumberIndexMarker != -1){
			swap(input, highestNumberIndexMarker, currentPivotIndex);
			currentPivotIndex = highestNumberIndexMarker;
		}
		
		doSort(input, low, currentPivotIndex-1);
		doSort(input, currentPivotIndex+1, high);
	}
	
	private void swap(int[] input, int first, int second){
		int temp = input[first];
		input[first] = input[second];
		input[second] = temp;
	}
}
