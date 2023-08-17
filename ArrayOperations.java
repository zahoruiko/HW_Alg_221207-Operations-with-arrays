import java.util.Arrays;

public class ArrayOperations {

    public static void main(String[] args) {


        System.out.println("------------   Bubble sorting   --------------");
        int [] arr = {11, 3, 14, 16, 7};
        System.out.println("Array for sorting by the bubble method: " + Arrays.toString(arr));
        int[] arrSortResult = arraySort(arr);
        System.out.println("The result of sorting the bubble method: " + Arrays.toString(arrSortResult));


        System.out.println("----------------   Binary search   ----------------");
        int valueToFind = 3;
        int[] valuesForBinarySearch = {1, 1, 2, 3, 4, 10};
        System.out.println("Array for binary search = " + Arrays.toString(valuesForBinarySearch));
        System.out.println("The desired value = " + valueToFind);
        int valueIndex = getIndexByValue(valuesForBinarySearch, valueToFind, 0, valuesForBinarySearch.length - 1);
        System.out.printf("Index of the desired value = %d%n", valueIndex);


        System.out.println("--------   Getting an item by index   ---------");
        System.out.println("Array for getting an element by index: " + Arrays.toString(arr));
        int index = 2;
        System.out.println("Index of the desired element = " + index);
        try {
            int valueFromArray = getValueByIndex(arr, index);
            System.out.println("The value obtained by the index = " + valueFromArray);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }


        System.out.println("-----   Creating an array of increased capacity   -----");
        System.out.println("Source array: " + Arrays.toString(arr));
        System.out.println("Length of the source array: " + arr.length);
        int numberOfValues = 10;
        System.out.println("Number of cells to be added: " + numberOfValues);
        int[] elongatedArray = increaseArrayCapacity(arr, numberOfValues);
        System.out.println("An array of increased capacity: " + Arrays.toString(elongatedArray));
        System.out.println("Length of the enlarged array: " + elongatedArray.length);


        System.out.println("--------   Removing an element from an array   ---------");
        System.out.println("Source array: " + Arrays.toString(arr));
        int indexOfDeletedElement = 2;
        System.out.println("Index of the value being deleted: " + indexOfDeletedElement);
        System.out.println("Value to delete: " + arr[indexOfDeletedElement]);
        try {
            int[] truncatedArray = deleteValueFromArrayByIndex(arr, indexOfDeletedElement);
            System.out.println("Shortened Array: " + Arrays.toString(truncatedArray));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println("--------   Adding a new element to the specified array position   ---------");
        System.out.println("Source array: " + Arrays.toString(arr));
        int newValue = 100;
        System.out.println("Value to add: " + newValue);
        int insertPosition = 3;
        System.out.println("Index of the element to insert: " + insertPosition);
        elongatedArray = addValueToArrayInPositionByIndex(arr, newValue, insertPosition);
        System.out.println("An array of increased capacity: " + Arrays.toString(elongatedArray));
        System.out.println("Length of the enlarged array: " + elongatedArray.length);
        newValue = 100;
        System.out.println("Added value: " + newValue);
        insertPosition = 10;
        System.out.println("Element index for insert: " + insertPosition);
        elongatedArray = addValueToArrayInPositionByIndex(arr, newValue, insertPosition);
        System.out.println("An array of increased capacity: " + Arrays.toString(elongatedArray));
        System.out.println("The length of an increased array: " + elongatedArray.length);
    }

    public static int[] addValueToArrayInPositionByIndex(int[] sourceArray, int newValue, int insertPosition) {
        int newArrayLength = 0;

        if(insertPosition <= sourceArray.length - 1) {
            newArrayLength = sourceArray.length + 1;
        } else {
            // If the position is greater than the position of the last element
            newArrayLength = insertPosition + 1;
        }
        int newArray[] = new int[newArrayLength];
        if(insertPosition <= sourceArray.length - 1) {
            // Copy the elements to the insertion position
            for (int i = 0; i < insertPosition; i++) {
                newArray[i] = sourceArray[i];
            }
            // Inserting a new element into the specified position
            newArray[insertPosition] = newValue;
            // Copy the remaining elements from the original array to the new array
            for (int i = insertPosition; i < sourceArray.length; i++) {
                newArray[i + 1] = sourceArray[i];
            }
        } else {
            for (int i = 0; i < sourceArray.length; i++) {
                newArray[i] = sourceArray[i];
            }
            newArray[insertPosition] = newValue;
        }
        return newArray;
    }

    public static int[] deleteValueFromArrayByIndex(int[] arr, int index) throws Exception {
        if (index > arr.length - 1) {
            throw new Exception("The entered index exceeds the index of the last element");
        }
        // Creating a new array of smaller capacity
        int[] newArray = new int[arr.length - 1];
        // Copy the elements from the beginning of the array to the element being deleted
        int i;
        for(i = 0; i < index; i++) {
            newArray[i] = arr[i];
        }
        // Copy the elements after the value being deleted from the source array
        for(i = index + 1; i < arr.length; i++) {
            newArray[i - 1] = arr[i];
        }
        return  newArray;
    }

    public static int[] increaseArrayCapacity(int[] arr, int numberOfValues) {
        int[] newArray = new int[arr.length + numberOfValues];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }

    public static int getIndexByValue(int[] sortedArray, int valueToFind, int low, int high) {
        // Binary search
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < valueToFind) {
                low = mid + 1;
            } else if (sortedArray[mid] > valueToFind) {
                high = mid - 1;
            } else if (sortedArray[mid] == valueToFind) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public static int getValueByIndex(int[] arr, int index) throws Exception {
        // Getting an array element by its index
        if (index > arr.length - 1) {
            throw new Exception("The entered index exceeds the index of the last element");
        }
        return arr[index];
    }

    public static int[] arraySort(int[] arr) {
        // Bubble Sorting
        boolean isSorted = false;
        int tmp;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    isSorted = false;

                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
        return arr;
    }
}
