class Main {
  public static void main(String[] args) {
    BinarySearchTree<Character,Integer> tree
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
    String name = "ESTRUTURAS DE DADOS II";
    for( char c : name.toCharArray() ) {
      Integer count = tree.get(c);
      if( count == null ) {
        count = 0;
      }
      count++;
      tree.put( c, count );
    }
    String test = "ADEIORSTU ";
    for( char c : test.toCharArray() ) {
      System.out.println( c + " " + tree.get(c) );
    }

    /**
     * tree.min() TEST
     *
     * Returns the lowest key in tree
     * Expected result for given string is a whitespace
     * Expected result for given string without whitespaces is A
     */
    System.out.println(tree.min());

    /**
     * tree.max() TEST
     *
     * Returns the highest key in tree
     * Expected result for given string is U
     */
    System.out.println(tree.max());
  }
}