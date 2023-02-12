package data.repositories;

import data.model.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository{
    int count;


    List<Comment> comments = new ArrayList<>();
    @Override
    public Comment saveComment(Comment comment) {
        boolean commentIsNotSaved = comment.getId() == 0;
        if (commentIsNotSaved) {
            comment.setId(generateId());
            comments.add(comment);
            count++;
        }
        return comment;
    }

    private int generateId() {
        return count+1;
    }

    @Override
    public long countComment() {
    return count;
    }

    @Override
    public void deleteComment(int id) {
        for (Comment comment: comments) {
            if (comment.getId() == id){
                comments.remove(comment);
                count--;
                break;
            }
        }

    }

    @Override
    public Comment findCommentById(int id) {
        for (Comment comment:comments) {
            if (comment.getId() == id){
                return comment;
            }
        }
        return null;
    }
}