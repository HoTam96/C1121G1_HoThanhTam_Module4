package com.example.service.impl;

import com.example.repository.IFeedBackRepository;
import com.example.service.IFeedBackService;
import org.springframework.stereotype.Service;

@Service
public class FeedBackService implements IFeedBackService {
    private IFeedBackRepository iFeedBackRepository;
}
