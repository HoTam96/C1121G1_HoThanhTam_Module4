package com.example.service.impl;

import com.example.model.BlogPicture;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<BlogPicture> findAll() {
        return this.iBlogRepository.findAll();

    }

    @Override
    public List<BlogPicture> getListByCateId(Integer id) {
        TypedQuery<BlogPicture> typedQuery= entityManager.createQuery("select b from blog b where b.category.id = :id",BlogPicture.class);
        typedQuery.setParameter("id",id);
        return typedQuery.getResultList();
    }
}
