package com.wileyedge.superhero.model;

public class Hero {
    private int heroId;
    private String heroName;
    private String heroDesc;
    private String superpower;

    public Hero() {
        // Default constructor
    }

    public Hero(int heroId, String heroName, String heroDesc, String superpower) {
        this.heroId = heroId;
        this.heroName = heroName;
        this.heroDesc = heroDesc;
        this.superpower = superpower;
    }

    public Hero(int i, String superman, String flying) {
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

    public String getHeroDesc() {
        return heroDesc;
    }

    public void setHeroDesc(String heroDesc) {
        this.heroDesc = heroDesc;
    }

    public String getSuperpower() {
        return superpower;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    @Override
    public String toString() {
        return "Hero [heroId=" + heroId + ", heroName=" + heroName + ", heroDesc=" + heroDesc + ", superpower=" + superpower + "]";
    }
}
