package dtos.Responses;

public class FindArticleResponse {
    private String title;
    private String body;

    @Override
    public String toString() {
        return "FindArticleResponse{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

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
}

