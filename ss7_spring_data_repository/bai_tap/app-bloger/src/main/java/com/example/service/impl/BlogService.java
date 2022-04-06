package com.example.service.impl;

import com.example.model.BlogPicture;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<BlogPicture> findAll(String keyWord, Pageable pageable) {

        return this.iBlogRepository.findAllByAuthorContaining(keyWord, pageable);

    }

    @Override
    public Page<BlogPicture> findByCategoryId(Integer id, Pageable pageable) {
        return iBlogRepository.findAllByCategoryId(id, pageable);
    }

    @Override
    public List<BlogPicture> getListByCateId(Integer id) {
        TypedQuery<BlogPicture> typedQuery = entityManager.createQuery("select b from blog b where b.category.id = :id", BlogPicture.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getResultList();
    }

    @Override
    public void save(BlogPicture blogPicture) {
        iBlogRepository.save(blogPicture);

    }

    @Override
    public BlogPicture getBlogById(Integer id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public void update(BlogPicture blogPicture) {
        iBlogRepository.save(blogPicture);

    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.deleteById(id);

    }


}
