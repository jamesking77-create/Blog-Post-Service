package data.repositories;

import data.model.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoryImpl implements ArticleRepository{
   private int count;
   private final List<Article> articles = new ArrayList<>();

    @Override
    public Article saveArticle(Article article) {
        boolean articleIsNotSaved = article.getId() == 0;
        if (articleIsNotSaved) {
            article.setId(generateId());
            articles.add(article);
            count++;
        }
        return article;

    }

    private int generateId() {
        return count+1;
    }

    @Override
    public long countArticle() {
        return count;
    }

    @Override
    public void deleteArticle(int id) {
        for (Article article:articles) {
            if (article.getId() == id){
                articles.remove(article);
                count--;
                break;
            }
        }
    }

    @Override
    public Article findArticleByArticleId(int id) {
        for (Article article : articles) {
            if (article.getId() == id){
                return article;
            }
        }
        return null;
    }

    @Override
    public Article findArticleByTitle(String title) {
        for (Article article: articles) {
           if (title.equals(article.getTitle())) return article;
        }
        return null;
    }

    @Override
    public void deleteAllArticle() {
        articles.removeAll(articles);
        count = articles.size();
    }
}
