package com.blogapp.service.impl;

import com.blogapp.entity.Reply;
import com.blogapp.repository.ReplyRepository;
import com.blogapp.service.inter.ReplyServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyServiceInter {

    @Autowired
    private ReplyRepository replyRepository;

    @Override
    public List<Reply> getAllReply() {
        return replyRepository.findAll();
    }

    @Override
    public Reply getReplyById(int id) {
        return replyRepository.getById(id);
    }

    @Override
    public void deleteReplyById(int id) {
        replyRepository.deleteById(id);
    }

    @Override
    public void updateReply(Reply reply) {
        replyRepository.save(reply);
    }
}
