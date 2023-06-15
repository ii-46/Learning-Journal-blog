Here's an example code for a login system in Spring Boot without Spring Security:

1. LoginController.java

java
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
 
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
 
    @PostMapping("/login")
    public String processLoginForm(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session) {
         
        // check if username and password are valid
        User user = userService.authenticate(username, password);
         
        if(user != null) {
            // create session
            session.setAttribute("user", user);
            return "redirect:/secured";
        } else {
            return "login";
        }

}
}

2. UserService.java

java
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
 
    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
         
        if(user != null && passwordEncoder().matches(password, user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }
 
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

3. User.java

java
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false, unique = true)
    private String username;
 
    @Column(nullable = false)
    private String password;
 
    @Column(nullable = false)
    private boolean enabled;
 
    // getters and setters

}

4. UserRepository.java

java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}

5. LogoutController.java

java
@Controller
public class LogoutController {

    @Autowired
    private UserService userService;
 
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        userService.logout(session);
        return "redirect:/login";
    }

}

Note: This code is just an example and may need to be modified to fit your specific use case.