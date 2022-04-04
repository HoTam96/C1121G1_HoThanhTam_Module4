package grandemonstration.repository.impl;

import grandemonstration.model.Picture;
import grandemonstration.repository.IPictureRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class PictureRepository implements IPictureRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void insert(Picture picture) {
        entityManager.merge(picture);
    }
}
