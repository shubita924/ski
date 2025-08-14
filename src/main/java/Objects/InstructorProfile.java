package Objects;

import java.math.BigDecimal;
import java.util.Set;

public class InstructorProfile {
    private long id;
    private long userId; // links to User(id) with role=INSTRUCTOR
    private Resort resort;
    private Set<Language> languages;
    private int yearsExperience;
    private String bio;
    private String photoUrl;
    private BigDecimal pricePerHour;
    private double averageRating;
    private int reviewCount;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Resort getResort() {
        return resort;
    }
    public void setResort(Resort resort) {
        this.resort = resort;
    }

    public Set<Language> getLanguages() {
        return languages;
    }
    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }
    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public BigDecimal getPricePerHour() {
        return pricePerHour;
    }
    public void setPricePerHour(BigDecimal pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public double getAverageRating() {
        return averageRating;
    }
    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getReviewCount() {
        return reviewCount;
    }
    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

}
