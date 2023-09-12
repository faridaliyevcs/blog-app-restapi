package com.blogapp.service.inter;

import com.blogapp.entity.Entry;
import com.blogapp.entity.Header;

import java.util.List;

public interface EntryServiceInter {
    List<Entry> getLastTenEntries();

    List<Entry> getTopTenEntryWithMostLikes();

    List<Entry> getAllEntry();

    Entry getEntryById(int id);

    void deleteEntryById(int id);

    void updateEntry(Entry entry);

    List<Entry> findEntriesByHeader(Header header);

}
