package dtos.Responses;

public class FindCommentResponse {
    private String body;

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "FindCommentResponse{" +
                "body='" + body + '\'' +
                '}';
    }

    public void setBody(String body) {
        this.body = body;
    }
}
