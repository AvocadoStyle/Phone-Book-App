import java.util.Iterator;

public class PhoneBook<K, V>
{
    private AssociationTable<Contact, String> _phoneBook;
    public PhoneBook()
    {
        this._phoneBook = new AssociationTable<>();
    }
    public PhoneBook(Contact[] keys, String[] values) throws IllegalArgumentException
    {
        this._phoneBook = new AssociationTable<>(keys, values);
    }

    public void addContact(Contact c, String phoneNumber)
    {
        this._phoneBook.add(c, phoneNumber);
    }
    public String getContact(Contact c)
    {
        return this._phoneBook.get(c);
    }
    public void removeContact(Contact c) throws NotRemoveException
    {
        if(!this._phoneBook.remove(c))
            throw new NotRemoveException("the object not removed");
    }

    public Iterator<Contact> getSortedContacts()
    {
        return this._phoneBook.iterator();
    }






}
