import java.util.Arrays;

public class ArrayOperations {

    public static void main(String[] args) {


        System.out.println("------------   Сотрировка пузырьком   --------------");
        int [] arr = {11, 3, 14, 16, 7};
        System.out.println("Массив для сортировки методом пузырька: " + Arrays.toString(arr));
        int[] arrSortResult = arraySort(arr);
        System.out.println("Результат сортировки методом пузырька: " + Arrays.toString(arrSortResult));


        System.out.println("----------------   Бинарный поиск   ----------------");
        int valueToFind = 3;
        int[] valuesForBinarySearch = {1, 1, 2, 3, 4, 10};
        System.out.println("Массив для выполнения бинарного поиска = " + Arrays.toString(valuesForBinarySearch));
        System.out.println("Искомое значение = " + valueToFind);
        int valueIndex = getIndexByValue(valuesForBinarySearch, valueToFind, 0, valuesForBinarySearch.length - 1);
        System.out.printf("Индекс искомого значения = %d%n", valueIndex);


        System.out.println("--------   Получение элемента по индексу   ---------");
        System.out.println("Массив для получения элемента по индексу: " + Arrays.toString(arr));
        int index = 2;
        System.out.println("Индекс искомого элемента = " + index);
        try {
            int valueFromArray = getValueByIndex(arr, index);
            System.out.println("Значение, полученное по индексу = " + valueFromArray);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }


        System.out.println("-----   Создание массива увеличенной емкости   -----");
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Длина исходного массива: " + arr.length);
        int numberOfValues = 10;
        System.out.println("Количество добавляемых ячеек: " + numberOfValues);
        int[] elongatedArray = increaseArrayCapacity(arr, numberOfValues);
        System.out.println("Массив увеличенной емкости: " + Arrays.toString(elongatedArray));
        System.out.println("Длина увеличенного массива: " + elongatedArray.length);


        System.out.println("--------   Удаление элемента из массива   ---------");
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        int indexOfDeletedElement = 2;
        System.out.println("Индекс удаляемого значения: " + indexOfDeletedElement);
        System.out.println("Удаляемое значение: " + arr[indexOfDeletedElement]);
        try {
            int[] truncatedArray = deleteValueFromArrayByIndex(arr, indexOfDeletedElement);
            System.out.println("Укороченный массив: " + Arrays.toString(truncatedArray));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println("--------   Добавление нового элемента в заданнцю позицию массива   ---------");
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        int newValue = 100;
        System.out.println("Добавляемое значение: " + newValue);
        int insertPosition = 3;
        System.out.println("Индекс элемента для вставки: " + insertPosition);
        elongatedArray = addValueToArrayInPositionByIndex(arr, newValue, insertPosition);
        System.out.println("Массив увеличенной емкости: " + Arrays.toString(elongatedArray));
        System.out.println("Длина увеличенного массива: " + elongatedArray.length);
        newValue = 100;
        System.out.println("Добавляемое значение: " + newValue);
        insertPosition = 10;
        System.out.println("Индекс элемента для вставки: " + insertPosition);
        elongatedArray = addValueToArrayInPositionByIndex(arr, newValue, insertPosition);
        System.out.println("Массив увеличенной емкости: " + Arrays.toString(elongatedArray));
        System.out.println("Длина увеличенного массива: " + elongatedArray.length);



    }

    public static int[] addValueToArrayInPositionByIndex(int[] sourceArray, int newValue, int insertPosition) {
        int newArrayLength = 0;

        if(insertPosition <= sourceArray.length - 1) {
            newArrayLength = sourceArray.length + 1;
        } else {
            // Если позиция больше позиции последнего элемента
            newArrayLength = insertPosition + 1;
        }
        int newArray[] = new int[newArrayLength];
        if(insertPosition <= sourceArray.length - 1) {
            // Копируем элементы до позиции вставки
            for (int i = 0; i < insertPosition; i++) {
                newArray[i] = sourceArray[i];
            }
            // Вставляем новый элемент в заданную позицию
            newArray[insertPosition] = newValue;
            // Копируем в новый массив остальные элементы из исходного массива
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
            throw new Exception("Введенный индекс превышает индекс последнего элемента");
        }
        // Создаем новый массив меньшей емкости
        int[] newArray = new int[arr.length - 1];
        // Копируем элементы от начала массива и до удаляемого элемента
        int i;
        for(i = 0; i < index; i++) {
            newArray[i] = arr[i];
        }
        // Копируем элементы после удаляемого значения из исходного массива
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
        // Бинарный поиск
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
        // Получение элемента массива по его индексу
        if (index > arr.length - 1) {
            throw new Exception("Введенный индекс превышает индекс последнего элемента");
        }
        return arr[index];
    }

    public static int[] arraySort(int[] arr) {
        // Сортировка пузырьком
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
