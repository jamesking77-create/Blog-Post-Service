package service;

import data.model.Article;
import data.repositories.ArticleRepository;
import data.repositories.ArticleRepositoryImpl;
import dtos.Requests.CreateNewArticleRequest;
import dtos.Responses.FindArticleResponse;
import util.Mapper;

public class ArticleServiceImpl implements  ArticleService{

    private  final ArticleRepository articleRepository = new ArticleRepositoryImpl();
    private long count;
    @Override
    public Article createNewArticle(CreateNewArticleRequest createNewArticleRequest) {
        if (articleExist(createNewArticleRequest.getTitle())) throw new IllegalArgumentException("Article with title " + createNewArticleRequest.getTitle() + " already exists");
        count++;
        return articleRepository.saveArticle(Mapper.map(createNewArticleRequest));

    }

    private boolean articleExist(String articleTitle) {
        Article foundArticle = articleRepository.findArticleByTitle(articleTitle);
        return  foundArticle != null;
    }

    @Override
    public FindArticleResponse findArticle(int id) {
        FindArticleResponse response = new FindArticleResponse();
        Article foundArticle = articleRepository.findArticleByArticleId(id);
        if (foundArticle == null) throw new NullPointerException("Article does not exist");
        Mapper.map(foundArticle, response);
        return response;
    }

    @Override
    public Long count() {
        return count;
    }

    @Override
    public FindArticleResponse findArticleByTitle(String articleTitle) {
        FindArticleResponse response = new FindArticleResponse();
        Article foundArticle = articleRepository.findArticleByTitle(articleTitle);
        if (foundArticle == null) throw new NullPointerException("Article does not exist");
        Mapper.map(foundArticle, response);
        return response;
    }

    @Override
    public String deleteArticle(int id) {
        articleRepository.deleteArticle(id);
        count--;
        System.out.println("deleted");
        return "Article Deleted Successfully";
    }
}
