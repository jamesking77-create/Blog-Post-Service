package controllers;

import dtos.Requests.CreateNewArticleRequest;
import service.ArticleService;
import service.ArticleServiceImpl;

import java.util.NoSuchElementException;

public class ArticleController {
    private ArticleService articleService = new ArticleServiceImpl();

    public Object creatArticle(CreateNewArticleRequest articleRequest){
        try {
            return articleService.createNewArticle(articleRequest);
        }catch (NoSuchElementException e){
            return e.getMessage();
        }
    }

    public Object findArticleById(int id){
        try {
            return articleService.findArticle(id);
        }catch (NullPointerException e){
            return e.getMessage();
        }
    }

    public Object findArticleByTitle(String title){
        try {
            return articleService.findArticleByTitle(title);
        }catch (NullPointerException e){
            return e.getMessage();
        }
    }

}
