package Objects;

import java.time.Instant;

public class Review {
    private long id;
    private long instructorId;
    private long userId;
    private int rating; // 1..5
    private String comment;
    private Instant createdAt;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getInstructorId() {
        return instructorId;
    }
    public void setInstructorId(long instructorId) {
        this.instructorId = instructorId;
    }

    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
