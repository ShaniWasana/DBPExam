package controller;

import Model.Student;
import SearchCrudcontroller.SearchCrudcontroller;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import util.CrudUtil;
import util.ValidationUtil;

import java.sql.*;
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
    public TableView<Student> Student;
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
            ValidationUtil.validate("^[0-9]{1,3}$",newValue,txtAddress,lblAdd);
        });

        txtNIC.textProperty().addListener((observable, oldValue, newValue) -> {
            ValidationUtil.validate("^(P)[0-9]+$",newValue,txtNIC,lblAdd);
        });


    }

    private void loadALLstudent() throws ClassNotFoundException, SQLException {
        System.out.println("Load all");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ijse","root","1234");
        String sql="SELECT *FROM student";
        Statement statement=con.createStatement();
        ResultSet result = statement.executeQuery(sql);
        System.out.println(result);

        ObservableList<Student> oblist = FXCollections.observableArrayList();
        while (result.next()){
            oblist.add(
                    new Student(
                            result.getString("SId"),
                            result.getString("SName"),
                            result.getString("Email"),
                            result.getString("CNo"),
                            result.getString("Address"),
                            result.getString("NIC")



                    )
            );
        }
        Student.setItems(oblist);
        System.out.println(oblist);
    }




    public void AddOnAction(ActionEvent actionEvent) {
        Student m = new Student(
                txtSId.getText(),
                txtSName.getText(),
                txtEmail.getText(),
                txtCNo.getText(),
               txtAddress.getText(),
                txtNIC.getText()
        );
        if (DataSet.StudentTable.add(m))
            new Alert(Alert.AlertType.CONFIRMATION, "New Student Added Successfully!").show();
        else
            new Alert(Alert.AlertType.CONFIRMATION, "There  is a error,Please Try Again").show();


        try {
            if (CrudUtil.execute("INSERT INTO student VALUES (?,?,?,?,?,?,?)",
                    m.getSId(),
                    m.getSName(),
                    m.getEmail(),
                    m.getCNo(),
                    m.getAddress(),
                    m.getNIC()
            )) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }



    public void DeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Student selectedItem = Student.getSelectionModel().getSelectedItem();

        BoxBlur blur = new BoxBlur(5, 5, 5);
        StudentA.setEffect(blur);


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you Sure you want to Delete the Student?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Delete");
        alert.setHeaderText("Delete Student!!");
        Optional<ButtonType> buttonType = alert.showAndWait();

        if (buttonType.get().equals(ButtonType.YES)) {
            SearchCrudcontroller.deleteStudent(selectedItem);
            loadALLstudent();

            StudentA.setEffect(null);
        } else {
            StudentA.setEffect(null);
        }

    }


    public void UpdateOnAction(ActionEvent actionEvent) {
    }

    public void Search(KeyEvent keyEvent) {
        if(txtSearch.getText().startsWith("S")){
            ObservableList<Student> ob = FXCollections.observableArrayList(
                    SearchCrudcontroller.searchReportBySId(
                            "%"+txtSearch.getText()+"%"
                    )
            );
            StudentA.setItems(ob);
        }else{
            ObservableList<Student> obj = FXCollections.observableArrayList(SearchCrudcontroller.searchReportBySName("%"+txtSearch.getText()+"%"));
            StudentA.setItems(obj);
        }
    }
}
