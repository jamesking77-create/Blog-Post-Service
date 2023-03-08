package data.repositories;

import data.model.Comment;

import java.util.List;

public interface CommentRepository {
    Comment saveComment(Comment comment);
    long countComment();
    void deleteComment(int id);
    Comment findCommentById(int id);

    List<Comment> findAllComment();
    void deleteAllComment();
}
