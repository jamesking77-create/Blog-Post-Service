package dtos.Responses;

public class FindUserResponse {
    private int userId;
        private String username;
        private String fullName;
        private String dateRegistered;

        @Override
        public String toString() {
            return "FindUserResponse{" +
                    "userId='" + userId + '\'' +
                    ", username='" + username + '\'' +
                    ", fullName='" + fullName + '\'' +
                    ", dateRegistered='" + dateRegistered + '\'' +
                    '}';
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUsername(String userName) {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getDateRegistered() {
            return dateRegistered;
        }

        public void setDateRegistered(String dateRegistered) {
            this.dateRegistered = dateRegistered;
        }
    }

