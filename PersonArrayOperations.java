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

        System.out.println("------------   Sorting an array of objects   -------------");
        System.out.println("Source array: " + Arrays.toString(persons));
        // Sorting an array of objects
        sortPersons(persons);
        System.out.println("Sorted array: " + Arrays.toString(persons));


        System.out.println("-------------  Searching for an item by index -----------------");
        int index = 2;
        System.out.println("Element index = " + index);
        Person searchedPerson = getPersonById(persons, index);
        System.out.println("Output of an element by index = "  + searchedPerson);


        System.out.println("------   Getting an index by the value of an element   --------");
        // We check the presence of this object in the array
        Person personToCheck = new Person("Waltraud", 60);
        Person[] persons2 = {
                new Person("Helmut", 70),
                new Person("Mathias", 50),
                new Person("John", 50),
                personToCheck,
                new Person("Alfred", 60),
                new Person("Alex", 30),
        };
        System.out.println("Array of Person objects: " + Arrays.toString(persons2));
        System.out.println("The desired element: " + personToCheck);

        // We check the presence of an object with the same properties in the array
        System.out.println("Index of the element in the array:" + getPersonIndex(persons2, personToCheck));


        System.out.println("------   Removing an element from an array   --------");
        System.out.println("Array of Person objects: " + Arrays.toString(persons2));
        System.out.println("Length of the array of Person objects: " + persons2.length);
        try {
            index = 3;
            System.out.println("Deleting an object with an index: " + index);
            persons = deleteValueFromArrayByIndex(persons2, index);
            System.out.println("Reduced Array of Person objects: " + Arrays.toString(persons));
            System.out.println("Length of the array of Person objects: " + persons.length);
        } catch (Exception e) {
            System.out.println(e);
        }


        System.out.println("------   Adding an object to an array   --------");

        System.out.println("Source array of Person objects: " + Arrays.toString(persons2));
        System.out.println("The length of the original array of Person objects: " + persons2.length);
        int insertPosition = 2;
        System.out.println("Item insertion position: " + insertPosition);
        Person newValue = new Person("Max", 33);
        System.out.println("The element being added: " + newValue);
        persons2 = addValueToArrayInPositionByIndex(persons2, newValue, insertPosition);
        System.out.println("The resulting array of Person objects: " + Arrays.toString(persons2));
        System.out.println("Length of the resulting array of Person objects: " + persons2.length);


        System.out.println("------   Increasing the capacity of an array of objects   --------");
        System.out.println("Array of Person objects: " + Arrays.toString(persons2));
        System.out.println("Length of the source array: " + persons2.length);
        // Increasing the capacity of the array by creating] a new array of larger capacity and copying data from the original into it
        int extArraySize = 3;
        System.out.println("The number of cells to be added to the array: " + extArraySize);
        Person[] newArr = increaseArrayCapacity(persons2, extArraySize);
        System.out.println("Enlarged array" + Arrays.toString(newArr));
        System.out.println("Length of the enlarged array: " + newArr.length);
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
            // If the position is greater than the position of the last element
            newArrayLength = insertPosition + 1;
        }
        Person[] newArray = new Person[newArrayLength];
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

    public static Person[] deleteValueFromArrayByIndex(Person[] arr, int index) throws Exception {
        if (index > arr.length - 1) {
            throw new Exception("The entered index exceeds the index of the last element");
        }
        // Creating a new array of smaller capacity
        Person[] newArray = new Person[arr.length - 1];
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

    public static Person[] increaseArrayCapacity(Person[] arr, int numberOfValues) {
        Person[] newArray = new Person[arr.length + numberOfValues];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }
}
