package com.blogapp.service.impl;

import com.blogapp.entity.Like;
import com.blogapp.repository.LikeRepository;
import com.blogapp.service.inter.LikeServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeServiceInter {

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public List<Like> getAllLike() {
        return likeRepository.findAll();
    }

    @Override
    public Like getLikeById(int id) {
        return likeRepository.getById(id);
    }

    @Override
    public void deleteLikeById(int id) {
        likeRepository.deleteById(id);
    }

    @Override
    public void updateLike(Like like) {
        likeRepository.save(like);
    }
}
