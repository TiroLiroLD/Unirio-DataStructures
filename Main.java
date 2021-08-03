import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        BinarySearchTree<Character, Integer> tree
                = new BinarySearchTree<>();
        BinarySearchTree<Character, Integer> treeDeleteTest
                = new BinarySearchTree<>();


        /**
         * STUB PROJECT EXAMPLE
         *
         * Consists in creating a BST with char nodes and check how
         * many entries each letter has for the given String name
         *
         * Note: test string has only chars (including whitespace)
         * that have at least one entry. Other chars could also be
         * given as test, returning null as result.
         * */
        String name = "ESTRUTURASDEDADOSII";
        for (char c : name.toCharArray()) {
            Integer count = tree.get(c);
            if (count == null) {
                count = 0;
            }
            count++;
            tree.put(c, count);
            treeDeleteTest.put(c, count);
        }
        String test = "ADEIORSTU";
        for (char c : test.toCharArray()) {
            System.out.println(c + " " + tree.get(c));
        }

/*

    String name = "123456789237654";
    for( char c : name.toCharArray() ) {
      Integer count = tree.get(c);
      if( count == null ) {
        count = 0;
      }
      count++;
      tree.put( c, count );
    }
    String test = "123456789 ";
    for( char c : test.toCharArray() ) {
      System.out.println( c + " " + tree.get(c) );
    }
*/

        /**
         * tree.min() TEST - OK
         *
         * Returns the lowest key in tree
         * Expected result for given string is a whitespace
         * Expected result for given string without whitespaces is A
         */
        System.out.printf("\n==== min() ==== \n");
        System.out.printf("min(): " + tree.min() + "\n");

        /**
         * tree.max() TEST - OK
         *
         * Returns the highest key in tree
         * Expected result for given string is U
         */
        System.out.printf("\n==== max() ==== \n");
        System.out.printf("max(): " + tree.max() + "\n");

        /**
         * tree.deleteMin() TEST
         *
         * Delete minKey from tree and update minKey
         * Expected tree.min() result for given string after
         * tree.deleteMin() is A
         */

        System.out.printf("\n==== deleteMin() ==== \n");
        printMin(treeDeleteTest);
        printTreeSize(treeDeleteTest);
        System.out.printf("\ndeleteMin(): \n");
        treeDeleteTest.deleteMin();
        printMin(treeDeleteTest);
        printTreeSize(treeDeleteTest);
        System.out.printf("\ndeleteMin(): \n");
        treeDeleteTest.deleteMin();
        printMin(treeDeleteTest);
        printTreeSize(treeDeleteTest);

        /**
         * tree.floor(Key) TEST
         *
         * Return max key lower than or equal to given Key
         */

        System.out.printf("\n==== floor(Key) ==== \n");
        System.out.printf("floor('E'): " + tree.floor('E') + "\n");
        System.out.printf("floor('B'): " + tree.floor('B') + "\n");

        /**
         * tree.ceil(Key) TEST
         *
         * Return max key lower than or equal to given Key
         */

        System.out.printf("\n==== ceil(Key) ==== \n");
        System.out.printf("ceil('E'): " + tree.ceil('E') + "\n");
        System.out.printf("ceil('F'): " + tree.ceil('F') + "\n");
        System.out.printf("ceil('B'): " + tree.ceil('B') + "\n");


        /**
         * tree.select(int) TEST
         *
         * Return key with given position (starting from 0)
         */

        System.out.printf("\n==== select(int) ==== \n");
        System.out.printf("select(0): " + tree.select(0) + "\n");
        System.out.printf("select(1): " + tree.select(1) + "\n");
        System.out.printf("select(2): " + tree.select(2) + "\n");

    }

    private static void printTreeSize(
            BinarySearchTree<Character, Integer> tree) {
        System.out.printf("Tamanho = " + tree.size() + "\n");
    }

    private static void printMin(
            BinarySearchTree<Character, Integer> tree) {
        System.out.printf("min(): " + tree.min() + "\n");
    }


}