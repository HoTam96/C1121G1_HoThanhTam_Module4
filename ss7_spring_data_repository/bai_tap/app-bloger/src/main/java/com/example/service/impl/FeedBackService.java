package com.example.service.impl;

import com.example.model.FeedBack;
import com.example.repository.IFeedBackRepository;
import com.example.service.IFeedBackService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackService implements IFeedBackService {
    private IFeedBackRepository iFeedBackRepository;

    @Override
    public Page<FeedBack> findAll(Pageable pageable) {
        return iFeedBackRepository.findAll(pageable);
    }
}
