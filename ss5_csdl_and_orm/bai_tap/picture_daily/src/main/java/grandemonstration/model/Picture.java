package grandemonstration.model;


import javax.persistence.*;

@Entity
@Table
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String commentt;
    private Integer likee;

    public Picture(Integer id, String commentt, Integer likee) {
        this.id = id;
        this.commentt = commentt;
        this.likee = likee;
    }

    public Picture() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentt() {
        return commentt;
    }

    public void setCommentt(String commentt) {
        this.commentt = commentt;
    }

    public Integer getLikee() {
        return likee;
    }

    public void setLikee(Integer likee) {
        this.likee = likee;
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


