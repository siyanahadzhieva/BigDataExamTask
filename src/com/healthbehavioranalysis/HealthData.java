package com.healthbehavioranalysis;

public class HealthData {
    private String year;
    private String ageGroup;
    private String gender;
    private double smokingPrevalence;
    private double drugExperimentation;
    private String socioeconomicStatus;
    private int peerInfluence;
    private boolean schoolPrograms;
    private int familyBackground;
    private int mentalHealth;
    private boolean accessToCounseling;
    private int parentalSupervision;
    private boolean substanceEducation;
    private int communitySupport;
    private int mediaInfluence;

    public HealthData(String year, String ageGroup, String gender, double smokingPrevalence,
                      double drugExperimentation, String socioeconomicStatus, int peerInfluence,
                      boolean schoolPrograms, int familyBackground, int mentalHealth,
                      boolean accessToCounseling, int parentalSupervision, boolean substanceEducation,
                      int communitySupport, int mediaInfluence) {
        this.year = year;
        this.ageGroup = ageGroup;
        this.gender = gender;
        this.smokingPrevalence = smokingPrevalence;
        this.drugExperimentation = drugExperimentation;
        this.socioeconomicStatus = socioeconomicStatus;
        this.peerInfluence = peerInfluence;
        this.schoolPrograms = schoolPrograms;
        this.familyBackground = familyBackground;
        this.mentalHealth = mentalHealth;
        this.accessToCounseling = accessToCounseling;
        this.parentalSupervision = parentalSupervision;
        this.substanceEducation = substanceEducation;
        this.communitySupport = communitySupport;
        this.mediaInfluence = mediaInfluence;
    }

    // Гетъри за всяко поле
    public String getYear() {
        return year;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public String getGender() {
        return gender;
    }

    public double getSmokingPrevalence() {
        return smokingPrevalence;
    }

    public double getDrugExperimentation() {
        return drugExperimentation;
    }

    public String getSocioeconomicStatus() {
        return socioeconomicStatus;
    }

    public int getPeerInfluence() {
        return peerInfluence;
    }

    public boolean isSchoolPrograms() {
        return schoolPrograms;
    }

    public int getFamilyBackground() {
        return familyBackground;
    }

    public int getMentalHealth() {
        return mentalHealth;
    }

    public boolean isAccessToCounseling() {
        return accessToCounseling;
    }

    public int getParentalSupervision() {
        return parentalSupervision;
    }

    public boolean isSubstanceEducation() {
        return substanceEducation;
    }

    public int getCommunitySupport() {
        return communitySupport;
    }

    public int getMediaInfluence() {
        return mediaInfluence;
    }

    // Сетъри (ако са необходими)
    public void setYear(String year) {
        this.year = year;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSmokingPrevalence(double smokingPrevalence) {
        this.smokingPrevalence = smokingPrevalence;
    }

    public void setDrugExperimentation(double drugExperimentation) {
        this.drugExperimentation = drugExperimentation;
    }

    public void setSocioeconomicStatus(String socioeconomicStatus) {
        this.socioeconomicStatus = socioeconomicStatus;
    }

    public void setPeerInfluence(int peerInfluence) {
        this.peerInfluence = peerInfluence;
    }

    public void setSchoolPrograms(boolean schoolPrograms) {
        this.schoolPrograms = schoolPrograms;
    }

    public void setFamilyBackground(int familyBackground) {
        this.familyBackground = familyBackground;
    }

    public void setMentalHealth(int mentalHealth) {
        this.mentalHealth = mentalHealth;
    }

    public void setAccessToCounseling(boolean accessToCounseling) {
        this.accessToCounseling = accessToCounseling;
    }

    public void setParentalSupervision(int parentalSupervision) {
        this.parentalSupervision = parentalSupervision;
    }

    public void setSubstanceEducation(boolean substanceEducation) {
        this.substanceEducation = substanceEducation;
    }

    public void setCommunitySupport(int communitySupport) {
        this.communitySupport = communitySupport;
    }

    public void setMediaInfluence(int mediaInfluence) {
        this.mediaInfluence = mediaInfluence;
    }
}
