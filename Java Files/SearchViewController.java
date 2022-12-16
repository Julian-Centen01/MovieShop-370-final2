package com.example.ryanjanis_project;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private Label authWarning;
    @FXML
    private Button returnToTableView;
    @FXML
    private TextField textSearchField;

    @FXML
    private TableView<HRData> HRDataTable;

    @FXML
    private TableView<HumanResourcesEmployee> HREmpTable;

    @FXML
    private TableView<PRData> PRDataTable;

    @FXML
    private TableView<PayrollEmployee> PREmpTable;

    @FXML
    private TableView<SEData> SEDataTable;

    @FXML
    private TableView<SoftwareEngineerEmployee> SEEmpTable;

    @FXML
    private TableColumn<userLogins, String> co_FirstName;
    @FXML
    private TableColumn<userLogins, Integer> co_ID;
    @FXML
    private TableColumn<userLogins, String> co_LastName;
    @FXML
    private TableColumn<userLogins, String> co_Password;
    @FXML
    private TableColumn<userLogins, String> co_Username;
    @FXML
    private TableColumn<HumanResourcesEmployee, String> co_HREmpEmail;
    @FXML
    private TableColumn<HumanResourcesEmployee, String> co_HREmpFirstName;
    @FXML
    private TableColumn<HumanResourcesEmployee, Integer> co_HREmpID;
    @FXML
    private TableColumn<HumanResourcesEmployee, String> co_HREmpLastName;
    @FXML
    private TableColumn<HumanResourcesEmployee, String> co_HREmpPhone;
    @FXML
    private TableColumn<HumanResourcesEmployee, String> co_HREmpRole;
    @FXML
    private TableColumn<PayrollEmployee, String> co_PREmpEmail;
    @FXML
    private TableColumn<PayrollEmployee, String> co_PREmpFirstName;
    @FXML
    private TableColumn<PayrollEmployee, Integer> co_PREmpID;
    @FXML
    private TableColumn<PayrollEmployee, String> co_PREmpLastName;
    @FXML
    private TableColumn<PayrollEmployee, String> co_PREmpPhone;
    @FXML
    private TableColumn<PayrollEmployee, String> co_PREmpRole;
    @FXML
    private TableColumn<SoftwareEngineerEmployee, String> co_SEEmpEmail;
    @FXML
    private TableColumn<SoftwareEngineerEmployee, String> co_SEEmpFirstName;
    @FXML
    private TableColumn<SoftwareEngineerEmployee, Integer> co_SEEmpID;
    @FXML
    private TableColumn<SoftwareEngineerEmployee, String> co_SEEmpLastName;
    @FXML
    private TableColumn<SoftwareEngineerEmployee, String> co_SEEmpPhone;
    @FXML
    private TableColumn<SoftwareEngineerEmployee, String> co_SEEmpRole;
    @FXML
    private TableColumn<HRData, String> co_Birthday;
    @FXML
    private TableColumn<HRData, String> co_ECName;
    @FXML
    private TableColumn<HRData, String> co_ECPhone;
    @FXML
    private TableColumn<HRData, Integer> co_HRDataID;
    @FXML
    private TableColumn<HRData, String> co_PersonalPhone;
    @FXML
    private TableColumn<HRData, String> co_PersonalEmail;
    @FXML
    private TableColumn<PRData, String> co_DDNum;
    @FXML
    private TableColumn<PRData, String> co_DDorCheck;
    @FXML
    private TableColumn<PRData, String> co_HoursWeekly;
    @FXML
    private TableColumn<PRData, Integer> co_PRDataID;
    @FXML
    private TableColumn<PRData, String> co_Salary;
    @FXML
    private TableColumn<SEData, Integer> co_ProjectLeadID;
    @FXML
    private TableColumn<SEData, String> co_budget;
    @FXML
    private TableColumn<SEData, String> co_customerName;
    @FXML
    private TableColumn<SEData, String> co_customerEmail;
    @FXML
    private TableColumn<SEData, String> co_projectName;
    @FXML
    private MenuItem selectionHRData;
    @FXML
    private MenuItem selectionHREmp;
    @FXML
    private MenuItem selectionPRData;
    @FXML
    private MenuItem selectionPREmp;
    @FXML
    private MenuItem selectionSEData;
    @FXML
    private MenuItem selectionSEEmp;
    @FXML
    private MenuItem selectionUserLogins;
    @FXML
    private TableView<userLogins> userLoginTable;
    public ObservableList<HumanResourcesEmployee> HREmpList;
    public ObservableList<PayrollEmployee> PREmpList;
    public ObservableList<SoftwareEngineerEmployee> SEEmpList;
    public ObservableList<userLogins> userLoginsList;
    public ObservableList<PRData> PRDataList;
    public ObservableList<HRData> HRDataList;
    public ObservableList<SEData> SEDataList;

    /////////////////////////////////////////////////////////////
    // These control which tables are visible while searching  //
    /////////////////////////////////////////////////////////////
    @FXML
    void onSelectionHRDataPressed(ActionEvent event) {

        validateID();

        if (roleValidate == 1 || roleValidate == 2) {
        userLoginTable.setVisible(false);
        HREmpTable.setVisible(false);
        HRDataTable.setVisible(true);
        PREmpTable.setVisible(false);
        PRDataTable.setVisible(false);
        SEEmpTable.setVisible(false);
        SEDataTable.setVisible(false);
        authWarning.setVisible(false);
    } else {
        authWarning.setVisible(true);
    }
    }
    @FXML
    void onSelectionHREmpPressed(ActionEvent event) {

        validateID();

        if (roleValidate == 1 || roleValidate == 2 || roleValidate == 3) {
            userLoginTable.setVisible(false);
            HREmpTable.setVisible(true);
            HRDataTable.setVisible(false);
            PREmpTable.setVisible(false);
            PRDataTable.setVisible(false);
            SEEmpTable.setVisible(false);
            SEDataTable.setVisible(false);
            authWarning.setVisible(false);
        } else {
            authWarning.setVisible(true);
        }
    }
    @FXML
    void onSelectionPRDataPressed(ActionEvent event) {

        validateID();

        if (roleValidate == 1 || roleValidate == 3) {
            userLoginTable.setVisible(false);
            HREmpTable.setVisible(false);
            HRDataTable.setVisible(false);
            PREmpTable.setVisible(false);
            PRDataTable.setVisible(true);
            SEEmpTable.setVisible(false);
            SEDataTable.setVisible(false);
            authWarning.setVisible(false);
        } else {
            authWarning.setVisible(true);
        }
    }
    @FXML
    void onSelectionPREmpPressed(ActionEvent event) {

        validateID();

        if (roleValidate == 1 || roleValidate == 2 || roleValidate == 3) {
            userLoginTable.setVisible(false);
            HREmpTable.setVisible(false);
            HRDataTable.setVisible(false);
            PREmpTable.setVisible(true);
            PRDataTable.setVisible(false);
            SEEmpTable.setVisible(false);
            SEDataTable.setVisible(false);
            authWarning.setVisible(false);
        } else {
            authWarning.setVisible(true);
        }
    }
    @FXML
    void onSelectionSEDataPressed(ActionEvent event) {

        validateID();

        if (roleValidate == 1 || roleValidate == 4) {
            userLoginTable.setVisible(false);
            HREmpTable.setVisible(false);
            HRDataTable.setVisible(false);
            PREmpTable.setVisible(false);
            PRDataTable.setVisible(false);
            SEEmpTable.setVisible(false);
            SEDataTable.setVisible(true);
            authWarning.setVisible(false);
        } else {
            authWarning.setVisible(true);
        }
    }
    @FXML
    void onSelectionSEEmpPressed(ActionEvent event) {
        userLoginTable.setVisible(false);
        HREmpTable.setVisible(false);
        HRDataTable.setVisible(false);
        PREmpTable.setVisible(false);
        PRDataTable.setVisible(false);
        SEEmpTable.setVisible(true);
        SEDataTable.setVisible(false);
        authWarning.setVisible(false);
    }
    @FXML
    void onSelectionUserLoginsPressed(ActionEvent event) {

        validateID();

        if (roleValidate == 1) {
            userLoginTable.setVisible(true);
            HREmpTable.setVisible(false);
            HRDataTable.setVisible(false);
            PREmpTable.setVisible(false);
            PRDataTable.setVisible(false);
            SEEmpTable.setVisible(false);
            SEDataTable.setVisible(false);
            authWarning.setVisible(false);
        } else {
            authWarning.setVisible(true);
        }
    }

    String currentID; // The variable that holds the ID value of the current user who is logged in
    public int roleValidate = 0; // A variable used to validate who is logged in

    public void getCurrentID()  {
        DatabaseConnection roleConnectAud = new DatabaseConnection(); //establishes connection with database
        Connection connectRoleAud = roleConnectAud.getConnection(); //runs our getConnection function from the DatabaseConnection.java

        String roleNumberAud = "SELECT * FROM rolenum";

        try {
            Statement roleStatement = connectRoleAud.createStatement();
            ResultSet roleResult = roleStatement.executeQuery(roleNumberAud);
            while(roleResult.next()){
                currentID = (roleResult.getString("actualID"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ex.getCause();
        }

    } //Gets the ID of the current user, it is used in many of my functions

    public void onReturnToTableViewPressed(ActionEvent event)throws IOException {
        //This portion will change screens when the Return Button is pushed

        validateID();

            if(roleValidate == 1){
                Parent TableViewParent = FXMLLoader.load(getClass().getResource("ProjectTableView.fxml"));
                Scene TableViewScene = new Scene(TableViewParent);
                //This line will get the stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                window.setScene(TableViewScene);
                window.show();
            } else if(roleValidate == 2) {
                Parent TableViewParent = FXMLLoader.load(getClass().getResource("TableHRView.fxml"));
                Scene TableViewScene = new Scene(TableViewParent);
                //This line will get the stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                window.setScene(TableViewScene);
                window.show();
            } else if(roleValidate == 3) {
                Parent TableViewParent = FXMLLoader.load(getClass().getResource("TablePRView.fxml"));
                Scene TableViewScene = new Scene(TableViewParent);
                //This line will get the stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                window.setScene(TableViewScene);
                window.show();
            } else if(roleValidate == 4) {
                Parent TableViewParent = FXMLLoader.load(getClass().getResource("TableSEView.fxml"));
                Scene TableViewScene = new Scene(TableViewParent);
                //This line will get the stage information
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

                window.setScene(TableViewScene);
                window.show();
            }

    } //Sends the user back to their
    // respective table view

    public void validateID() { //the validation function
        DatabaseConnection connectNow = new DatabaseConnection(); //establishes connection with database
        Connection connectDB = connectNow.getConnection(); //runs our getConnection function from the DatabaseConnection.java

        String verifyLogin = "SELECT roleid FROM rolenum";
        String roleNum = "SELECT actualID FROM rolenum WHERE roleid = 1;";


        // The line above is the SQL query that is input into MySQL that verifies the login
        try {
            //These lines are the activation part of getting the input in the username and password fields
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            Statement roleStatement = connectDB.createStatement();
            ResultSet roleResult = roleStatement.executeQuery(roleNum);
            while(queryResult.next()) {
                if(queryResult.getInt(1) == 1) {
                    while(roleResult.next()) {
                        // These lines use text in the UN and PW fields which then reads the ID of the user and assigns the role accordingly
                        if (roleResult.getInt(1) == 1) {
                            roleValidate = 1;
                        } else if ((roleResult.getInt(1) >= 30001) && (roleResult.getInt(1) < 40000)){
                            roleValidate = 4;
                        } else if ((roleResult.getInt(1) >= 20001) && (roleResult.getInt(1) < 30000)) {
                            roleValidate = 3;
                        } else if ((roleResult.getInt(1) >= 10001) && (roleResult.getInt(1) < 20000)) {
                            roleValidate = 2;
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //The function that handles actual ID validation within the program


    public void initialize(URL url, ResourceBundle rb){
        //This will populate the userLogins table
        co_ID.setCellValueFactory(new PropertyValueFactory<userLogins,Integer>("ID"));
        co_FirstName.setCellValueFactory(new PropertyValueFactory<userLogins,String>("FirstName"));
        co_LastName.setCellValueFactory(new PropertyValueFactory<userLogins,String>("LastName"));
        co_Username.setCellValueFactory(new PropertyValueFactory<userLogins,String>("Username"));
        co_Password.setCellValueFactory(new PropertyValueFactory<userLogins,String>("Password"));

        userLoginsList = DatabaseConnection.getDataUserLogins();
        userLoginTable.setItems(userLoginsList);

        FilteredList<userLogins> filteredDataUL = new FilteredList<>(userLoginsList,b -> true);

        textSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredDataUL.setPredicate(userLogins -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (userLogins.getID().toString().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (userLogins.getFirstName().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (userLogins.getLastName().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (userLogins.getUsername().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (userLogins.getPassword().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<userLogins> sortedDataUL = new SortedList<>(filteredDataUL);

        sortedDataUL.comparatorProperty().bind(userLoginTable.comparatorProperty());

        userLoginTable.setItems(sortedDataUL);


        //This will populate the Payroll Employee Table
        co_PREmpFirstName.setCellValueFactory(new PropertyValueFactory<PayrollEmployee, String>("firstName"));
        co_PREmpLastName.setCellValueFactory(new PropertyValueFactory<PayrollEmployee, String>("lastName"));
        co_PREmpID.setCellValueFactory(new PropertyValueFactory<PayrollEmployee, Integer>("ID"));
        co_PREmpEmail.setCellValueFactory(new PropertyValueFactory<PayrollEmployee, String>("email"));
        co_PREmpPhone.setCellValueFactory(new PropertyValueFactory<PayrollEmployee, String>("phone"));
        co_PREmpRole.setCellValueFactory(new PropertyValueFactory<PayrollEmployee, String>("role"));

        PREmpList = DatabaseConnection.getPREmp();
        PREmpTable.setItems(PREmpList);

        FilteredList<PayrollEmployee> filteredDataPE = new FilteredList<>(PREmpList,b -> true);

        textSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredDataPE.setPredicate(PayrollEmployee -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (PayrollEmployee.getID().toString().contains(searchKeyword)) {
                    return true;
                } else if (PayrollEmployee.getFirstName().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (PayrollEmployee.getLastName().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (PayrollEmployee.getPhone().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (PayrollEmployee.getEmail().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (PayrollEmployee.getRole().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<PayrollEmployee> sortedDataPE = new SortedList<>(filteredDataPE);

        sortedDataPE.comparatorProperty().bind(PREmpTable.comparatorProperty());

        PREmpTable.setItems(sortedDataPE);

        //This will populate the Human Resources Employee Table
        co_HREmpFirstName.setCellValueFactory(new PropertyValueFactory<HumanResourcesEmployee, String>("firstName"));
        co_HREmpLastName.setCellValueFactory(new PropertyValueFactory<HumanResourcesEmployee, String>("lastName"));
        co_HREmpID.setCellValueFactory(new PropertyValueFactory<HumanResourcesEmployee, Integer>("ID"));
        co_HREmpEmail.setCellValueFactory(new PropertyValueFactory<HumanResourcesEmployee, String>("email"));
        co_HREmpPhone.setCellValueFactory(new PropertyValueFactory<HumanResourcesEmployee, String>("phone"));
        co_HREmpRole.setCellValueFactory(new PropertyValueFactory<HumanResourcesEmployee, String>("role"));

        HREmpList = DatabaseConnection.getHREmp();
        HREmpTable.setItems(HREmpList);

        FilteredList<HumanResourcesEmployee> filteredDataHE = new FilteredList<>(HREmpList,b -> true);

        textSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredDataHE.setPredicate(HumanResourcesEmployee -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (HumanResourcesEmployee.getID().toString().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (HumanResourcesEmployee.getFirstName().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (HumanResourcesEmployee.getLastName().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (HumanResourcesEmployee.getEmail().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (HumanResourcesEmployee.getPhone().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (HumanResourcesEmployee.getRole().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<HumanResourcesEmployee> sortedDataHE = new SortedList<>(filteredDataHE);

        sortedDataHE.comparatorProperty().bind(HREmpTable.comparatorProperty());

        HREmpTable.setItems(sortedDataHE);

        //This will populate the Software Engineer Employee Table
        co_SEEmpFirstName.setCellValueFactory(new PropertyValueFactory<SoftwareEngineerEmployee, String>("firstName"));
        co_SEEmpLastName.setCellValueFactory(new PropertyValueFactory<SoftwareEngineerEmployee, String>("lastName"));
        co_SEEmpID.setCellValueFactory(new PropertyValueFactory<SoftwareEngineerEmployee, Integer>("ID"));
        co_SEEmpEmail.setCellValueFactory(new PropertyValueFactory<SoftwareEngineerEmployee, String>("email"));
        co_SEEmpPhone.setCellValueFactory(new PropertyValueFactory<SoftwareEngineerEmployee, String>("phone"));
        co_SEEmpRole.setCellValueFactory(new PropertyValueFactory<SoftwareEngineerEmployee, String>("role"));

        SEEmpList = DatabaseConnection.getSEEmp();
        SEEmpTable.setItems(SEEmpList);

        FilteredList<SoftwareEngineerEmployee> filteredDataSE = new FilteredList<>(SEEmpList,b -> true);

        textSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredDataSE.setPredicate(SoftwareEngineerEmployee -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (SoftwareEngineerEmployee.getID().toString().contains(searchKeyword)) {
                    return true;
                } else if (SoftwareEngineerEmployee.getFirstName().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (SoftwareEngineerEmployee.getLastName().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (SoftwareEngineerEmployee.getPhone().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (SoftwareEngineerEmployee.getEmail().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (SoftwareEngineerEmployee.getRole().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<SoftwareEngineerEmployee> sortedDataSE = new SortedList<>(filteredDataSE);

        sortedDataSE.comparatorProperty().bind(SEEmpTable.comparatorProperty());

        SEEmpTable.setItems(sortedDataSE);

        //This will populate the SE Data Table
        co_ProjectLeadID.setCellValueFactory(new PropertyValueFactory<SEData, Integer>("projectLeadID"));
        co_projectName.setCellValueFactory(new PropertyValueFactory<SEData, String>("projectName"));
        co_budget.setCellValueFactory(new PropertyValueFactory<SEData, String>("budget"));
        co_customerName.setCellValueFactory(new PropertyValueFactory<SEData, String>("customerName"));
        co_customerEmail.setCellValueFactory(new PropertyValueFactory<SEData, String>("customerEmail"));

        SEDataList = DatabaseConnection.getSEData();
        SEDataTable.setItems(SEDataList);

        FilteredList<SEData> filteredDataSD = new FilteredList<>(SEDataList,b -> true);

        textSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredDataSD.setPredicate(SEData -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (SEData.getProjectLeadID().toString().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (SEData.getProjectName().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (SEData.getBudget().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (SEData.getCustomerName().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (SEData.getCustomerEmail().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<SEData> sortedDataSD = new SortedList<>(filteredDataSD);

        sortedDataSD.comparatorProperty().bind(SEDataTable.comparatorProperty());

        SEDataTable.setItems(sortedDataSD);

        //This will populate the HR Data Table
        co_HRDataID.setCellValueFactory(new PropertyValueFactory<HRData, Integer>("ID"));
        co_Birthday.setCellValueFactory(new PropertyValueFactory<HRData, String>("birthday"));
        co_PersonalPhone.setCellValueFactory(new PropertyValueFactory<HRData, String>("PPhone"));
        co_PersonalEmail.setCellValueFactory(new PropertyValueFactory<HRData, String>("PEmail"));
        co_ECName.setCellValueFactory(new PropertyValueFactory<HRData, String>("ECName"));
        co_ECPhone.setCellValueFactory(new PropertyValueFactory<HRData, String>("ECPhone"));

        HRDataList = DatabaseConnection.getHRData();
        HRDataTable.setItems(HRDataList);

        FilteredList<HRData> filteredDataHD = new FilteredList<>(HRDataList,b -> true);

        textSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredDataHD.setPredicate(HRData -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (HRData.getID().toString().contains(searchKeyword)) {
                    return true;
                } else if (HRData.getBirthday().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (HRData.getPPhone().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (HRData.getPEmail().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (HRData.getECName().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (HRData.getECPhone().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<HRData> sortedDataHD = new SortedList<>(filteredDataHD);

        sortedDataHD.comparatorProperty().bind(HRDataTable.comparatorProperty());

        HRDataTable.setItems(sortedDataHD);

        //This populates the PR Data Table
        co_PRDataID.setCellValueFactory(new PropertyValueFactory<PRData, Integer>("ID"));
        co_Salary.setCellValueFactory(new PropertyValueFactory<PRData, String>("salary"));
        co_HoursWeekly.setCellValueFactory(new PropertyValueFactory<PRData, String>("hoursWeekly"));
        co_DDorCheck.setCellValueFactory(new PropertyValueFactory<PRData, String>("DDorCheck"));
        co_DDNum.setCellValueFactory(new PropertyValueFactory<PRData, String>("DDNum"));

        PRDataList = DatabaseConnection.getPRData();
        PRDataTable.setItems(PRDataList);

        FilteredList<PRData> filteredDataPD = new FilteredList<>(PRDataList,b -> true);

        textSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredDataPD.setPredicate(PRData -> {
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (PRData.getID().toString().contains(searchKeyword)) {
                    return true;
                } else if (PRData.getSalary().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (PRData.getHoursWeekly().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (PRData.getDDorCheck().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (PRData.getDDNum().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<PRData> sortedDataPD = new SortedList<>(filteredDataPD);

        sortedDataPD.comparatorProperty().bind(PRDataTable.comparatorProperty());

        PRDataTable.setItems(sortedDataPD);

        userLoginTable.setVisible(false);
        HREmpTable.setVisible(false);
        HRDataTable.setVisible(false);
        PREmpTable.setVisible(false);
        PRDataTable.setVisible(false);
        SEEmpTable.setVisible(false);
        SEDataTable.setVisible(false);
        authWarning.setVisible(false);
        getCurrentID();
    } //Populates all tables
}
