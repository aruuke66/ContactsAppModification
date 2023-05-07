package com.example.contactsappmodification;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ContactsAppModificationController {

    @FXML    private ListView<Contacts> booksListView;
    @FXML    private ImageView coverImageView;
    private Contacts contactCurrent;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;

    @FXML
    void addButtonPressed(ActionEvent event) {
        try{
            if (validationFailed()){
                throw new NumberFormatException();
            }
            else{
                Contacts obj1 = new Contacts();
                obj1.setFirstName(firstNameTextField.getText());
                obj1.setLastName(lastNameTextField.getText());
                obj1.setEmail(emailTextField.getText());
                obj1.setPhoneNumber(phoneNumberTextField.getText());
                obj1.setImage("ContactsAppModification/Images/img5.jpg");
                contacts.add(obj1);
            }
        } catch (Exception ex){
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            emailTextField.setText("");
            phoneNumberTextField.setText("");
            firstNameTextField.requestFocus();
        }
    }

    @FXML
    void deleteButtonPressed(ActionEvent event) {
        try {
            contacts.remove(contactCurrent);
        }
        catch (Exception ex){
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            emailTextField.setText("");
            phoneNumberTextField.setText("");
            firstNameTextField.requestFocus();
        }
    }

    @FXML
    void updateButtonPressed(ActionEvent event) {
        try{
            if (validationFailed()){
                throw new NumberFormatException();
            }
            else{
                Contacts obj1 = new Contacts();
                contactCurrent.setFirstName(firstNameTextField.getText());
                contactCurrent.setLastName(lastNameTextField.getText());
                contactCurrent.setEmail(emailTextField.getText());
                contactCurrent.setPhoneNumber(phoneNumberTextField.getText());

            }
        } catch (Exception ex){
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            emailTextField.setText("");
            phoneNumberTextField.setText("");
            firstNameTextField.requestFocus();
        }
    }
    public boolean validationFailed() {
        return (firstNameTextField.getText().trim().equals("") ||
                lastNameTextField.getText().trim().equals("") ||
                emailTextField.getText().trim().equals("") ||
                phoneNumberTextField.getText().trim().equals(""));
    }

    private final ObservableList<Contacts> contacts = FXCollections.observableArrayList();

    public void initialize(){
        contacts.add(new Contacts("Speedwagon","Foundation","speedwagon@gmail.com","+996(102) 201 202","https://ih1.redbubble.net/image.1789903898.7925/st,small,507x507-pad,600x600,f8f8f8.jpg"));
        contacts.add(new Contacts("idk","idkov","idk.idkov_2026@ucentralasia.org","+996(304) 111 222","https://m.media-amazon.com/images/I/21BJ8c1aKLL._UXNaN_FMjpg_QL85_.jpg"));
        contacts.add(new Contacts("thermos","brandnew","brandnewthermos@mail.ru","+996(405) 333 444","https://media.donedeal.ie/eyJidWNrZXQiOiJkb25lZGVhbC5pZS1waG90b3MiLCJlZGl0cyI6eyJ0b0Zvcm1hdCI6ImpwZWciLCJyZXNpemUiOnsiZml0IjoiaW5zaWRlIiwid2lkdGgiOjYwMCwiaGVpZ2h0Ijo2MDB9fSwia2V5IjoicGhvdG9fMjU1MDgyNjc1In0=?signature=6aad3d43095fe49541535e80295c8f6a6f14e9006cf8b9887620632a9970a9d1"));
        contacts.add(new Contacts("Bang Chan","Christopher","brangchan97@smthmail.kr","+996(506) 555 666","https://i.pinimg.com/564x/f7/0a/84/f70a84a1690a5ce7b2ce5f78b10dbf1c.jpg"));

        booksListView.setItems(contacts);

        booksListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contacts>() {
            @Override
            public void changed(ObservableValue<? extends Contacts> observableValue, Contacts oldValue, Contacts newValue) {
                contactCurrent =newValue;
                coverImageView.setImage(new Image(newValue.getImage()));
                firstNameTextField.setText(newValue.getFirstName());
                lastNameTextField.setText(newValue.getLastName());
                emailTextField.setText(newValue.getEmail());
                phoneNumberTextField.setText(newValue.getPhoneNumber());
            }
        });
    }


}