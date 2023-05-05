package pl.javastart.task;

import java.util.Arrays;
import java.util.Objects;

// Uzupełnij klasę. Możesz ją dowolnie modyfikować.
// Celem jest, żeby przechodziły testy w src/test/java/[...]/CustomListTest
public class CustomList<T> {
    private static final int INITIAL_ARRAY_SIZE = 10;
    private Object[] array;
    private int elementNumber;

    public CustomList() {
        array = new Object[INITIAL_ARRAY_SIZE];
    }

    public T get(int index) {
        Objects.checkIndex(index, elementNumber);
        return (T) array[index];
    }

    public void add(T element) {
        expandIfArrayIsFull();
        array[elementNumber] = element;
        elementNumber++;
    }

    public void add(int index, T element) {
        Objects.checkIndex(index, elementNumber + 1);
        if (index == elementNumber) {
            add(element);
        } else {
            expandIfArrayIsFull();
            shiftRight(index);
            array[index] = element;
            elementNumber++;
        }
    }

    private void shiftRight(int index) {
        System.arraycopy(array, index, array, index + 1, elementNumber - index);
    }

    private void expandIfArrayIsFull() {
        if (elementNumber == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    public void remove(int index) {
        Objects.checkIndex(index, elementNumber);
        removeAndShiftLeft(index);
        elementNumber--;
    }

    private void removeAndShiftLeft(int index) {
        System.arraycopy(array, index + 1, array, index, elementNumber - index - 1);
    }

    public int size() {
        return elementNumber;
    }

    @Override
    public String toString() {
        String elements = "[";
        for (int i = 0; i < elementNumber; i++) {
            if (i == elementNumber - 1) {
                elements += array[i];
            } else {
                elements += array[i] + ", ";
            }
        }
        elements += "]";
        return elements;
    }
}