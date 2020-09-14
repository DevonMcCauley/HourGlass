package org.devon.controller;


import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.devon.application.App;
import org.devon.model.Benefit;
import org.devon.model.Employee;
import org.devon.utilities.DBConnection;

import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import static org.devon.controller.LoginScreenController.employeeList;
import static org.devon.utilities.DBConnection.submitQuery;


public class BenefitsController implements Initializable {
    String title;
    String screen;

    //List for combobox... allow user to select state for their beneficiary
    public static ArrayList<Benefit> benefitList = new ArrayList();
    public static ObservableList<String> electedBenefits = FXCollections.observableArrayList();

    //<editor-fold desc="FXML Declarations">
    @FXML
    private TextField txtEmployeeFirstName;
    @FXML
    private TextField txtEmployeeLastName;
    @FXML
    private ListView<String> listviewElectedBenefits;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtBeneficiaryStreetAddress;
    @FXML
    private TextField txtBeneficiaryCity;
    @FXML
    private ChoiceBox<String> cmboxState;
    @FXML
    private TextField txtBeneficiaryZip;
    @FXML
    private TextField txtBeneficiaryRelation;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnEditBeneficiary;

    @FXML
    private ImageView btnLanding;

    @FXML
    private ImageView btnSandSheet;

    @FXML
    private ImageView btnBenefits;

    @FXML
    private ImageView btnTimeOff;

    @FXML
    private ImageView btnAbout;

    @FXML
    private ImageView imgDivider;

    @FXML
    private Button btnModifyBenefits;


    @FXML
    private CheckBox boxMedical;


    @FXML
    private CheckBox boxDental;

    @FXML
    private CheckBox boxVision;

    @FXML
    private CheckBox boxLife;

    @FXML
    private CheckBox boxUnion;

    @FXML
    private CheckBox boxRetirement;

    @FXML
    private CheckBox boxPet;

    @FXML
    private Button btnSaveBenefits;
    //</editor-fold>

