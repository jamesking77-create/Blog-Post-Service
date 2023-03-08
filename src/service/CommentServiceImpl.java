package service;

import data.model.Comment;
import data.repositories.CommentRepository;
import data.repositories.CommentRepositoryImpl;
import dtos.Requests.CreateNewCommentRequest;
import dtos.Responses.FindCommentResponse;
import util.Mapper;

import java.util.List;

public class CommentServiceImpl implements CommentService{
    CommentRepository commentRepository = new CommentRepositoryImpl();
    private int count;
    @Override
    public Comment postComment(CreateNewCommentRequest createNewCommentRequest) {
        count++;
        return commentRepository.saveComment(Mapper.map(createNewCommentRequest));

    }

    @Override
    public FindCommentResponse findCommentById(int id) {
        FindCommentResponse commentResponse = new FindCommentResponse();
        Comment foundComment = commentRepository.findCommentById(id);
        if (foundComment == null) return null;
        Mapper.map(foundComment, commentResponse);
        return commentResponse;
    }


    @Override
    public String deleteComment(int id){
        if (id == commentRepository.findCommentById(id).getId()){
            commentRepository.deleteComment(id);
            count--;
            return "comment deleted successfully";
        }
        return null;
    }

    @Override
    public long count() {
        return count;
    }
}
