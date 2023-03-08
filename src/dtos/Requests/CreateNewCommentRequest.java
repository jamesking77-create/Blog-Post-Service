package dtos.Requests;

public class CreateNewCommentRequest {
    private String body;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "CreateNewCommentRequest{" +
                "body='" + body + '\'' +
                ", articleId=" + articleId +
                ", authorId=" + authorId +
                ", commentId=" + commentId +
                '}';
    }

    private int articleId;
    private int authorId;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    private int commentId;
}
