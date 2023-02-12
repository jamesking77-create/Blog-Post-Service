package data.repositories;

import data.model.Comment;

public interface CommentRepository {
    Comment saveComment(Comment comment);
    long countComment();

    void deleteComment(int id);
    Comment findCommentById(int id);
}
