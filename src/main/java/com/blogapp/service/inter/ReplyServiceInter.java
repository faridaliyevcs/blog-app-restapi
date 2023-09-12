package com.blogapp.service.inter;

import com.blogapp.entity.Reply;

import java.util.List;

public interface ReplyServiceInter {
    List<Reply> getAllReply();

    Reply getReplyById(int id);

    void deleteReplyById(int id);

    void updateReply(Reply reply);

}
