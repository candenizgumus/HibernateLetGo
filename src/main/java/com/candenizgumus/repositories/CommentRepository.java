package com.candenizgumus.repositories;


import com.candenizgumus.entities.Comment;

public class CommentRepository extends RepositoryManager<Comment,Long>
{
    public CommentRepository()
    {
        super(Comment.class);
    }
}
