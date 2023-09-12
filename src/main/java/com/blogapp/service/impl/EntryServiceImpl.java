package com.blogapp.service.impl;

import com.blogapp.entity.Entry;
import com.blogapp.entity.Header;
import com.blogapp.repository.EntryRepository;
import com.blogapp.service.inter.EntryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class EntryServiceImpl implements EntryServiceInter {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private EntryRepository entryRepository;

    @Override
    public List<Entry> getLastTenEntries() {
        String query = "SELECT e FROM Entry e where DATE(date) = CURDATE()";
        TypedQuery<Entry> result = entityManager.createQuery(query, Entry.class);
        return result.getResultList();
    }

    @Override
    public List<Entry> getTopTenEntryWithMostLikes() {
        List<Entry> result = new ArrayList<>();
        for(Entry entry : entryRepository.findAll()) {
            int check = 0;
            for(int i = 0; i<entryRepository.findAll().size(); i++) {
                if(entry.getLikes().size()>entryRepository.findAll().get(i).getLikes().size()) {
                    check ++;
                }
            }
            if(check >= entryRepository.findAll().size() - 10) {
                result.add(entry);
            }
        }
        return result;
    }

    @Override
    public List<Entry> getAllEntry() {
        return entryRepository.findAll();
    }

    @Override
    public Entry getEntryById(int id) {
        return entryRepository.getById(id);
    }

    @Override
    public void deleteEntryById(int id) {
        entryRepository.deleteById(id);
    }

    @Override
    public void updateEntry(Entry entry) {
        entryRepository.save(entry);
    }

    @Override
    public List<Entry> findEntriesByHeader(Header header) {
        return entryRepository.findEntriesByHeader(header);
    }
}
