// KVPair class definition
public class KVPair<K extends Comparable<K>, E> implements Comparable<KVPair<K, E>> {
  K theKey;
  E theVal;

  KVPair(K k, E v) {
    theKey = k;
    theVal = v;
  }

  @Override
  public int compareTo(KVPair<K, E> it){
      if (it instanceof KVPair) // Compare two KVPair objects
          return theKey.compareTo(it.key());
        else if (it instanceof Comparable) // Compare against a key value
          return theKey.compareTo(it.key());
        else
          throw new ClassCastException("Something comparable is expected.");
  }

  public K key() {
    return theKey;
  }

  public E value() {
    return theVal;
  }

  public String toString() {
    String s = "(";
    if (theKey != null) { s += theKey.toString(); }
    else { s += "null"; }
    s += ", ";
    if (theVal != null) { s += theVal.toString(); }
    else { s += "null"; }
    s += ")";
    return s;
  }


}