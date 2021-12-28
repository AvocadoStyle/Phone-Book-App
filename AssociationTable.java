import java.util.Iterator;
import java.util.TreeMap;

public class AssociationTable<K extends Comparable<K>, V>
{
    private TreeMap<K, V> _tm;

    /**
     * empty Constructor, making a new empty TreeMap
     */
    public AssociationTable()
    {
        this._tm = new TreeMap<>();
    }

    /**
     * getting keys and values for each node in the TreeMap.
     * sort by the keys value and if the key values is equal it will replace the current with the next one in the series
     * if the lengths of keys and values aren't equal it will send Exception to the user.
     */
    public AssociationTable(K[] keys, V[] values) throws IllegalArgumentException {
        /*if the keys and values array isn't equal*/
        if(keys.length != values.length)
            throw new IllegalArgumentException("the keys and values length isn't equal, for keys: " + keys.length +
                    " for values: " + values.length);
        this._tm = new TreeMap<>();
        for(int i=0; i<keys.length; i++)
        {
            if(keys[i] == null)
                return;
            System.out.println("keys length are: " + keys.length);
            System.out.println("keys are: " + ((Contact)keys[i]).getName() + "  values are: " + values[i]);
            this._tm.put(keys[i], values[i]);
        }
    }


    /**
     * getters
     */
    public TreeMap<K, V> getTreeMap()
    {
        return this._tm;
    }


    public void add(K key, V value)
    {
        this._tm.put(key, value);
    }

    public V get(K key)
    {
        if(this._tm.containsKey(key))
            return this._tm.get(key);
        return null;
    }

    public boolean contains(K key)
    {
//        this._tm.
//        Set<K> keys = this._tm.keySet();
//        for(K kVal: keys)
//            if(key == kVal)
//                return true;
//        return false;
        return this._tm.containsKey(key);
    }

    public boolean remove(K key)
    {
        V value = this._tm.get(key);
        return this._tm.remove(key, value);
    }

    public int size()
    {
        return this._tm.size();
    }

    public Iterator<K> iterator()
    {
        return this._tm.keySet().iterator();
    }

}
