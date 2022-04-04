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
    public List<Picture> getAllList() {
        TypedQuery<Picture> typedQuery = entityManager.
                createQuery("select o from Picture o", Picture.class);
        return typedQuery.getResultList();
    }
}
