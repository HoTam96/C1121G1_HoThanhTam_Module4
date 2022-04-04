package grandemonstration.repository;


import grandemonstration.model.Picture;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IPictureRepository {

    public void insert(Picture picture);
    List<Picture>getList();
    Picture getByid(Integer id);
    void update(Picture picture);

}
