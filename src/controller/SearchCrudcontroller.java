package controller;

import Model.Student;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchCrudcontroller {
    public static boolean addStudent(Student student) throws SQLException, ClassNotFoundException {


        if (CrudUtil.execute("INSERT INTO Student VALUES (?,?,?,?,?,?)",student.getSId(),student.getSName(),student.getEmail(),student.getCNo(),student.getAddress(),student.getNIC())){
            return true;
        }
        return false;
    }

    public static boolean updateStudent(Student student) throws SQLException, ClassNotFoundException{

        if(CrudUtil.execute("UPDATE Student SET SId = ?,SName = ?,email = ?, CNo = ?, address = ?,nic = ? WHERE SId = ? ",student.getSId(),student.getSName(),student.getEmail(),student.getCNo(),student.getAddress(),student.getNIC(),student.getSId())){

            return true;
        }
        return false;
    }


    public static boolean deleteStudent(String selectedItem) throws SQLException, ClassNotFoundException {

        return CrudUtil.execute("DELETE FROM student WHERE SId=?",selectedItem);


    }

    public static ArrayList<Student> searchReportBySId(String s) {
        ArrayList<Student> arrayList = new ArrayList();

        try {

            ResultSet resultSet = CrudUtil.execute("SELECT * FROM student WHERE student.SId LIKE ?",s);
            while(resultSet.next()){
                arrayList.add(new Student(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                ));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return arrayList;

    }

    public static ArrayList<Student> searchStudent(String s) throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM student where student.SId LIKE ? OR student.SName LIKE ? OR email LIKE ? OR student.CNo LIKE ? OR address LIKE ? OR nic LIKE ?", s,s,s,s,s,s);
        ArrayList<Student> list = new ArrayList<>();

        while (result.next()) {
            list.add(new Student(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)

            ));
        }
        return list;


    }
    public static ArrayList<Student> loadAllStudent() throws SQLException, ClassNotFoundException {
        ResultSet resultset = CrudUtil.execute("SELECT * FROM student");

        ArrayList<Student> stList=new ArrayList<>();

        while(resultset.next()){
            stList.add(new Student(
                    resultset.getString(1),
                    resultset.getString(2),
                    resultset.getString(3),
                    resultset.getString(4),
                    resultset.getString(5),
                    resultset.getString(6)
            ));
        }

        return stList;

    }
}