    //<editor-fold desc="Benefits Methods">
    @FXML
    void ModifyBenefits(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to edit your benefit options?", ButtonType.YES, ButtonType.CANCEL);
        alert.setTitle("Modify Benefits");
        alert.setHeaderText("Modify Benefits");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.YES) {
            unlockBenefitFields();
            btnSaveBenefits.setDisable(false);
            btnModifyBenefits.setDisable(true);
        }
    }

    @FXML
    void SaveBenefits(ActionEvent event) {
        Employee employee = employeeList.get(0);
        Benefit benefit = benefitList.get(0);
        String benefitsID = benefit.getBenefitID().getValue();

        int medical = 0;
        int dental = 0;
        int vision = 0;
        int life = 0;
        int union = 0;
        int retirement = 0;
        int pet = 0;

        if (boxMedical.isSelected()) {
            medical = 1;
        }
        if (boxDental.isSelected()) {
            dental = 1;
        }
        if (boxVision.isSelected()) {
            vision = 1;
        }
        if (boxLife.isSelected()) {
            life = 1;
        }
        if (boxUnion.isSelected()) {
            union = 1;
        }
        if (boxRetirement.isSelected()) {
            retirement = 1;
        }
        if (boxPet.isSelected()) {
            pet = 1;
        }


        String sqlStatement = "UPDATE benefit SET medical = '" + medical + "', dental = '" + dental + "', vision = '" + vision + "', life = '" + life + "', union_member = '" + union + "', retirement = '" + retirement + "', pet_insurance = '" + pet + "' WHERE benefit_id = " + benefitsID + ";";
        submitQuery(sqlStatement);


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Update Successful", ButtonType.OK);
        alert.setTitle("Successful");
        alert.setHeaderText("Successful");
        alert.showAndWait();

        btnModifyBenefits.setDisable(false);
        lockBenefitFields();
    }


    private void lockBenefitFields() {
        boxMedical.setDisable(true);
        boxDental.setDisable(true);
        boxVision.setDisable(true);
        boxLife.setDisable(true);
        boxUnion.setDisable(true);
        boxRetirement.setDisable(true);
        boxPet.setDisable(true);
    }

    private void unlockBenefitFields() {
        boxMedical.setDisable(false);
        boxDental.setDisable(false);
        boxVision.setDisable(false);
        boxLife.setDisable(false);
        boxUnion.setDisable(false);
        boxRetirement.setDisable(false);
        boxPet.setDisable(false);
    }

    //</editor-fold>



    //<editor-fold desc="Navigation Methods">
    //Brings user to benefits page
    @FXML
    void BenefitsClicked(MouseEvent event) {
        screen = "/view/Benefits.fxml";
        title = "Benefits";
        App.changeScene(screen, title);
    }

    @FXML
    void LandingClicked(MouseEvent event) {
        screen = "/view/LandingPage.fxml";
        title = "LandingPage";
        App.changeScene(screen, title);
    }

    @FXML
    void AboutClicked(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "HourGlass was designed and developed by Devon McCauley. You are using version 1.0", ButtonType.OK);
        alert.setTitle("Information");
        alert.showAndWait();
    }

    @FXML
    void TimeOffClicked(MouseEvent event) {
        screen = "/view/TimeOff.fxml";
        title = "Time Off";
       // Main.changeScene(screen, title);
    }

    @FXML
    void SandSheetClicked(MouseEvent event) {
        screen = "/view/SandSheet.fxml";
        title = "SandSheet";
       // Main.changeScene(screen, title);
    }
    //</editor-fold>

    //<editor-fold desc="Styling Methods for the ImageView/Button Links">
    @FXML
    void changeAboutIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/about2.png");
        Image about = new Image(inStream);
        btnAbout.setImage(about);
    }

    @FXML
    void changeBenefitsIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/benefits2.png");
        Image benefits = new Image(inStream);
        btnBenefits.setImage(benefits);
    }

    @FXML
    void changeLandingIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/landingpage2.png");
        Image landingpage2 = new Image(inStream);
        btnLanding.setImage(landingpage2);
    }

    @FXML
    void changeSandSheetIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/timesheet2.png");
        Image sandsheet = new Image(inStream);
        btnSandSheet.setImage(sandsheet);
    }

    @FXML
    void changeTimeOffIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/timeoff2.png");
        Image timeoff = new Image(inStream);
        btnTimeOff.setImage(timeoff);
    }

    @FXML
    void returnLandingIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/landingpage.png");
        Image landingpage = new Image(inStream);
        btnLanding.setImage(landingpage);
    }

    @FXML
    void returnAboutIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/about.png");
        Image about = new Image(inStream);
        btnAbout.setImage(about);
    }

    @FXML
    void returnBenefitsIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/benefits.png");
        Image benefits = new Image(inStream);
        btnBenefits.setImage(benefits);
    }

    @FXML
    void returnSandSheetIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/timesheet.png");
        Image sandsheet = new Image(inStream);
        btnSandSheet.setImage(sandsheet);
    }

    @FXML
    void returnTimeOffIcon(MouseEvent event) {
        InputStream inStream = getClass().getResourceAsStream("/icons/timeoff.png");
        Image timeoff = new Image(inStream);
        btnTimeOff.setImage(timeoff);
    }
    //</editor-fold>

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listviewElectedBenefits.setDisable(true);
        Employee employee = employeeList.get(0);


        //Creates benefit object and adds currently elected employee benefits to a listview for employee to view
        try {
            String benefitsID = employee.getBenefitsID().getValue();
            txtEmployeeFirstName.setText(employee.getFirstname().getValue());
            txtEmployeeLastName.setText(employee.getLastname().getValue());
            electedBenefits.clear();
            benefitList.clear();

            ResultSet benefitsResult = DBConnection.findBenefits(benefitsID);

            if (benefitsResult.next()) {
                Benefit benefit = new Benefit(new ReadOnlyStringWrapper(benefitsID),
                        new ReadOnlyStringWrapper(benefitsResult.getString("medical")),
                        new ReadOnlyStringWrapper(benefitsResult.getString("dental")),
                        new ReadOnlyStringWrapper(benefitsResult.getString("vision")),
                        new ReadOnlyStringWrapper(benefitsResult.getString("life")),
                        new ReadOnlyStringWrapper(benefitsResult.getString("union_member")),
                        new ReadOnlyStringWrapper(benefitsResult.getString("retirement")),
                        new ReadOnlyStringWrapper(benefitsResult.getString("pet_insurance")));
                benefitList.add(benefit);


                if (Integer.parseInt(benefit.getMedical().getValue()) == 1) {
                    electedBenefits.add("Medical Insurance");
                    boxMedical.setSelected(true);
                }
                if (Integer.parseInt(benefit.getDental().getValue()) == 1) {
                    electedBenefits.add("Dental Insurance");
                    boxDental.setSelected(true);
                }
                if (Integer.parseInt(benefit.getVision().getValue()) == 1) {
                    electedBenefits.add("Vision Insurance");
                    boxVision.setSelected(true);
                }
                if (Integer.parseInt(benefit.getLife().getValue()) == 1) {
                    electedBenefits.add("Life Insurance");
                    boxLife.setSelected(true);
                }
                if (Integer.parseInt(benefit.getUnion_member().getValue()) == 1) {
                    electedBenefits.add("Union Member");
                    boxUnion.setSelected(true);
                }
                if (Integer.parseInt(benefit.getRetirement().getValue()) == 1) {
                    electedBenefits.add("Retirement");
                    boxRetirement.setSelected(true);
                }
                if (Integer.parseInt(benefit.getPet_insurance().getValue()) == 1) {
                    electedBenefits.add("Pet Insurance");
                    boxPet.setSelected(true);
                }
                listviewElectedBenefits.setItems(electedBenefits);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
