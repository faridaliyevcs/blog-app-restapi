package com.blogapp.controller;

import com.blogapp.dto.EntryDTO;
import com.blogapp.dto.HeaderDTO;
import com.blogapp.dto.LikeDTO;
import com.blogapp.dto.converter.EntryDTOConverter;
import com.blogapp.dto.converter.HeaderDTOConverter;
import com.blogapp.dto.converter.LikeDTOConverter;
import com.blogapp.entity.Entry;
import com.blogapp.entity.Like;
import com.blogapp.service.impl.EntryServiceImpl;
import com.blogapp.service.impl.LikeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {

    @Autowired
    private EntryServiceImpl entryService;

    @Autowired
    private EntryDTOConverter entryDTOConverter;

    @Autowired
    private HeaderDTOConverter headerDTOConverter;

    @Autowired
    private LikeDTOConverter likeDTOConverter;

    @Autowired
    private LikeServiceImpl likeService;

    @PostMapping("/{id}/delete")
    public ResponseEntity<EntryDTO> deleteEntry(@PathVariable(name = "id")Integer id) {
        EntryDTO entryDTO = entryDTOConverter.getEntryDTOFromEntry(entryService.getEntryById(id));
        entryService.deleteEntryById(entryService.getEntryById(id).getId());
        return ResponseEntity.ok(entryDTO);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<EntryDTO> updateEntry(@RequestBody EntryDTO entryDTO,
                                                @PathVariable(name = "id")Integer id) {
        entryDTO.setId(id);
        entryService.updateEntry(entryDTOConverter.getEntryFromEntryDTO(entryDTO));
        return ResponseEntity.ok(entryDTO);
    }

    @GetMapping
    public ResponseEntity<List<EntryDTO>> getAllEntriesOfTheHeader(@RequestBody HeaderDTO headerDTO) {
        return ResponseEntity.ok(entryDTOConverter.getListOfEntryDTOFromListOfEntry(entryService.findEntriesByHeader(headerDTOConverter.getHeaderFromHeaderDTO(headerDTO))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntryDTO> getEntry(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(entryDTOConverter.getEntryDTOFromEntry(entryService.getEntryById(id)));
    }

    @GetMapping("/last")
    public ResponseEntity<List<EntryDTO>> getLastTenEntry() {
        return ResponseEntity.ok(entryDTOConverter.getListOfEntryDTOFromListOfEntry(entryService.getLastTenEntries()));
    }

    @GetMapping("/most")
    public ResponseEntity<List<EntryDTO>> getTopTenEntryAccordingToLike() {
        return ResponseEntity.ok(entryDTOConverter.getListOfEntryDTOFromListOfEntry(entryService.getTopTenEntryWithMostLikes()));
    }

    @PostMapping("{id}/like")
    public ResponseEntity<LikeDTO> likeEntry(@PathVariable(name = "id") Integer id,
                                             @RequestBody LikeDTO likeDTO) {
        Like like = likeDTOConverter.getLikeFromLikeDTO(likeDTO);
        Entry entry = entryService.getEntryById(id);
        entry.getLikes().add(like);
        entryService.updateEntry(entry);
        likeService.updateLike(like);
        return ResponseEntity.ok(likeDTO);
    }

    @PostMapping("{id}/unlike")
    public ResponseEntity<LikeDTO> unlikeEntry(@PathVariable(name = "id") Integer id,
                                               @RequestBody LikeDTO likeDTO) {
        Like like = likeDTOConverter.getLikeFromLikeDTO(likeDTO);
        Entry entry = entryService.getEntryById(id);
        entry.getLikes().remove(like);
        entryService.updateEntry(entry);
        likeService.updateLike(like);
        return ResponseEntity.ok(likeDTO);
    }
}
