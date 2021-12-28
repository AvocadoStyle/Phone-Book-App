import java.lang.Comparable;

public class Contact implements Comparable<Contact>
{
    private String _name;

    public Contact(String name)
    {
        this._name = name;
    }


    public String getName()
    {
        return this._name;
    }

    @Override
    public int compareTo(Contact o) {
        return this._name.compareTo(o._name);
    }

}
