package com.example.fitri.conapps;

/**
 * Created by fitri on 24/11/2017.
 */

public class ContactInfo {
    private int ID;
    private String NAME;
    private String NUMBER;
    private String EMAIL;
    private String ADDRESS;

    public ContactInfo(int ID, String NAME, String NUMBER, String EMAIL, String ADDRESS) {
        this.ID = ID;
        this.NAME = NAME;
        this.NUMBER = NUMBER;
        this.EMAIL = EMAIL;
        this.ADDRESS = ADDRESS;
    }

    public ContactInfo(String NAME, String NUMBER, String EMAIL, String ADDRESS) {
        this.NAME = NAME;
        this.NUMBER = NUMBER;
        this.EMAIL = EMAIL;
        this.ADDRESS = ADDRESS;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getNUMBER() {
        return NUMBER;
    }

    public void setNUMBER(String NUMBER) {
        this.NUMBER = NUMBER;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }
}
