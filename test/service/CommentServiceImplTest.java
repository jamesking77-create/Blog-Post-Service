package service;

import data.model.Comment;
import dtos.Requests.CreateNewCommentRequest;
import dtos.Responses.FindCommentResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommentServiceImplTest {
    private CommentService commentService;
    private CreateNewCommentRequest commentRequest;
    private CreateNewCommentRequest commentRequest2;

    @BeforeEach public void setUp(){
        commentService = new CommentServiceImpl();
        commentRequest = new CreateNewCommentRequest();
        commentRequest.setBody("i love this article");
        commentRequest2 = new CreateNewCommentRequest();
        commentRequest2.setBody("wow");
    }
    @Test public void postOneComment_IdOfCommentIsOneTest(){
      Comment savedComment =   commentService.postComment(commentRequest);
        assertEquals(1, savedComment.getId());
    }

    @Test public void postTwoComment_FindCommentByIdTest(){
        Comment firstComment = commentService.postComment(commentRequest);
        assertEquals(1, firstComment.getId());
        Comment secondComment = commentService.postComment(commentRequest2);
        assertEquals(2, secondComment.getId());
        FindCommentResponse foundComment = commentService.findCommentById(2);
        assertEquals(secondComment.getComment(), foundComment.getBody());

    }
    @Test public void postTwoComment_deleteCommentByCommentTest(){
        Comment firstComment = commentService.postComment(commentRequest);
        assertEquals(1, firstComment.getId());
        Comment secondComment = commentService.postComment(commentRequest2);
        assertEquals(2, secondComment.getId());
        commentService.deleteComment(2);
        assertEquals(1, commentService.count());

    }

    @Test public void postTwoComment_countIsTwoTest(){
        commentService.postComment(commentRequest);
        assertEquals(1, commentService.count());
        commentService.postComment(commentRequest2);
        assertEquals(2, commentService.count());
        commentService.count();
        assertEquals(2, commentService.count());
    }

}