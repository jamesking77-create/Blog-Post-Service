package service;

import data.model.Comment;
import dtos.Requests.CreateNewCommentRequest;
import dtos.Responses.FindCommentResponse;

import java.util.List;

public interface CommentService {
    Comment postComment(CreateNewCommentRequest createNewCommentRequest);
    FindCommentResponse findCommentById(int id);

    String deleteComment(int id);
    long count();

}
