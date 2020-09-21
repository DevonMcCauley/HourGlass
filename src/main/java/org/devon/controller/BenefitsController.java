package org.devon.controller;


import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.devon.model.About;
import org.devon.model.Benefit;
import org.devon.model.Employee;
import org.devon.model.Screen_Type;
import org.devon.utilities.DBConnection;
import org.devon.utilities.ScreenManager;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import static org.devon.controller.LoginScreenController.employeeList;
import static org.devon.utilities.DBConnection.submitQuery;

/**
 * Controller for the Benefits screen.
 *
 *
 * @author Devon McCauley
 */

public class BenefitsController implements Initializable {

    ScreenManager screenManager = new ScreenManager();

    //ArrayList of benefits available to the employee
    public static ArrayList<Benefit> benefitList = new ArrayList();

    //ArrayList that holds the benefits selected by the employee
    public static ObservableList<String> electedBenefits = FXCollections.observableArrayList();

    //<editor-fold desc="FXML Declarations">
    @FXML
    private TextField txtEmployeeFirstName;
    @FXML
    private TextField txtEmployeeLastName;
    @FXML
    private ListView<String> listviewElectedBenefits;

    @FXML
    private ImageView btnLanding;

    @FXML
    private ImageView btnTimeSheet;

    @FXML
    private ImageView btnBenefits;

    @FXML
    private ImageView btnTimeOff;

    @FXML
    private ImageView btnAbout;



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

    /**
     * Shows alert to user to confirm that they want to edit the benefits that they selected.
     * If confirmed, the Save Benefits button and checkboxes become enabled.
     * @param event
     */
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

    /**
     * When Save Benefits button is clicked, checks which options are selected and updates
     * employee benefits in the database to reflect changes
     * @param event
     */
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


    /**
     * Disables the benefit fields: medical, dental, vision, life, union member, retirement and pet insurance
     * Prevents user modification
     */
    private void lockBenefitFields() {
        boxMedical.setDisable(true);
        boxDental.setDisable(true);
        boxVision.setDisable(true);
        boxLife.setDisable(true);
        boxUnion.setDisable(true);
        boxRetirement.setDisable(true);
        boxPet.setDisable(true);
    }
    /**
     * Enables the benefit fields: medical, dental, vision, life, union member, retirement and pet insurance
     * Allows user modification
     */
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

    //Brings user respective page

    /**
     * Calls the screenChanger method in the ScreenManager class to change to the Benefits screen
     */
    @FXML
    void BenefitsClicked(MouseEvent event) {
        screenManager.screenChanger(Screen_Type.BENEFIT);
    }

    /**
     * Calls the screenChanger method in the ScreenManager class to change to the Landing Page (home) screen
     */
    @FXML
    void LandingClicked(MouseEvent event) {
        screenManager.screenChanger(Screen_Type.LANDING_PAGE);
    }

    /**
     * Calls the screenChanger method in the ScreenManager class to change to the TimeOff screen
     */
    @FXML
    void TimeOffClicked(MouseEvent event) {
        screenManager.screenChanger(Screen_Type.TIME_OFF);
    }

    /**
     * Calls the screenChanger method in the ScreenManager class to change to the TimeSheet screen
     */
    @FXML
    void TimeSheetClicked(MouseEvent event) {
        screenManager.screenChanger(Screen_Type.TIME_SHEET);
    }

    /**
     * Shows the user information about HourGlass
     * @see ScreenManager
     * @param event
     */
    @FXML
    void AboutClicked(MouseEvent event) {
        About about = new About();
        about.showAbout();
    }
    //</editor-fold>

    //<editor-fold desc="Styling Methods for the ImageView/Button Links">
    @FXML
    void changeAboutIcon(MouseEvent event) {
        btnAbout.setImage(screenManager.getActiveAboutIcon());
    }

    @FXML
    void changeBenefitsIcon(MouseEvent event) {
        btnBenefits.setImage(screenManager.getActiveBenefitsIcon());
    }

    @FXML
    void changeLandingIcon(MouseEvent event) {
        btnLanding.setImage(screenManager.getActiveLandingIcon());
    }

    @FXML
    void changeTimeSheetIcon(MouseEvent event) {
        btnTimeSheet.setImage(screenManager.getActiveTimeSheetIcon());
    }

    @FXML
    void changeTimeOffIcon(MouseEvent event) {
        btnTimeOff.setImage(screenManager.getActiveTimeOffIcon());
    }

    @FXML
    void returnLandingIcon(MouseEvent event) {
        btnLanding.setImage(screenManager.getInactiveLandingIcon());
    }

    @FXML
    void returnAboutIcon(MouseEvent event) {
        btnAbout.setImage(screenManager.getInactiveAboutIcon());
    }

    @FXML
    void returnBenefitsIcon(MouseEvent event) {
        btnBenefits.setImage(screenManager.getInactiveBenefitsIcon());
    }

    @FXML
    void returnTimeSheetIcon(MouseEvent event) {
        btnTimeSheet.setImage(screenManager.getInactiveTimeSheetIcon());
    }

    @FXML
    void returnTimeOffIcon(MouseEvent event) {
        btnTimeOff.setImage(screenManager.getInactiveTimeOffIcon());
    }
    //</editor-fold>

    /**
     * Used to initalize the controller and screen for the benefits page
     * by obtaining employee data to populate the appropriate fields from the database
     * @param location
     * @param resources
     */
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
