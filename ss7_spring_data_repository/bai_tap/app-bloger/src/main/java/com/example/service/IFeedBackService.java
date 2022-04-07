package com.example.service;

import com.example.model.FeedBack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFeedBackService {

    Page<FeedBack> findAll(Pageable pageable);

}
