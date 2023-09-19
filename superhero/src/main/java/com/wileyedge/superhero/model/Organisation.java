package com.wileyedge.superhero.model;

public class Organisation {
    private int orgId;
    private String orgName;
    private String orgDesc;
    private String orgContact;

    public Organisation() {
        // Default constructor
    }

    public Organisation(int orgId, String orgName, String orgDesc, String orgContact) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.orgDesc = orgDesc;
        this.orgContact = orgContact;
    }

    public Organisation(int i, String justiceLeague, String superheroTeam) {
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }

    public String getOrgContact() {
        return orgContact;
    }

    public void setOrgContact(String orgContact) {
        this.orgContact = orgContact;
    }

    @Override
    public String toString() {
        return "Organisation [orgId=" + orgId + ", orgName=" + orgName + ", orgDesc=" + orgDesc + ", orgContact=" + orgContact + "]";
    }
}
