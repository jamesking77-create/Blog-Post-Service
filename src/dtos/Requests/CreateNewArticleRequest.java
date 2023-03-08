package dtos.Requests;

public class CreateNewArticleRequest {
    private String title;
    private String body;

    @Override
    public String toString() {
        return "CreateNewArticleRequest{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", authorId=" + authorId +
                ", articleId=" + articleId +
                '}';
    }

    private int authorId;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    private  int articleId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
