package controller;

import Model.Student;
import TM.StudentTM;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DataSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import util.CrudUtil;
import util.ValidationUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class StudentController {

    public AnchorPane StudentA;
    public ImageView lblSId;
    public Label lblTopic;
    public Label lblSName;
    public Label lblEmail;
    public Label lblCNo;
    public Label lblAddress;
    public Label lblNIC;
    public JFXTextField txtSId;
    public JFXTextField txtSName;
    public JFXTextField txtEmail;
    public JFXTextField txtCNo;
    public JFXTextField txtAddress;
    public JFXTextField txtNIC;
    public JFXButton lblAdd;
    public TableView<StudentTM> Student;
    public TableColumn tblSId;
    public TableColumn tblSName;
    public TableColumn tblEmail;
    public TableColumn tblCNo;
    public TableColumn tblAddress;
    public TableColumn tblNIC;
    public TextField txtSearch;
    public Label lblSearch;

    public  void initialize(){


        tblSId.setCellValueFactory(new PropertyValueFactory("SId"));
        tblSName.setCellValueFactory(new PropertyValueFactory("SName"));
        tblEmail.setCellValueFactory(new PropertyValueFactory("Email"));
        tblCNo.setCellValueFactory(new PropertyValueFactory("CNo"));
        tblAddress.setCellValueFactory(new PropertyValueFactory("Address"));
        tblNIC.setCellValueFactory(new PropertyValueFactory("NIC"));


        try {
            loadALLstudent();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        txtSId.textProperty().addListener((observable, oldValue, newValue) -> {
            ValidationUtil.validate("^(S)[0-9]+$",newValue,txtSId,lblAdd);
        });

        txtSName.textProperty().addListener((observable, oldValue, newValue) -> {
            ValidationUtil.validate("^[A-Z][a-z]*[ ][A-Z][a-z]*$",newValue,txtSName,lblAdd);
        });
        txtEmail.textProperty().addListener((observable, oldValue, newValue) -> {
            ValidationUtil.validate("^[A-z]+$",newValue,txtEmail,lblAdd);
        });
        txtCNo.textProperty().addListener((observable, oldValue, newValue) -> {
            ValidationUtil.validate("^[0-9]+$",newValue,txtCNo,lblAdd);
        });
        txtAddress.textProperty().addListener((observable, oldValue, newValue) -> {
            ValidationUtil.validate("^[A-z]+$",newValue,txtAddress,lblAdd);
        });

        txtNIC.textProperty().addListener((observable, oldValue, newValue) -> {
            ValidationUtil.validate("[0-9]+$",newValue,txtNIC,lblAdd);
        });


    }

    private void loadALLstudent() throws ClassNotFoundException, SQLException {
        Student.getItems().clear();
        ArrayList<Student> allStudent = SearchCrudcontroller.loadAllStudent();


        for (Student student : allStudent) {
            Student.getItems().add(new StudentTM(
                    student.getSId(),
                    student.getSName(),
                    student.getEmail(),
                    student.getCNo(),
                    student.getAddress(),
                    student.getNIC()
            ));
        }
    }




    public void AddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (lblAdd.getText().equalsIgnoreCase("ADD")) {
            boolean b = SearchCrudcontroller.addStudent(new Student(
                            txtSId.getText(),
                            txtSName.getText(),
                            txtEmail.getText(),
                            txtCNo.getText(),
                            txtAddress.getText(),
                            txtNIC.getText()
                    )
            );
            if (b) {
                loadALLstudent();
                clearText();
                new Alert(Alert.AlertType.WARNING, "Student Added Successfully!!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong!!").show();
            }
        } else {
            boolean b = SearchCrudcontroller.updateStudent(new Student(
                            txtSId.getText(),
                            txtSName.getText(),
                            txtEmail.getText(),
                            txtCNo.getText(),
                            txtAddress.getText(),
                            txtNIC.getText()
                    )
            );
            if (b) {
                loadALLstudent();
                new Alert(Alert.AlertType.WARNING, "Student Updated Successfully!!").show();
                lblAdd.setText("Add");
                txtSId.setEditable(true);
                clearText();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something went wrong!!").show();
            }
        }

    }


    public void DeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        StudentTM selectedItem = Student.getSelectionModel().getSelectedItem();

        if (SearchCrudcontroller.deleteStudent(selectedItem.getSId())) {
            loadALLstudent();
            new Alert(Alert.AlertType.WARNING, "Student Deleted Successfully!!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Something went wrong!!").show();
        }
    }


    public void UpdateOnAction(ActionEvent actionEvent) {


        StudentTM selectedItem = Student.getSelectionModel().getSelectedItem();

        txtSId.setText(selectedItem.getSId());
        txtSName.setText(selectedItem.getSName());
        txtEmail.setText(selectedItem.getEmail());
        txtCNo.setText(selectedItem.getCNo());
        txtAddress.setText(selectedItem.getAddress());
        txtNIC.setText(selectedItem.getNIC());

        txtSId.setEditable(false);
        lblAdd.setText("Update");

    }
    public  void clearText(){
        txtCNo.clear();
        txtSId.clear();
        txtSName.clear();
        txtNIC.clear();
        txtEmail.clear();
        txtAddress.clear();
    }

    public void Search(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
        String search = "%" + txtSearch.getText() + "%";

        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            ArrayList<Student> searchStudent = SearchCrudcontroller.searchStudent(search);
            ObservableList<StudentTM> st = FXCollections.observableArrayList();

            for (Student student : searchStudent) {
                st.add(new StudentTM(
                        student.getSId(),
                        student.getSName(),
                        student.getEmail(),
                        student.getCNo(),
                        student.getAddress(),
                        student.getNIC()
                ));
            }


            Student.getItems().clear();
            Student.getItems().addAll(st);
            Student.refresh();
        }
    }
}
