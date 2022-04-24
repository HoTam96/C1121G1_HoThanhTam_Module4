package com.codegym.repository;

import com.codegym.model.detail.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachRepository extends JpaRepository<AttachService, Integer> {
}
