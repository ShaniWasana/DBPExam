package SearchCrudcontroller;

import Model.Student;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchCrudcontroller {
    public static ArrayList<String> getlose() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT SId FROM student");
        ArrayList<String>ids =new ArrayList<>();
        while (result.next()){
            ids.add(result.getString(1));

        }
        return ids;

    }

    public static Student getlose(String id) throws SQLException, ClassNotFoundException {
        ResultSet result =CrudUtil.execute("SELECT * FROM student WHERE SId=?",id);

        if(result.next()){
            return new Student(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)
            );
        }
        return null;
    }
    public static void deleteStudent(Student selectedItem) throws SQLException, ClassNotFoundException {
        CrudUtil.execute("DELETE FROM student WHERE SId=?",selectedItem.getSId());

    }

    public static ArrayList<Student> searchReportBySId(String s) {
        ArrayList<Student> arrayList = new ArrayList();

        try {

            ResultSet resultSet = CrudUtil.execute("SELECT * FROM student WHERE student.member_Id LIKE ?",s);
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

    public static ArrayList<Student> searchReportBySName(String s) {
        ArrayList<Student> arrayList = new ArrayList();

        try {

            ResultSet result = CrudUtil.execute("SELECT * FROM student WHERE student.name LIKE ?", s);
            while (result.next()) {
                arrayList.add(new Student(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6)
                ));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return arrayList;


    }
}
