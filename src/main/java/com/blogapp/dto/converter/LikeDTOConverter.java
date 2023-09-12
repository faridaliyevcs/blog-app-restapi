package com.blogapp.dto.converter;

import com.blogapp.dto.LikeDTO;
import com.blogapp.entity.Like;
import com.blogapp.repository.LikeRepository;
import com.blogapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class LikeDTOConverter {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserDTOConverter userDTOConverter;

    @Autowired
    private EntryDTOConverter entryDTOConverter;

    @Autowired
    private UserRepository userRepository;

    public LikeDTO getLikeDTOFromLike(Like from) {
        return new LikeDTO(from.getId(), userDTOConverter.getUserDTOFromEntity(from.getUser()), entryDTOConverter.getEntryDTOFromEntry(from.getEntry()));
    }

    public Like getLikeFromLikeDTO(LikeDTO from) {
        return new Like(from.getId(), userDTOConverter.getUserFromDTO(from.getUser()), entryDTOConverter.getEntryFromEntryDTO(from.getEntryDTO()));
    }

    public List<Like> getListOfLikeFromListOfLikeDTO(List<LikeDTO> from) {
        if (from == null) {
            return Collections.emptyList();
        }
        return from.stream().map(like->getLikeFromLikeDTO(like)).collect(Collectors.toList());
    }
    public List<LikeDTO> getListOfLikeDTOFromListOfLike(List<Like> from) {
        if (from == null) {
            return Collections.emptyList();
        }
        return from.stream().map(like->getLikeDTOFromLike(like)).collect(Collectors.toList());
    }

}
