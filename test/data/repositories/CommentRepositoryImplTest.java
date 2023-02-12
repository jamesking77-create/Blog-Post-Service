package data.repositories;

import data.model.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryImplTest {
   private Comment comment;
   private CommentRepository commentRepository;

    @BeforeEach public void setUp(){
         comment = new Comment();
         commentRepository = new CommentRepositoryImpl();
         comment.setComment("i love this gist");
    }

    @Test public void saveOneComment_countIsOneTest(){
        commentRepository.saveComment(comment);
        assertEquals(1, commentRepository.countComment());
    }

    @Test public void saveOneComment_IdOfCommentIsOneTest(){
        Comment savedComment = commentRepository.saveComment(comment);
        assertEquals(1, savedComment.getId());
    }
    @Test public void setTwoCommentWithTheSameId_CountIsOneTest(){
        commentRepository.saveComment(comment);
        comment.setComment("i dont like this gist");
        commentRepository.saveComment(comment);
        assertEquals(1, commentRepository.countComment());
    }
    @Test public void saveOneComment_findCommentByIdTest(){
        Comment savedComment = commentRepository.saveComment(comment);
        assertEquals(1, savedComment.getId());
        Comment foundComment = commentRepository.findCommentById(1);
        assertEquals(savedComment, foundComment);
    }
    @Test public void saveOneComment_DeleteOneComment_CountIsZeroTest(){
        commentRepository.saveComment(comment);
        assertEquals(1, commentRepository.countComment());
        commentRepository.deleteComment(1);
        assertEquals(0, commentRepository.countComment());
    }
}