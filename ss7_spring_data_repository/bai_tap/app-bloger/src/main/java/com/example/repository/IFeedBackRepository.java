package com.example.repository;

import com.example.model.FeedBack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFeedBackRepository extends JpaRepository<FeedBack, Integer> {
    Page<FeedBack>findAll(Pageable pageable);
}
