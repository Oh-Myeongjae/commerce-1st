package com.github.commerce03.repository.commend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommendRepository extends JpaRepository<Commend, Integer> {

}
