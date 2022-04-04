package grandemonstration.repository;


import grandemonstration.model.Picture;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPictureRepository {
    public List<Picture> getAllList();
}
