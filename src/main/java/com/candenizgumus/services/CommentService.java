package com.candenizgumus.services;

import com.candenizgumus.repositories.CategoryRepository;
import com.candenizgumus.repositories.CommentRepository;

public class CommentService
{
    CommentRepository commentRepository;

    public CommentService()
    {
        this.commentRepository = new CommentRepository();
    }
}
