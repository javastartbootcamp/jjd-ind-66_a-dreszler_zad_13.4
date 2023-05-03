package pl.javastart.task;

import java.util.Arrays;
import java.util.Objects;

// Uzupełnij klasę. Możesz ją dowolnie modyfikować.
// Celem jest, żeby przechodziły testy w src/test/java/[...]/CustomListTest
public class CustomList<T> {
    private static final Object[] INITIAL_ARRAY = {};
    private Object[] array;
    private int elementNumber;

    public CustomList() {
        array = INITIAL_ARRAY;
    }

    public T get(int index) {
        Objects.checkIndex(index, array.length);
        return (T) array[index];
    }

    public void add(T element) {
        expandArray();
        array[elementNumber] = element;
        elementNumber++;
    }

    public void add(int index, T element) {
        Objects.checkIndex(index, array.length + 1);
        if (index == array.length) {
            add(element);
        } else {
            expandArray();
            shiftRight(index);
            array[index] = element;
            elementNumber++;
        }
    }

    private void shiftRight(int index) {
        for (int i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
    }

    public void remove(int index) {
        Objects.checkIndex(index, array.length);
        removeAndShiftLeft(index);
        trimArray();
        elementNumber--;
    }

    private void removeAndShiftLeft(int index) {
        for (int i = index; i < array.length; i++) {
            if (i == array.length - 1) {
                array[i] = null;
            } else {
                array[i] = array[i + 1];
            }
        }
    }

    private void trimArray() {
        array = Arrays.copyOf(array, array.length - 1);
    }

    private void expandArray() {
        array = Arrays.copyOf(array, array.length + 1);
    }

    public int size() {
        return elementNumber;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
