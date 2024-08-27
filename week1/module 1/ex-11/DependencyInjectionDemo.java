public class DependencyInjectionDemo {

    // Repository Interface
    public interface UserRepository {
        String getUserById(String id);
    }

    // Concrete Repository
    public static class UserRepositoryImpl implements UserRepository {
        @Override
        public String getUserById(String id) {
            // In a real application, this would query a database
            return "User details for ID: " + id;
        }
    }

    // Service Class
    public static class UserService {
        private UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public void fetchUserDetails(String id) {
            System.out.println(userRepository.getUserById(id));
        }
    }

    // Test the Dependency Injection Implementation
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserService(userRepository);
        userService.fetchUserDetails("12345");
    }
}
