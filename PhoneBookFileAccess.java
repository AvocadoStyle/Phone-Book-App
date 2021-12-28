import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookFileAccess
{
//    private ArrayList<Contact> contactsName;
//    private ArrayList<String> numbers;
    private Contact[] contactsName;
    private String[] numbers;
    private Scanner input;

    private final int ContactMaxNumber = 1000;

    public PhoneBookFileAccess() throws FileNotFoundException
    {
        input = new Scanner(new File("C:\\Users\\עדן רפאלוב\\IdeaProjects\\mmn14_q2\\phoneBookData.txt"));
        contactsName = new Contact[ContactMaxNumber];
        numbers = new String[ContactMaxNumber];
        int i=0;
        while(input.hasNext())
        {
//            this.contactsName.add(new Contact(input.nextLine()));
//            this.numbers.add(input.nextLine());
            this.contactsName[i] = new Contact(input.nextLine());
            this.numbers[i] = new String(input.nextLine());
            i++;
        }
    }
    public Contact[] getContacts()
    {
        return this.contactsName;
    }
    public String[] getNumbers()
    {
        return this.numbers;
    }

    public void setSaveIntoFileAndUpdate(PhoneBook<Contact, String> pb) throws IOException {
        Iterator<Contact> it = pb.getSortedContacts();
        BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\עדן רפאלוב\\IdeaProjects\\mmn14_q2\\phoneBookData.txt"));
        int i=0;
//        out.flush();
        while(it.hasNext())
        {
            Contact c = it.next();
            out.write(c.getName());
//            out.write('\n');
            out.newLine();
//            if(!it.hasNext())
//                return;
            out.write(pb.getContact(c));
//            out.write('\n');
            out.newLine();
//            System.out.println("iteration: " + i + "name is: " + c.getName() + "number is: " + pb.getContact(c));
//            i++;
            out.flush();
        }
    }

}
