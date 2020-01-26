package model;

import javafx.beans.value.ObservableValue;

public class Beneficiary {
    private ObservableValue<String> beneficiaryID;
    private ObservableValue<String> first_name;
    private ObservableValue<String> last_name;
    private ObservableValue<String> street_address;
    private ObservableValue<String> city;
    private ObservableValue<String> state;
    private ObservableValue<String> zip;
    private ObservableValue<String> relation;


    public Beneficiary(ObservableValue<String> beneficiaryID, ObservableValue<String> first_name, ObservableValue<String> last_name, ObservableValue<String> street_address, ObservableValue<String> city, ObservableValue<String> state, ObservableValue<String> zip, ObservableValue<String> relation) {
        this.beneficiaryID = beneficiaryID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.street_address = street_address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.relation = relation;
    }


    public ObservableValue<String> getBeneficiaryID() {
        return beneficiaryID;
    }

    public ObservableValue<String> getFirst_name() {
        return first_name;
    }

    public ObservableValue<String> getLast_name() {
        return last_name;
    }

    public ObservableValue<String> getStreet_address() {
        return street_address;
    }

    public ObservableValue<String> getCity() {
        return city;
    }

    public ObservableValue<String> getState() {
        return state;
    }

    public ObservableValue<String> getZip() {
        return zip;
    }

    public ObservableValue<String> getRelation() {
        return relation;
    }
}


