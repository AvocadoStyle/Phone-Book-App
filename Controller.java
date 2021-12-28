import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Controller
{
    private PhoneBook<Contact, String> _pb;

    @FXML
    private TextField cNameText;
    @FXML
    private TextField pNumberText;
    @FXML
    private ScrollPane scrollPaneAdding;
    @FXML
    private VBox phoneList;
    private ArrayList<Label> labels;

    /*search for number: */
    @FXML
    private TextField searchNameText;
    @FXML
    private Label SearchResultTextLabel;


    private PhoneBookFileAccess pbfa;
    String SearchResultName;


    @FXML
    void initialize()
    {
        try
        {
            System.out.println("here1");
            this.pbfa = new PhoneBookFileAccess();
            System.out.println("here2");
            this._pb = new PhoneBook<>(pbfa.getContacts(), pbfa.getNumbers());
            this._pb = new PhoneBook<>();
            System.out.println("here3");
//            refreshPhoneList();
        }
        catch(IllegalArgumentException e)
        {
//            System.out.println("err");
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            System.out.println("errr");
            e.printStackTrace();
        }
//        this._pb = new PhoneBook<>();
        this.SearchResultName = this.SearchResultTextLabel.getText();
    }



    @FXML
    void InsClick(ActionEvent event)
    {
        /*cNameText  pNumberText*/
        String contactName = this.cNameText.getText();
//        System.out.println(contactName);
        String phoneNumber = this.pNumberText.getText();
        Contact c = new Contact(contactName);
        this._pb.addContact(c, phoneNumber);
        refreshPhoneList();
    }

    @FXML
    void rmvClick(ActionEvent event)
    {
        try {
            String contactName = this.cNameText.getText();
            Contact c = new Contact(contactName);
            this._pb.removeContact(c);
            refreshPhoneList();
        }
        catch(NotRemoveException e)
        {
            e.printStackTrace();
        }
    }



    @FXML
    void ClickSearch(ActionEvent event)
    {
        String name = this.searchNameText.getText();
        Contact c = new Contact(name);
        String number = this._pb.getContact(c);
        this.SearchResultTextLabel.setText(this.SearchResultName + number);
    }









    @FXML
    void ClickLoad(ActionEvent event) {
        try {
            System.out.println("here1");
            this.pbfa = new PhoneBookFileAccess();
            System.out.println("here2");
            this._pb = new PhoneBook<>(pbfa.getContacts(), pbfa.getNumbers());
            refreshPhoneList();
        }
        catch(FileNotFoundException | IllegalArgumentException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void ClickSave(ActionEvent event) {
        try {
//            PhoneBookFileAccess pbfa = new PhoneBookFileAccess();
            pbfa.setSaveIntoFileAndUpdate(this._pb);
            this.refreshPhoneList();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException ev)
        {
            System.out.println("damn");
            ev.printStackTrace();
        }
        refreshPhoneList();
    }

















    private void refreshPhoneList()
    {
        this.phoneList.getChildren().clear();
        Iterator it = this._pb.getSortedContacts();
        while(it.hasNext())
        {
            Contact c = (Contact) it.next();
            this.phoneList.getChildren().add(new Label(c.getName()));
            this.phoneList.getChildren().add(new Label(this._pb.getContact(c)));
        }
    }





}
