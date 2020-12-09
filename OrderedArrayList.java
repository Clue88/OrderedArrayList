public class OrderedArrayList<T extends Comparable<T>> extends NoNullArrayList<T> {
    public OrderedArrayList() {
        super();
    }

    public OrderedArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    public boolean add(T element) {
        int i = 0;
        while (element.compareTo(get(i)) < 0) i++;
        super.add(i, element);
        return true;
    }

    public void add(int index, T element) {
        add(element);
    }
}
