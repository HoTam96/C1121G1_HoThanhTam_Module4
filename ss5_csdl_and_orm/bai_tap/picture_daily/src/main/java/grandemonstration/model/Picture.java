package grandemonstration.model;


import javax.persistence.*;

@Entity
@Table
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer grade;
    private String author;
    private String feedBack;
    private Integer numberLike;

    public Picture(Integer id, Integer grade, String author, String feedBack, Integer numberLike) {
        this.id = id;
        this.grade = grade;
        this.author = author;
        this.feedBack = feedBack;
        this.numberLike = numberLike;
    }

    public Picture() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public Integer getNumberLike() {
        return numberLike;
    }

    public void setNumberLike(Integer numberLike) {
        this.numberLike = numberLike;
    }
}
//
//    @Override
//    public Picture clone() {
//        Picture picture = new Picture();
//        picture.setId(id);
//        picture.setComment(comment);
//        picture.setLike(like);
//        return picture;
//    }


