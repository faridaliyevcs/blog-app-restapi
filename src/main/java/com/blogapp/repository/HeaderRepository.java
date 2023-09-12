package com.blogapp.repository;

import com.blogapp.entity.Header;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HeaderRepository extends JpaRepository<Header,Integer> {
}
