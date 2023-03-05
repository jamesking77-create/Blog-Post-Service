package service;

import data.model.Article;
import dtos.Requests.CreateNewArticleRequest;
import dtos.Responses.FindArticleResponse;

public interface ArticleService {
Article createNewArticle(CreateNewArticleRequest createNewArticleRequest);
FindArticleResponse findArticle(int id);
Long count();
FindArticleResponse findArticleByTitle(String articleTitle);

String deleteArticle(int id);
}
