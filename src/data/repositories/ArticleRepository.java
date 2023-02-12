package data.repositories;

import data.model.Article;

public interface ArticleRepository {
    Article saveArticle(Article article);
    long countArticle();
    void deleteArticle(int id);

    Article findArticleByArticleId(int id);

    void deleteAllArticle();

}
