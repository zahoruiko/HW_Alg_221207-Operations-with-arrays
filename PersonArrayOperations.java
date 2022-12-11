import java.util.Arrays;

public class PersonArrayOperations {

    public static void main(String[] args) {

        Person[] persons = {
                new Person("Helmut", 70),
                new Person("Mathias", 50),
                new Person("John", 50),
                new Person("Waltraud", 60),
                new Person("Alfred", 60),
                new Person("Alex", 30),
        };

        System.out.println("------------   Сотрировка массива объектов   -------------");
        System.out.println("Исходный массив: " + Arrays.toString(persons));
        // Сортируем массив объектов
        sortPersons(persons);
        System.out.println("Отсортированный массив: " + Arrays.toString(persons));


        System.out.println("-------------  Поиск элемента по индексу -----------------");
        int index = 2;
        System.out.println("Индекс элемента = " + index);
        Person searchedPerson = getPersonById(persons, index);
        System.out.println("Вывод элемента по индексу = "  + searchedPerson);


        System.out.println("------   Получение индекса по значению элемента   --------");
        // Проверяем наличие этого объекта в массиве
        Person personToCheck = new Person("Waltraud", 60);
        Person[] persons2 = {
                new Person("Helmut", 70),
                new Person("Mathias", 50),
                new Person("John", 50),
                personToCheck,
                new Person("Alfred", 60),
                new Person("Alex", 30),
        };
        System.out.println("Массив объектов Person: " + Arrays.toString(persons2));
        System.out.println("Искомый элемент: " + personToCheck);

        // Проверяем наличие в массиве объекта с такими же свойствами
        System.out.println("Индекс элемента в массиве:" + getPersonIndex(persons2, personToCheck));


        System.out.println("------   Удаление элемента из массива   --------");
        System.out.println("Массив объектов Person: " + Arrays.toString(persons2));
        System.out.println("Длина массива объектов Person: " + persons2.length);
        try {
            index = 3;
            System.out.println("Удаляем объект с индексом: " + index);
            persons = deleteValueFromArrayByIndex(persons2, index);
            System.out.println("Сокращенный Массив объектов Person: " + Arrays.toString(persons));
            System.out.println("Длина массива объектов Person: " + persons.length);
        } catch (Exception e) {
            System.out.println(e);
        }


        System.out.println("------   Добавление объекта в массив   --------");

        System.out.println("Исходный массив объектов Person: " + Arrays.toString(persons2));
        System.out.println("Длина исходного массива объектов Person: " + persons2.length);
        int insertPosition = 2;
        System.out.println("Позиция вставки элемента: " + insertPosition);
        Person newValue = new Person("Max", 33);
        System.out.println("Добавляемый элемент: " + newValue);
        persons2 = addValueToArrayInPositionByIndex(persons2, newValue, insertPosition);
        System.out.println("Результирующий массив объектов Person: " + Arrays.toString(persons2));
        System.out.println("Длина результирующего массива объектов Person: " + persons2.length);


        System.out.println("------   Увеливение емкости массива объектов   --------");
        System.out.println("Массив объектов Person: " + Arrays.toString(persons2));
        System.out.println("Длина исходного массива: " + persons2.length);
        // Увеличение емкости массива посредством создани] нового массива большей емкости и копирования в него данных из исходного
        int extArraySize = 3;
        System.out.println("Количество добавляемых в массив ячеек: " + extArraySize);
        Person[] newArr = increaseArrayCapacity(persons2, extArraySize);
        System.out.println("Увеличенные массив" + Arrays.toString(newArr));
        System.out.println("Длина увеличенного массива: " + newArr.length);



    }

    public static void sortPersons(Person[] persons) {
        Arrays.sort(persons);
    }

    public static Person getPersonById(Person[] persons, int index) {
        return persons[index];
    }

    public static int getPersonIndex(Person[] persons, Person person) {
        for (int i = 0; i < persons.length; i++) {
            if(person.equals(persons[i]))
                return i;
        }
        return -1;
    }


    public static Person[] addValueToArrayInPositionByIndex(Person[] sourceArray, Person newValue, int insertPosition) {
        int newArrayLength = 0;

        if(insertPosition <= sourceArray.length - 1) {
            newArrayLength = sourceArray.length + 1;
        } else {
            // Если позиция больше позиции последнего элемента
            newArrayLength = insertPosition + 1;
        }
        Person[] newArray = new Person[newArrayLength];
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

    public static Person[] deleteValueFromArrayByIndex(Person[] arr, int index) throws Exception {
        if (index > arr.length - 1) {
            throw new Exception("Введенный индекс превышает индекс последнего элемента");
        }
        // Создаем новый массив меньшей емкости
        Person[] newArray = new Person[arr.length - 1];
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

    public static Person[] increaseArrayCapacity(Person[] arr, int numberOfValues) {
        Person[] newArray = new Person[arr.length + numberOfValues];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }
}
