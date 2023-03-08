package service;

import data.model.Article;
import data.repositories.ArticleRepository;
import data.repositories.ArticleRepositoryImpl;
import dtos.Requests.CreateNewArticleRequest;
import dtos.Responses.FindArticleResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleServiceImplTest {
    private ArticleService articleService;
    Article article;
    ArticleRepository articleRepository;

    private CreateNewArticleRequest articleRequest;
    private CreateNewArticleRequest articleRequest2;

    @BeforeEach public void setUp(){
        articleService = new ArticleServiceImpl();
        article = new Article();
        articleRepository = new ArticleRepositoryImpl();
        articleRequest = new CreateNewArticleRequest();
        articleRequest2 = new CreateNewArticleRequest();
        articleRequest.setTitle("software engineering");
        articleRequest.setBody("i love coding");
        articleRequest.setAuthorId(article.getAuthorId());
        articleRequest2.setTitle("whatever");
        articleRequest2.setBody("anything");
        articleRequest2.setAuthorId(article.getAuthorId());
    }

    @Test public void CreateOneArticle_IdOfArticleIsOneTest(){
       Article savedArticle =  articleService.createNewArticle(articleRequest);
       assertEquals(1, savedArticle.getId());
    }
    @Test public void CreateTwoArticle_findArticleByIdTest(){
        Article firstArticle =  articleService.createNewArticle(articleRequest);
        assertEquals(1, firstArticle.getId());
        Article secondArticle = articleService.createNewArticle(articleRequest2);
        assertEquals(2, secondArticle.getId());
        FindArticleResponse foundArticle = articleService.findArticle(2);
        assertEquals(secondArticle.getTitle(), foundArticle.getTitle());
    }
    @Test public void creatTwoArticle_CountIsTwoTest(){
        articleService.createNewArticle(articleRequest);
        assertEquals(1, articleService.count());
        articleService.createNewArticle(articleRequest2);
        assertEquals(2, articleService.count());
        articleService.count();
        assertEquals(2, articleService.count());
    }
    @Test public  void createTwoArticle_findArticleByTitleTest(){
        Article firstArticle =  articleService.createNewArticle(articleRequest);
        assertEquals(1, firstArticle.getId());
        Article secondArticle = articleService.createNewArticle(articleRequest2);
        assertEquals(2, secondArticle.getId());
        FindArticleResponse foundArticle = articleService.findArticleByTitle(secondArticle.getTitle());
        assertEquals(secondArticle.getTitle(), foundArticle.getTitle());
    }

    @Test public void createTwoArticle_deleteOneArticle_countIsOneTest(){
        articleService.createNewArticle(articleRequest);
        assertEquals(1, articleService.count());
        articleService.createNewArticle(articleRequest2);
        assertEquals(2, articleService.count());
        articleService.deleteArticle(2);
        assertEquals(1, articleService.count());
    }
    @Test public void createTwoArticleWithSameTitle_ThrowsExceptionTest(){
        articleService.createNewArticle(articleRequest2);
        assertThrows(IllegalArgumentException.class, ()-> articleService.createNewArticle(articleRequest2));
    }

}