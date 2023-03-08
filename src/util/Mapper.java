package util;

import data.model.Article;
import data.model.Comment;
import data.model.User;
import dtos.Requests.CreateNewArticleRequest;
import dtos.Requests.CreateNewCommentRequest;
import dtos.Requests.RegisterRequest;
import dtos.Responses.FindArticleResponse;
import dtos.Responses.FindCommentResponse;
import dtos.Responses.FindUserResponse;
import java.time.format.DateTimeFormatter;



public class Mapper {

        public static Comment map(CreateNewCommentRequest commentRequest){
            Comment comment = new Comment();
            comment.setComment(commentRequest.getBody());
            comment.setId(commentRequest.getCommentId());
            comment.setArticleId(commentRequest.getArticleId());
            comment.setUserId(commentRequest.getAuthorId());
            return comment;
        }
        public static User map(RegisterRequest registerRequest){
            User user = new User();
            user.setFirstName(registerRequest.getFirstName());
            user.setLastName(registerRequest.getLastName());
            user.setUserName(registerRequest.getUsername());
            user.setPassword(registerRequest.getPassword());
            return user;
        }

        public static void map(RegisterRequest registerRequest, User user){
            user.setFirstName(registerRequest.getFirstName());
            user.setLastName(registerRequest.getLastName());
            user.setUserName(registerRequest.getUsername());
            user.setPassword(registerRequest.getPassword());
        }

        public static Article map (CreateNewArticleRequest createNewArticleRequest){
            Article article = new Article();
            article.setTitle(createNewArticleRequest.getTitle());
            article.setBody(createNewArticleRequest.getBody());
            article.setId(createNewArticleRequest.getAuthorId());
            return article;
        }

        public static void map(User foundUser, FindUserResponse response){
            response.setFullName(foundUser.getFirstName()+ " " + foundUser.getLastName());
            response.setUserId(foundUser.getId());
            response.setUsername(foundUser.getUserName());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, hh:mm a");
            response.setDateRegistered(formatter.format(foundUser.getDateRegistered()));
        }

        public static void map(CreateNewArticleRequest createArticleRequest, Article article) {
            article.setBody(createArticleRequest.getBody());
            article.setTitle(createArticleRequest.getTitle());
            article.setAuthorId(createArticleRequest.getAuthorId());
        }

        public static void map(Article foundArticle, FindArticleResponse response){
            response.setTitle(foundArticle.getTitle());
            response.setBody(foundArticle.getBody());
        }

        public static void map(Comment foundComment, FindCommentResponse response){
            response.setBody(foundComment.getComment());
        }
}

