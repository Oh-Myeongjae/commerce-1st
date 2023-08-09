package com.github.commerce03.repository;

import com.github.commerce03.repository.entity.Commend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Commend, Integer> {

}
