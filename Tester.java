public class Tester {
    public static int ERR = 0;
    public static boolean DEBUG = true;
    public static void main(String[] args) {
        if (args.length > 0 && Boolean.parseBoolean(args[0]) == false) DEBUG = false;
        String test = "";

        test = "NoNullArrayList()";
        try {
            NoNullArrayList<String> s = new NoNullArrayList<String>();
            NoNullArrayList<Boolean> b = new NoNullArrayList<Boolean>();
            nothing(s, b);
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "NoNullArrayList(int initialCapacity)";
        try {
            NoNullArrayList<String> s = new NoNullArrayList<String>(5);
            NoNullArrayList<Boolean> b = new NoNullArrayList<Boolean>(63);
            nothing(s, b);
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "NoNullArrayList.add(int index, T element)";
        try {
            NoNullArrayList<String> s = new NoNullArrayList<String>();
            s.add(0, "Hello, world!");
            s.add(0, null);
            noException(test, "IllegalArgumentException");
        } catch(IllegalArgumentException e) {
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "NoNullArrayList.add(T element)";
        try {
            NoNullArrayList<String> s = new NoNullArrayList<String>();
            s.add("Hello, world!");
            s.add(null);
            noException(test, "IllegalArgumentException");
        } catch(IllegalArgumentException e) {
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "NoNullArrayList.set(int index, T element)";
        try {
            NoNullArrayList<String> s = new NoNullArrayList<String>();
            s.add("hi");
            s.add("there");
            s.set(1, "cool");
            s.set(1, null);
            noException(test, "IllegalArgumentException");
        } catch(IllegalArgumentException e) {
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "OrderedArrayList()";
        try {
            OrderedArrayList<String> s = new OrderedArrayList<String>();
            OrderedArrayList<Boolean> b = new OrderedArrayList<Boolean>();
            nothing(s, b);
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "OrderedArrayList(int initialCapacity)";
        try {
            OrderedArrayList<String> s = new OrderedArrayList<String>(5);
            OrderedArrayList<Boolean> b = new OrderedArrayList<Boolean>(63);
            nothing(s, b);
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "OrderedArrayList.add(T element)";
        try {
            OrderedArrayList<Integer> n = new OrderedArrayList<Integer>();
            n.add(3); n.add(6); n.add(-4); n.add(100);
            check(test, n.toString(), "[-4, 3, 6, 100]");

            OrderedArrayList<Integer> s = new OrderedArrayList<Integer>();
            s.add(null);
            noException(test, "IllegalArgumentException");
        } catch(IllegalArgumentException e) {
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "OrderedArrayList.add(int index, T element)";
        try {
            OrderedArrayList<Integer> n = new OrderedArrayList<Integer>();
            n.add(0, 3); n.add(0, 6); n.add(0, -4); n.add(0, 100);
            check(test, n.toString(), "[-4, 3, 6, 100]");
        } catch(RuntimeException e) {
            except(test, e);
        }

        test = "OrderedArrayList.set(int index, T element)";
        try {
            OrderedArrayList<Integer> n = new OrderedArrayList<Integer>();
            n.add(0, 3); n.add(0, 6); n.add(0, -4); n.add(0, 100);
            n.set(2, -8);
            check(test, n.toString(), "[-8, -4, 3, 100]");
        } catch(RuntimeException e) {
            except(test, e);
        }

        if (ERR == 0) System.out.println("All good!");
        else if (ERR == 1) System.out.println("Uh oh... 1 error found.");
        else System.out.println("Uh oh... " + ERR + " errors found.");
    }

    public static void check(String test, Object actual, Object expected) {
        if (!actual.equals(expected)) {
            System.out.println("Failure on " + test + ": Expected \"" +
                                expected + "\", got \"" + actual + "\".");
            ERR++;
        }
    }

    public static void except(String test, RuntimeException e) {
        System.out.println("Failure on " + test + ": RuntimeException");
        if (DEBUG) System.out.println(e.toString());
        ERR++;
    }

    public static void noException(String test, String expected) {
        System.out.println("Failure on " + test + ": Expected " + expected);
        ERR++;
    }

    public static void nothing(Object... nothings) {
        return;
    }
}
