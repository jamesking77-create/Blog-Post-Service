package data.repositories;

import data.model.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleRepositoryImplTest {
private Article article;
private Article article2;
private ArticleRepository articleRepository;
@BeforeEach public void setUp(){
    article2 = new Article();
    article = new Article();
    articleRepository = new ArticleRepositoryImpl();
    article.setTitle("java how to program");
    article.setBody("i love to code in java");
    article2.setTitle("python how to program");
    article2.setBody("i love to code in python");
}
@Test public void saveOneArticle_CountIsOneTest(){
    articleRepository.saveArticle(article);
    assertEquals(1, articleRepository.countArticle());
}
@Test public void saveOneArticle_idOfArticleIsOneTest(){
    articleRepository.saveArticle(article);
    assertEquals(1, article.getId());
}
@Test public void SaveTwoArticleWithSameId_countIsOneTest(){
articleRepository.saveArticle(article);
assertEquals(1, articleRepository.countArticle());
article.setBody("i love to code in python and java");
articleRepository.saveArticle(article);
assertEquals(1, articleRepository.countArticle());
}

@Test public void saveOneArticle_findArticleByIdTest(){
Article savedArticle = articleRepository.saveArticle(article);
assertEquals(1, articleRepository.countArticle());
Article foundArticle = articleRepository.findArticleByArticleId(1);
assertEquals(savedArticle, foundArticle);
}
@Test public void saveTwoArticle_deleteOneArticle_countIsOne(){
    articleRepository.saveArticle(article);
    assertEquals(1, articleRepository.countArticle());
    articleRepository.saveArticle(article2);
    assertEquals(2, articleRepository.countArticle());
    articleRepository.deleteArticle(1);
    assertEquals(1, articleRepository.countArticle());
}
@Test public void saveTwoArticle_deleteAllArticle_countIsZeroTest(){
    articleRepository.saveArticle(article);
    assertEquals(1, articleRepository.countArticle());
    articleRepository.saveArticle(article2);
    assertEquals(2, articleRepository.countArticle());
    articleRepository.deleteAllArticle();
    assertEquals(0, articleRepository.countArticle());
}

@Test public void saveTwoArticle_FindArticleByTitleTest(){
    Article fistArticle =  articleRepository.saveArticle(article);
    assertEquals(1, articleRepository.countArticle());
    Article secondArticle = articleRepository.saveArticle(article2);
    assertEquals(2, articleRepository.countArticle());
    Article foundArticle = articleRepository.findArticleByTitle(article2.getTitle());
    assertEquals(secondArticle.getTitle(), foundArticle.getTitle());
}

}