package data.repositories;

import data.model.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository{
  private   int count;


   private final List<Comment> comments = new ArrayList<>();
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

    @Override
    public List<Comment> findAllComment() {
        return comments;
    }

    @Override
    public void deleteAllComment() {
        comments.removeAll(comments);
        count = comments.size();

    }
}
