package com.blogapp.repository;

import com.blogapp.entity.Entry;
import com.blogapp.entity.Header;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EntryRepository extends JpaRepository<Entry, Integer> {
    @Query("SELECT e FROM Entry e WHERE e.header = :header")
    List<Entry> findEntriesByHeader(@Param("header") Header header);
}
