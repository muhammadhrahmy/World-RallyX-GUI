package com.example.worldrallycrosschampionship;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Controller {
    // declaring all the controls id's that will be used in the program.
    @FXML public TextField firstNameText;
    @FXML public TextField lastNameText;
    @FXML public TextField ageText;
    @FXML public TextField carText;
    @FXML public TextField teamText;
    @FXML public TextField pointsText;
    @FXML public Label firstNameErrorLabel;
    @FXML public Label lastNameErrorLabel;
    @FXML public Label ageErrorLabel;
    @FXML public Label carErrorLabel;
    @FXML public Label teamErrorLabel;
    @FXML public Label pointsErrorLabel;
    @FXML public Label addConfirmationLabel;
    @FXML public TextField deletingFirstNameText;
    @FXML public Label deletingFirstNameErrorLabel;
    @FXML public TextField deletingLastNameText;
    @FXML public Label deletingLastNameErrorLabel;
    @FXML public Label deletingNameConfirmation;
    @FXML public TextField updatingFirstNameText;
    @FXML public Label updatingFirstNameErrorLabel;
    @FXML public TextField updatingLastNameText;
    @FXML public Label updatingLastNameErrorLabel;
    @FXML public Label updatingNameConfirmation;
    @FXML public TextField newFirstNameText;
    @FXML public TextField newLastNameText;
    @FXML public TextField newAgeText;
    @FXML public TextField newCarText;
    @FXML public TextField newTeamText;
    @FXML public TextField newPointsText;
    @FXML public Label newFirstNameErrorLabel;
    @FXML public Label newLastNameErrorLabel;
    @FXML public Label newAgeErrorLabel;
    @FXML public Label newCarErrorLabel;
    @FXML public Label newTeamErrorLabel;
    @FXML public Label newPointsErrorLabel;
    @FXML public Label uddConfirmationLabel;
    @FXML private TableView<Driver> rallyCrossChampionshipTable;
    @FXML private TableView<Driver> driverNamesTable;
    @FXML private TableColumn<Driver, String> firstNameColumn;
    @FXML private TableColumn<Driver, String> lastNameColumn;
    @FXML private TableColumn<Driver, Integer> ageColumn;
    @FXML private TableColumn<Driver, String> carColumn;
    @FXML private TableColumn<Driver, String> teamColumn;
    @FXML private TableColumn<Driver, Integer> pointsColumn;
    @FXML private Label srrConfirmationLabel;
    @FXML private TableView<Race> raceTable;
    @FXML private TableColumn<Race, LocalDate> raceDateColumn;
    @FXML private TableColumn<Race, String> raceLocationColumn;
    @FXML private TableColumn<Race, String> raceFirstNameColumn;
    @FXML private TableColumn<Race, String> raceLastNameColumn;
    @FXML private TableColumn<Race, Integer> racePositionColumn;
    @FXML private TableColumn<Race, Integer> racePointsColumn;
    @FXML private Label stfConfirmationLabel;
    @FXML private Label rffConfirmationLabel;

    // declaring and initialising some of the variables that will be used throughout the program.
    ArrayList<Driver> drivers = new ArrayList<>();
    String[] driverDetail, raceDetail;
    ArrayList<Integer> positionsList = new ArrayList<>();
    ArrayList<LocalDate> usedDates = new ArrayList<>();
    ArrayList<Race> racers = new ArrayList<>();
    Driver driver;
    int error;
    boolean driverExists = false;
    String firstName;
    String lastName;
    int age;
    String ageCheck;
    String car;
    String team;
    int points;
    String pointsCheck;
    Race race;
    LocalDate randomDate;
    int year;
    int month;
    int day;
    String randomLocation;
    int position;
    int positionCheck;

    // menu of WRCC is displayed
    public void onNextButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menuWRCC.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onADDButtonClicked() throws IOException {
        // Creating a new stage for the ADD method.
        Stage addStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("addButton.fxml"));
        addStage.setTitle("ADD");
        addStage.setScene(new Scene(root));
        addStage.show();
    }
    // the below six methods are used for junit testing for ADD method
    public boolean isFirstNameValid(String firstName){
        if (firstName.isEmpty()) {
            return false;
        }
        return firstName.matches("[a-zA-Z]+");
    }
    public boolean isLastNameValid(String lastName){
        if (lastName.isEmpty()) {
            return false;
        }
        return lastName.matches("[a-zA-Z]+");
    }
    public boolean isAgeValid(String age){
        if (age.isEmpty()) {
            return false;
        }
        return age.matches("\\d+");
    }
    public boolean isCarValid(String car) {
        return !car.isEmpty();
    }
    public boolean isTeamValid(String team) {
        return !team.isEmpty();
    }
    public boolean isPointsValid(String points){
        if (points.isEmpty()) {
            return false;
        }
        return points.matches("\\d+");
    }
    // the below two methods are used for junit testing for DDD method
    public boolean isDeleteFirstNameValid(String firstName){
        if (firstName.isEmpty()) {
            return false;
        }
        return firstName.matches("[a-zA-Z]+");
    }
    public boolean isDeleteLastNameValid(String lastName){
        if (lastName.isEmpty()) {
            return false;
        }
        return lastName.matches("[a-zA-Z]+");
    }
    // the below eight methods are used for junit testing for UDD method
    public boolean isUpdateFirstNameValid(String firstName){
        if (firstName.isEmpty()) {
            return false;
        }
        return firstName.matches("[a-zA-Z]+");
    }
    public boolean isUpdateLastNameValid(String lastName){
        if (lastName.isEmpty()) {
            return false;
        }
        return lastName.matches("[a-zA-Z]+");
    }
    public boolean isNewFirstNameValid(String firstName){
        if (firstName.isEmpty()) {
            return false;
        }
        return firstName.matches("[a-zA-Z]+");
    }
    public boolean isNewLastNameValid(String lastName){
        if (lastName.isEmpty()) {
            return false;
        }
        return lastName.matches("[a-zA-Z]+");
    }
    public boolean isNewAgeValid(String age){
        if (age.isEmpty()) {
            return false;
        }
        return age.matches("\\d+");
    }
    public boolean isNewCarValid(String car) {
        return !car.isEmpty();
    }
    public boolean isNewTeamValid(String team) {
        return !team.isEmpty();
    }
    public boolean isNewPointsValid(String points){
        if (points.isEmpty()) {
            return false;
        }
        return points.matches("\\d+");
    }
    public void onADDSubmitButtonClicked() throws IOException {
        // variable used to check whether there is any errors in the user inputs.
        error = 0;
        // Getting the first name from the user.
        firstName = firstNameText.getText();
        // Checking if the first name is empty or not.
        if (firstName.isEmpty()) {
            firstNameErrorLabel.setText("Please enter your first name.");
            addConfirmationLabel.setText("");
            error++;
        }
        // Checking if the first name contains only letters.
        else {
            if (firstName.matches("[a-zA-Z]+")) {
                firstNameErrorLabel.setText("");
            } else {
                firstNameErrorLabel.setText("Please enter a valid name.");
                addConfirmationLabel.setText("");
                error++;
            }
        }
        // Getting the last name from the user.
        lastName = lastNameText.getText();
        // Checking if the last name is empty or not.
        if (lastName.isEmpty()) {
            lastNameErrorLabel.setText("Please enter your last name.");
            addConfirmationLabel.setText("");
            error++;
        }
        // Checking if the last name contains only letters.
        else {
            if (lastName.matches("[a-zA-Z]+")) {
                lastNameErrorLabel.setText("");
            } else {
                lastNameErrorLabel.setText("Please enter a valid name.");
                addConfirmationLabel.setText("");
                error++;
            }
        }
        // Getting the age from the user.
        ageCheck = ageText.getText();
        // Checking if the age is empty or not.
        if (ageCheck.isEmpty()) {
            ageErrorLabel.setText("Please enter your age.");
            addConfirmationLabel.setText("");
            error++;
        }
        // Checking if the age contains only numbers.
        else if (!ageCheck.matches("\\d+")) {
            ageErrorLabel.setText("Please enter a valid age.");
            addConfirmationLabel.setText("");
            error++;
        } else {
            age = Integer.parseInt(ageCheck);
            ageErrorLabel.setText("");
        }
        // Getting the car name from the user.
        car = carText.getText();
        // Checking if the car name is empty or not.
        if (car.isEmpty()) {
            carErrorLabel.setText("Please enter the name of the car.");
            addConfirmationLabel.setText("");
            error++;
        } else {
            carErrorLabel.setText("");
        }
        // Getting the team name from the user.
        team = teamText.getText();
        // Checking if the team name is empty or not.
        if (team.isEmpty()) {
            teamErrorLabel.setText("Please enter the name of the team.");
            addConfirmationLabel.setText("");
            error++;
        } else {
            teamErrorLabel.setText("");
        }
        // Getting the points from the user.
        pointsCheck = pointsText.getText();
        // Checking if the points is empty or not.
        if (pointsCheck.isEmpty()) {
            pointsErrorLabel.setText("Please enter the points.");
            addConfirmationLabel.setText("");
            error++;
        }
        // checking if the points contain only numbers.
        else if (!pointsCheck.matches("\\d+")) {
            pointsErrorLabel.setText("Please enter a valid number for the points.");
            addConfirmationLabel.setText("");
            error++;
        } else {
            points = Integer.parseInt(pointsCheck);
            pointsErrorLabel.setText("");
        }
        // checking whether there is no errors in the user inputs.
        if (error == 0) {
            // reading the whole text file using file reader and reading each line using buffered reader.
            BufferedReader bufferedReader = new BufferedReader(new FileReader("driver_details.txt"));
            String line;
            // variable used to check whether the driver exists.
            driverExists = false;
            // reading the whole file until a line with no driver details is found.
            while ((line = bufferedReader.readLine()) != null) {
                // saving the driver details in an array temporarily.
                driverDetail = line.split(",");
                // checking if the driver names entered by the user is already present in the text file, if so it will exit the loop.
                if ((driverDetail[0].equals(firstName)) && (driverDetail[1].equals(lastName))) {
                    driverExists = true;
                    break;
                }
            }
            // closing the reader.
            bufferedReader.close();
            // if the driver already exists a message will be displayed saying that the driver exists, and the user will be able to renter the details.
            if (driverExists) {
                addConfirmationLabel.setText("This driver already exists, please enter a new driver.");
                firstNameText.clear();
                lastNameText.clear();
                ageText.clear();
                carText.clear();
                teamText.clear();
                pointsText.clear();
            }
            // if the driver is not present in the text file the details will be saved in a driver referential variable of class Driver, which will then be added to the drivers ArrayList.
            else {
                driver = new Driver(firstName, lastName, age, car, team, points);
                drivers.add(driver);
                addConfirmationLabel.setText("Thank you, the details are recorded.");
                firstNameText.clear();
                lastNameText.clear();
                ageText.clear();
                carText.clear();
                teamText.clear();
                pointsText.clear();
                // the details of the driver will then be added to the text file.
                FileWriter writer = new FileWriter("driver_details.txt", true);
                for (Driver driver : drivers) {
                    writer.write(driver.getFirstName() + "," + driver.getLastName() + "," + driver.getAge() + "," + driver.getCar() + "," + driver.getTeam() + "," + driver.getPoints() + "\n");
                }
                // the writer is closed, and the drivers list is made empty.
                writer.close();
                drivers.clear();
            }
        }
        // if there were errors in the driver details entered by the user a message will be displayed saying that an error was found and to re-enter the details.
        else if (error == 6){
            firstNameText.clear();
            lastNameText.clear();
            ageText.clear();
            carText.clear();
            teamText.clear();
            pointsText.clear();
        }
    }
    public void onDDDButtonClicked() throws IOException {
        // creating a new stage for the DDD method.
        Stage dddStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("dddButton.fxml"));
        dddStage.setTitle("DDD");
        dddStage.setScene(new Scene(root));
        dddStage.show();
    }
    public void onDriverNamesLoadButtonClicked() throws IOException {
        // calling the loadDriverNames method
        loadingNamesOfDrivers();
    }
    public void onDDDSubmitButtonClicked () throws IOException {
        // variables used to check whether the name is present in the text file.
        boolean foundDriver = false;
        String deleteFirstName = null;
        String deleteLastName = null;
        int error = 0;
        // Getting the first name of the driver to delete from the user.
        String firstNameCheck = deletingFirstNameText.getText();
        // checking if the first name is empty.
        if (firstNameCheck.isEmpty()) {
            deletingFirstNameErrorLabel.setText("Please enter your first name to delete.");
            deletingNameConfirmation.setText("");
            error++;
        }
        else {
            // checking if the user has entered only letters for the first name.
            if (firstNameCheck.matches("[a-zA-Z]+")) {
                deletingFirstNameErrorLabel.setText("");
                deleteFirstName = firstNameCheck;
            } else {
                deletingFirstNameErrorLabel.setText("Please enter a valid name to delete.");
                deletingNameConfirmation.setText("");
                error++;
            }
        }
        // Getting the last name of the driver to delete from the user.
        String lastNameCheck = deletingLastNameText.getText();
        // checking if the last name is empty.
        if (lastNameCheck.isEmpty()) {
            deletingLastNameErrorLabel.setText("Please enter your last name to delete.");
            deletingNameConfirmation.setText("");
            error++;
        } else {
            // checking if the user has entered only letters for the last name.
            if (lastNameCheck.matches("[a-zA-Z]+")) {
                deletingLastNameErrorLabel.setText("");
                deleteLastName = lastNameCheck;
            } else {
                deletingLastNameErrorLabel.setText("Please enter a valid name to delete.");
                deletingNameConfirmation.setText("");
                error++;
            }
        }
        // checking if there are any errors in the inputs done by the user.
        if (error == 0){
            // reading the text file.
            BufferedReader bufferedReader = new BufferedReader(new FileReader("driver_details.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // saving all the driver details in an array where each detail gets an index.
                driverDetail = line.split(",");
                firstName = driverDetail[0];
                lastName = driverDetail[1];
                age = Integer.parseInt(driverDetail[2]);
                car = driverDetail[3];
                team = driverDetail[4];
                points = Integer.parseInt(driverDetail[5]);
                // checking if the names entered to delete by the user is same as the names in the line read by the buffered reader.
                if ((driverDetail[0].equals(deleteFirstName)) && (driverDetail[1].equals(deleteLastName))) {
                    // if it is present then a popup message will be displayed and asked to confirm whether the user wants to delete the details or not.
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Deleting drivers details");
                    alert.setHeaderText("Do you really want to delete the details of the mentioned driver?");
                    // if the user agrees to the popup message the driver will not be added to the array list.
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        deletingFirstNameText.clear();
                        deletingLastNameText.clear();
                        deletingNameConfirmation.setText("The above mentioned driver's details are deleted");
                    }
                    // if he does not agree to the popup message the driver will be added to the array list.
                    else {
                        driver = new Driver(firstName, lastName, age, car, team, points);
                        drivers.add(driver);
                        deletingNameConfirmation.setText("");
                    }
                    foundDriver = true;
                }
                // if the names entered to delete by the user is not same as the names in the line read by the buffered reader that specific driver details will be added to the array list.
                else {
                    driver = new Driver(firstName, lastName, age, car, team, points);
                    drivers.add(driver);
                }
            }
            // the driver details present in the array list will then be written onto the text file.
            FileWriter writer = new FileWriter("driver_details.txt");
            for (Driver racer : drivers) {
                writer.write(racer.getFirstName() + "," + racer.getLastName() + "," + racer.getAge() + "," + racer.getCar() + "," + racer.getTeam() + "," + racer.getPoints() + "\n");
            }
            // the writer is closed, and the arraylist is made empty.
            writer.close();
            drivers.clear();
            // if the driver names entered by the user to delete is not present in the text file an error message will be displayed saying that the driver was not found.
            if (!foundDriver){
                deletingNameConfirmation.setText("The above driver name was not found, please re-enter.");
                deletingFirstNameText.clear();
                deletingLastNameText.clear();
            }
            bufferedReader.close();
        }
        // if there were errors in the driver names entered by the user a message will be displayed saying that an error was found and to re-enter the names.
        else{
            deletingFirstNameText.clear();
            deletingLastNameText.clear();
        }
    }
    public void onUDDButtonClicked() throws IOException {
        // creating a new stage for the UDD method.
        Stage uddStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("uddButton1.fxml"));
        uddStage.setTitle("UDD");
        uddStage.setScene(new Scene(root));
        uddStage.show();
    }
    public void onUDDSubmitButtonClicked(ActionEvent event) throws IOException {
        // firstly the user will be asked what is the name of the driver he wants to update, and that driver details will be deleted as explained in the DDD method.
        boolean foundDriver = false;
        String updateFirstName = null;
        String updateLastName = null;
        int error = 0;
        String firstNameCheck = updatingFirstNameText.getText();
        if (firstNameCheck.isEmpty()) {
            updatingFirstNameErrorLabel.setText("Please enter your first name to update.");
            updatingNameConfirmation.setText("");
            error++;
        }
        else {
            if (firstNameCheck.matches("[a-zA-Z]+")) {
                updatingFirstNameErrorLabel.setText("");
                updateFirstName = firstNameCheck;
            } else {
                updatingFirstNameErrorLabel.setText("Please enter a valid name to update.");
                updatingNameConfirmation.setText("");
                error++;
            }
        }
        String lastNameCheck = updatingLastNameText.getText();
        if (lastNameCheck.isEmpty()) {
            updatingLastNameErrorLabel.setText("Please enter your last name to update.");
            updatingNameConfirmation.setText("");
            error++;
        } else {
            if (lastNameCheck.matches("[a-zA-Z]+")) {
                updatingLastNameErrorLabel.setText("");
                updateLastName = lastNameCheck;
            } else {
                updatingLastNameErrorLabel.setText("Please enter a valid name to update.");
                updatingNameConfirmation.setText("");
                error++;
            }
        }
        if (error == 0){
            BufferedReader bufferedReader = new BufferedReader(new FileReader("driver_details.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                driverDetail = line.split(",");
                firstName = driverDetail[0];
                lastName = driverDetail[1];
                age = Integer.parseInt(driverDetail[2]);
                car = driverDetail[3];
                team = driverDetail[4];
                points = Integer.parseInt(driverDetail[5]);
                if ((driverDetail[0].equals(updateFirstName)) && (driverDetail[1].equals(updateLastName))) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Updating drivers details");
                    alert.setHeaderText("Do you really want to update the details of the mentioned driver?");
                    // if the user confirms that he wants to update the entered driver a new scene will be shown in the same stage as explained below.
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        Parent root = FXMLLoader.load(getClass().getResource("uddButton2.fxml"));
                        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }
                    else {
                        driver = new Driver(firstName, lastName, age, car, team, points);
                        drivers.add(driver);
                        updatingNameConfirmation.setText("");
                    }
                    foundDriver = true;
                }
                else {
                    driver = new Driver(firstName, lastName, age, car, team, points);
                    drivers.add(driver);
                }
            }
            FileWriter writer = new FileWriter("driver_details.txt");
            for (Driver racer : drivers) {
                writer.write(racer.getFirstName() + "," + racer.getLastName() + "," + racer.getAge() + "," + racer.getCar() + "," + racer.getTeam() + "," + racer.getPoints() + "\n");
            }
            writer.close();
            drivers.clear();
            if (!foundDriver){
                updatingNameConfirmation.setText("The above driver name was not found, please re-enter.");
                updatingFirstNameText.clear();
                updatingLastNameText.clear();
            }
            bufferedReader.close();
        }
        else{
            updatingFirstNameText.clear();
            updatingLastNameText.clear();
        }
    }
    public void onNewDetailsSubmitButtonClicked(ActionEvent event) throws IOException {
        // in the new scene the user will be shown the new details to be entered and the driver details entered will be added as explained in the ADD method.
        error = 0;
        firstName = newFirstNameText.getText();
        if (firstName.isEmpty()) {
            newFirstNameErrorLabel.setText("Please enter your first name.");
            uddConfirmationLabel.setText("");
            error++;
        } else {
            if (firstName.matches("[a-zA-Z]+")) {
                newFirstNameErrorLabel.setText("");
            } else {
                newFirstNameErrorLabel.setText("Please enter a valid name.");
                uddConfirmationLabel.setText("");
                error++;
            }
        }
        lastName = newLastNameText.getText();
        if (lastName.isEmpty()) {
            newLastNameErrorLabel.setText("Please enter your last name.");
            uddConfirmationLabel.setText("");
            error++;
        } else {
            if (lastName.matches("[a-zA-Z]+")) {
                newLastNameErrorLabel.setText("");
            } else {
                newLastNameErrorLabel.setText("Please enter a valid name.");
                uddConfirmationLabel.setText("");
                error++;
            }
        }
        ageCheck = newAgeText.getText();
        if (ageCheck.isEmpty()) {
            newAgeErrorLabel.setText("Please enter your age.");
            uddConfirmationLabel.setText("");
            error++;
        } else if (!ageCheck.matches("\\d+")) {
            newAgeErrorLabel.setText("Please enter a valid age.");
            uddConfirmationLabel.setText("");
            error++;
        } else {
            age = Integer.parseInt(ageCheck);
            newAgeErrorLabel.setText("");
        }
        car = newCarText.getText();
        if (car.isEmpty()) {
            newCarErrorLabel.setText("Please enter the name of the car.");
            uddConfirmationLabel.setText("");
            error++;
        } else {
            newCarErrorLabel.setText("");
        }
        team = newTeamText.getText();
        if (team.isEmpty()) {
            newTeamErrorLabel.setText("Please enter the name of the team.");
            uddConfirmationLabel.setText("");
            error++;
        } else {
            newTeamErrorLabel.setText("");
        }
        pointsCheck = newPointsText.getText();
        if (pointsCheck.isEmpty()) {
            newPointsErrorLabel.setText("Please enter the points.");
            uddConfirmationLabel.setText("");
            error++;
        } else if (!pointsCheck.matches("\\d+")) {
            newPointsErrorLabel.setText("Please enter a valid number for the points.");
            uddConfirmationLabel.setText("");
            error++;
        } else {
            points = Integer.parseInt(pointsCheck);
            newPointsErrorLabel.setText("");
        }
        if (error == 0) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("driver_details.txt"));
            String line;
            driverExists = false;
            while ((line = bufferedReader.readLine()) != null) {
                driverDetail = line.split(",");
                if ((driverDetail[0].equals(firstName)) && (driverDetail[1].equals(lastName))) {
                    driverExists = true;
                    break;
                }
            }
            bufferedReader.close();
            // if the new driver to be added already is present then a message will be displayed saying that the driver already exists, and to add new driver details.
            if (driverExists) {
                uddConfirmationLabel.setText("This driver already exists, please enter a new driver.");
                newFirstNameText.clear();
                newLastNameText.clear();
                newAgeText.clear();
                newCarText.clear();
                newTeamText.clear();
                newPointsText.clear();
            }
            // if the new driver to be added is not present the new driver details will be added and a new scene will be shown and a message will be displayed saying that the driver details are saved, and he can exit the window to access the menu.
            else {
                driver = new Driver(firstName, lastName, age, car, team, points);
                drivers.add(driver);
                uddConfirmationLabel.setText("Thank you, the driver details are updated.");
                newFirstNameText.clear();
                newLastNameText.clear();
                newAgeText.clear();
                newCarText.clear();
                newTeamText.clear();
                newPointsText.clear();
                FileWriter writer = new FileWriter("driver_details.txt", true);
                for (Driver racer : drivers) {
                    writer.write(racer.getFirstName() + "," + racer.getLastName() + "," + racer.getAge() + "," + racer.getCar() + "," + racer.getTeam() + "," + racer.getPoints() + "\n");
                }
                writer.close();
                drivers.clear();
            }
        }
        else if (error == 6){
            newFirstNameText.clear();
            newLastNameText.clear();
            newAgeText.clear();
            newCarText.clear();
            newTeamText.clear();
            newPointsText.clear();
        }
    }
    public void onVCTButtonClicked() throws IOException {
        // creating a new stage for the VCT method.
        Stage vctStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("vctButton.fxml"));
        vctStage.setTitle("VCT");
        vctStage.setScene(new Scene(root));
        vctStage.show();
    }
    public void onVCTLoadButtonClicked() throws IOException {
        // calling the loading driver details method.
        loadingDriverDetails();
        // a variable named amountOfDrivers is initialised to the size of the drivers array list.
        int amountOfDrivers = drivers.size();
        Driver temp;
        // bubble sorting is implemented to check line by line.
        for (int i = 0; i < amountOfDrivers - 1; i++) {
            for (int j = 0; j < amountOfDrivers - i - 1; j++) {
                // if there is a point of a specific driver which is less than the driver's point which is below it the driver details of the two drivers will be swapped.
                if (drivers.get(j).getPoints() < drivers.get(j+1).getPoints()) {
                    temp = drivers.get(j);
                    drivers.set(j, drivers.get(j+1));
                    drivers.set(j+1, temp);
                }
            }
        }
        // an observable list is used to store the sorted driver details.
        ObservableList<Driver> sortedDriverDetails = FXCollections.observableArrayList(drivers);
        // each column of the table is initialised.
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        carColumn.setCellValueFactory(new PropertyValueFactory<>("car"));
        teamColumn.setCellValueFactory(new PropertyValueFactory<>("team"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        // the sorted driver details will be added to the respective columns of the table.
        rallyCrossChampionshipTable.setItems(sortedDriverDetails);
        drivers.clear();
    }
    public void onSRRButtonClicked() throws IOException {
        // creating a new stage for the SRR method.
        Stage srrStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("srrButton.fxml"));
        srrStage.setTitle("SRR");
        srrStage.setScene(new Scene(root));
        srrStage.show();
    }
    public void onSimulateButtonClicked() throws IOException {
        // initialising a variable named random of the class Random which is inbuilt in java.
        Random random = new Random();
        String line;
        LocalDate usedDate;
        // reading each line of the text file used_dates and adding the dates in the text file into an array list of type localDate.
        BufferedReader usedDatesReader = new BufferedReader(new FileReader("used_dates.txt"));
        while ((line = usedDatesReader.readLine()) != null) {
            usedDate = LocalDate.parse(line);
            usedDates.add(usedDate);
        }
        usedDatesReader.close();
        // the system generates a new date which is not already picked by referring to the used dates array list.
        do {
            year = random.nextInt(1) + 2023;
            month = random.nextInt(12) + 1;
            day = random.nextInt(30) + 1;
            randomDate = LocalDate.of(year, month, day);
        } while (usedDates.contains(randomDate));
        // the new date will be added to the used dates array list.
        usedDates.add(randomDate);
        // the used dates text file will be updated with the new date.
        FileWriter usedDatesWriter = new FileWriter("used_dates.txt");
        for (LocalDate date : usedDates) {
            usedDatesWriter.write(date.toString() + "\n");
        }
        usedDatesWriter.close();
        // the system will randomly generate a location of the race from the below 6 locations.
        String[] locations = {"Nyirad", "Holjes", "Montalegre", "Barcelona", "Riga", "Norway"};
        randomLocation = locations[random.nextInt(locations.length)];
        loadingDriverDetails();
        // the system will generate a position for all drivers in order and save it in the positions array list.
        for (int driverPosition = 1; driverPosition <= drivers.size(); driverPosition++) {
            positionsList.add(driverPosition);
        }
        // the above-mentioned positions array list will be shuffled to make sure that the position is random and doesn't get generated in order.
        Collections.shuffle(positionsList);
        // the driver details text file is read line by line.
        BufferedReader driverDetailsReader = new BufferedReader(new FileReader("driver_details.txt"));
        while ((line = driverDetailsReader.readLine()) != null) {
            // saving all the driver details in an array where each detail gets an index.
            driverDetail = line.split(",");
            firstName = driverDetail[0];
            lastName = driverDetail[1];
            points = Integer.parseInt(driverDetail[5]);
            position = positionsList.get(0);
            positionsList.remove(0);
            // now the date, location, position and first and last names will of all the drivers will be saved in the variable race of class Race, which will then be added to the arraylist of type Race.
            race = new Race(randomDate, randomLocation, firstName, lastName, position, points);
            racers.add(race);
        }
        driverDetailsReader.close();
        // checks for all drivers positions and update the points for the 1st, 2nd and 3rd driver respectively as shown below.
        for (Race race : racers) {
            positionCheck = race.getPosition();
            if (positionCheck == 1) {
                race.setPoints(race.getPoints() + 10);
            } else if (positionCheck == 2) {
                race.setPoints(race.getPoints() + 7);
            } else if (positionCheck == 3) {
                race.setPoints(race.getPoints() + 5);
            } else {
                race.setPoints(race.getPoints());
            }
        }
        // the updated race details will then be appended from the racers arraylist into the race_details text file.
        FileWriter raceDetailsWriter = new FileWriter("race_details.txt", true);
        for (Race race : racers) {
            raceDetailsWriter.write(race.getDate() + "," + race.getLocation() + "," + race.getFirstName() + "," + race.getLastName() + "," + race.getPosition() + "," + race.getPoints() + "\n");
        }
        raceDetailsWriter.close();
        // the drivers arraylist will also be updated with the new points.
        for (int i = 0; i < drivers.size(); i++) {
            race = racers.get(i);
            driver = drivers.get(i);
            driver.setPoints(race.getPoints());
        }
        // the updated driver details will then be written into the driver_details text file.
        FileWriter driverDetailsWriter = new FileWriter("driver_details.txt");
        for (Driver driver : drivers) {
            driverDetailsWriter.write(driver.getFirstName() + "," + driver.getLastName() + "," + driver.getAge() + "," + driver.getCar() + "," + driver.getTeam() + "," + driver.getPoints() + "\n");
        }
        driverDetailsWriter.close();
        // an observable list is used to store the race which is simulated.
        ObservableList<Race> simulateRace = FXCollections.observableArrayList(racers);
        // each column of the table is initialised.
        raceDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        raceLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        raceFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        raceLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        racePositionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        racePointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        // the simulated race details will be added to the respective columns of the table.
        raceTable.setItems(simulateRace);
        // all the arraylists will be made empty.
        drivers.clear();
        racers.clear();
        usedDates.clear();
        srrConfirmationLabel.setText("The race has been added to race_details.txt");
    }
    public void onVRLButtonClicked() throws IOException {
        // creating a new stage for the VRL method.
        Stage vrlStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("vrlButton.fxml"));
        vrlStage.setTitle("VRL");
        vrlStage.setScene(new Scene(root));
        vrlStage.show();
    }
    public void onVRLLoadButtonClicked() throws IOException {
        // calling the loading race details method.
        loadingRaceDetails();
        // a variable named amountOfRaces is initialised to the size of the racers array list.
        int amountOfRaces = racers.size();
        // bubble sorting is implemented to check line by line.
        for (int i = 0; i < amountOfRaces - 1; i++) {
            for (int j = 0; j < amountOfRaces - i - 1; j++) {
                // if there is a date of a specific race which comes before the race's date which is above it the race details of the two races will be swapped.
                if (racers.get(j).getDate().isAfter(racers.get(j + 1).getDate())) {
                    Collections.swap(racers, j, j + 1);
                }
            }
        }
        // an observable list is used to store the sorted race details.
        ObservableList<Race> sortedRaceDetails = FXCollections.observableArrayList(racers);
        // each column of the table is initialised.
        raceDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        raceLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        raceFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        raceLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        racePositionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        racePointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        // the sorted race details will be added to the respective columns of the table.
        raceTable.setItems(sortedRaceDetails);
        racers.clear();
    }
    public void onSTFButtonClicked() throws IOException {
        // creating a new stage for the STF method.
        Stage stfStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("stfButton.fxml"));
        stfStage.setTitle("STF");
        stfStage.setScene(new Scene(root));
        stfStage.show();

    }
    public void onSaveDriverDetailsButtonClicked() throws IOException {
        // calling the loading driver details method.
        loadingDriverDetails();
        // creating a new file named driver_details and the driver details presents in the drivers arraylist will be written into the text file.
        FileWriter writer = new FileWriter("driver_details.txt");
        for (Driver racer : drivers) {
            writer.write(racer.getFirstName() + "," + racer.getLastName() + "," + racer.getAge() + "," + racer.getCar() + "," + racer.getTeam() + "," + racer.getPoints() + "\n");
        }
        // the writer is closed and the drivers arraylist will be made empty.
        writer.close();
        drivers.clear();
        stfConfirmationLabel.setText("Driver details are saved in driver_details.txt");
    }
    public void onSaveRaceDetailsButtonClicked() throws IOException {
        // calling the loading race details method.
        loadingRaceDetails();
        // creating a new file named race_details and the race details presents in the racers arraylist will be written into the text file.
        FileWriter writer = new FileWriter("race_details.txt");
        for (Race race : racers) {
            writer.write(race.getDate() + "," + race.getLocation() + "," + race.getFirstName() + "," + race.getLastName() + "," + race.getPosition() + "," + race.getPoints() + "\n");
        }
        // the writer is closed and the racers arraylist will be made empty.
        writer.close();
        racers.clear();
        stfConfirmationLabel.setText("Race details are saved in race_details.txt");
    }
    public void onRFFButtonClicked() throws IOException {
        // creating a new stage for the RFF method.
        Stage rffStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("rffButton.fxml"));
        rffStage.setTitle("RFF");
        rffStage.setScene(new Scene(root));
        rffStage.show();
    }
    public void onLoadDriverDetailsButtonClicked() throws IOException {
        // calling the loading driver details method.
        loadingDriverDetails();
        drivers.clear();
        rffConfirmationLabel.setText("Driver details is loaded into the drivers ArrayList");
    }
    public void onLoadRaceDetailsButtonClicked() throws IOException {
        // calling the loading race details method.
        loadingRaceDetails();
        racers.clear();
        rffConfirmationLabel.setText("Race details is loaded into the racers ArrayList");
    }
    public void loadingDriverDetails() throws IOException {
        // the driver details text file is read line by line.
        BufferedReader bufferedReader = new BufferedReader(new FileReader("driver_details.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            // saving all the driver details in an array where each detail gets an index.
            driverDetail = line.split(",");
            firstName = driverDetail[0];
            lastName = driverDetail[1];
            age = Integer.parseInt(driverDetail[2]);
            car = driverDetail[3];
            team = driverDetail[4];
            points = Integer.parseInt(driverDetail[5]);
            // now the first name, last name, age, car, team and points will of each driver will be saved in the variable driver of class Driver, which will then be added to the arraylist of type Driver.
            driver = new Driver(firstName, lastName, age, car, team, points);
            drivers.add(driver);
        }
        bufferedReader.close();
    }
    public void loadingRaceDetails() throws IOException {
        // the race details text file is read line by line.
        BufferedReader bufferedReader = new BufferedReader(new FileReader("race_details.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            // saving all the race details in an array where each detail gets an index.
            raceDetail = line.split(",");
            randomDate = LocalDate.parse(raceDetail[0]);
            randomLocation = raceDetail[1];
            firstName = raceDetail[2];
            lastName = raceDetail[3];
            position = Integer.parseInt(raceDetail[4]);
            points = Integer.parseInt(raceDetail[5]);
            // now the random date, random location, first name, last name, position and points will of each driver will be saved in the variable race of class Race, which will then be added to the arraylist of type Race.
            race = new Race(randomDate, randomLocation, firstName, lastName, position, points);
            racers.add(race);
        }
        bufferedReader.close();
    }
    public void loadingNamesOfDrivers() throws IOException {
        // calling the loading driver details method.
        loadingDriverDetails();
        // an observable list is used to store the driver details.
        ObservableList<Driver> driverNames = FXCollections.observableArrayList(drivers);
        // each column of the table is initialised.
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        // the driver names will be added to the respective columns of the table.
        driverNamesTable.setItems(driverNames);
        drivers.clear();
    }
}