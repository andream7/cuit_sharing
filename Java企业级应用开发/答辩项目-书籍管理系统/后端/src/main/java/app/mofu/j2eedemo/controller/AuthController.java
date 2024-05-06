package app.mofu.j2eedemo.controller;

import app.mofu.j2eedemo.dto.ResponseDto;
import app.mofu.j2eedemo.model.User;
import app.mofu.j2eedemo.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public ResponseDto login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            return new ResponseDto(false, null, "invalid username or password");
        }

        if (user.getPassword().equals(password)) {
            session.setAttribute("username", user.getUsername());
            return new ResponseDto(true, null, "ok");
        } else {
            return new ResponseDto(false, null, "invalid username or password");
        }
    }

    @GetMapping("/logout")
    public ResponseDto logout(HttpSession session) {
        session.invalidate();
        return new ResponseDto(true, null, "ok");
    }
    
}

