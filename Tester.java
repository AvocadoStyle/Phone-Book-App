import java.util.Iterator;

public class Tester
{
    public static void main(String[] args)
    {
        try
        {
            Contact c1, c2, c3, c4;
            c1 = new Contact("Eden");
            c2 = new Contact("Gostav");
            c3 = new Contact("Alfonso");
            c4 = new Contact("Fierre");
            Contact[] contacts = new Contact[]{c1, c2, c3, c4};
            String[] phoneNumbers = new String[]{"0547871235", "0547871234", "0547871233", "0547871232"};
            PhoneBook<Contact, String> pb1 = new PhoneBook<>(contacts, phoneNumbers);
            System.out.println(pb1.getContact(c1));
            System.out.println(pb1.getContact(c2));
            System.out.println(pb1.getContact(c3));
            System.out.println(pb1.getContact(c4));
            pb1.addContact(c1, "0");
            System.out.println("new");
            System.out.println(pb1.getContact(c1));
            System.out.println(pb1.getContact(c2));
            System.out.println(pb1.getContact(c3));
            System.out.println(pb1.getContact(c4));
            pb1.removeContact(c1);
            System.out.println("new");
            System.out.println(pb1.getContact(c1));
            System.out.println(pb1.getContact(c2));
            System.out.println(pb1.getContact(c3));
            System.out.println(pb1.getContact(c4));

            Contact c5, c6;
            String p5, p6;
            p5 = "100";
            p6 = "101";
            c5 = new Contact("Pablo");
            c6 = new Contact("Seulo");

            pb1.addContact(c5, p5);
            pb1.addContact(c6, p6);

            System.out.println("new");
            System.out.println(pb1.getContact(c1));
            System.out.println(pb1.getContact(c2));
            System.out.println(pb1.getContact(c3));
            System.out.println(pb1.getContact(c4));
            System.out.println(pb1.getContact(c5));
            System.out.println(pb1.getContact(c6));

            Contact c7, c8;
            String p7, p8;
            c7 = new Contact("Albert");
            c8 = new Contact("Fier");
            p7 = "150";
            p8 = "151";
            pb1.addContact(c7, p7);
            pb1.addContact(c8, p8);

            System.out.println("will get the sorted list by iterator: ");
            Iterator<Contact> iteratorSortedStudents = pb1.getSortedContacts();
            while(iteratorSortedStudents.hasNext())
            {
                Contact key = iteratorSortedStudents.next();
                String name = key.getName();
                System.out.println("name is: " + name);
                System.out.println("phone number is: "+ pb1.getContact(key));
            }
        }
        catch(IllegalArgumentException e1)
        {
            System.out.println("not same size");
        }
        catch(NotRemoveException ignored)
        {
            System.out.println("could not remove");
        }
    }
}
