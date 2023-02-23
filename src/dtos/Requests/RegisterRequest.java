package dtos.Requests;

public class RegisterRequest {
        private String lastName;
        private String firstName;
        private String username;
        private String password;

        @Override
        public String toString() {
            return "RegisterRequest{" +
                    "lastName='" + lastName + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

