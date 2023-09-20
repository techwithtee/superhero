package com.wileyedge.superhero.model;

public class HeroOrg {
    private int heroId;
    private String heroName;
    private int orgId;
    private String orgName;

    public HeroOrg() {
    }

    public HeroOrg(int heroId, String heroName, int orgId, String orgName) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.orgId = orgId;
        this.orgName = orgName;
    }

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
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
}