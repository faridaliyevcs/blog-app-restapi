package com.blogapp.service.inter;

import com.blogapp.entity.Like;

import java.util.List;

public interface LikeServiceInter {

    List<Like> getAllLike();

    Like getLikeById(int id);

    void deleteLikeById(int id);

    void updateLike(Like like);

}
