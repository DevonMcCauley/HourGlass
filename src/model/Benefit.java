package model;

import javafx.beans.value.ObservableValue;

public class Benefit {
    private ObservableValue<String> benefitID;
    private ObservableValue<String> medical;
    private ObservableValue<String> dental;
    private ObservableValue<String> vision;
    private ObservableValue<String> life;
    private ObservableValue<String> union_member;
    private ObservableValue<String> retirement;
    private ObservableValue<String> pet_insurance;

    public Benefit(ObservableValue<String> benefitID, ObservableValue<String> medical, ObservableValue<String> dental, ObservableValue<String> vision, ObservableValue<String> life, ObservableValue<String> union_member, ObservableValue<String> retirement, ObservableValue<String> pet_insurance) {
        this.benefitID = benefitID;
        this.medical = medical;
        this.dental = dental;
        this.vision = vision;
        this.life = life;
        this.union_member = union_member;
        this.retirement = retirement;
        this.pet_insurance = pet_insurance;
    }

    public ObservableValue<String> getBenefitID() {
        return benefitID;
    }

    public ObservableValue<String> getMedical() {
        return medical;
    }

    public ObservableValue<String> getDental() {
        return dental;
    }

    public ObservableValue<String> getVision() {
        return vision;
    }

    public ObservableValue<String> getLife() {
        return life;
    }

    public ObservableValue<String> getUnion_member() {
        return union_member;
    }

    public ObservableValue<String> getRetirement() {
        return retirement;
    }

    public ObservableValue<String> getPet_insurance() {
        return pet_insurance;
    }



}
