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

    @Override
    public List<Picture> getList() {
        TypedQuery<Picture>pictureTypedQuery= entityManager.createQuery("select p from Picture p",Picture.class);
        return pictureTypedQuery.getResultList();
    }

    @Override
    public Picture getByid(Integer id) {
        return entityManager.find(Picture.class, id);
    }

    @Override
    public void update(Picture picture) {
        entityManager.merge(picture);
    }
}
