public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T> {
    public OrderedArrayList() {
        super();
    }

    public OrderedArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    public boolean add(T element) {
        if (element == null) super.add(element);
        int i = 0;
        while (i < size() && element.compareTo(get(i)) > 0) i++;
        super.add(i, element);
        return true;
    }

    public void add(int index, T element) {
        add(element);
    }

    public T set(int index, T element) {
        T old = get(index);
        remove(index);
        add(element);
        return old;
    }
}
