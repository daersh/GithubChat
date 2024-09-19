package org.daersh.githubchat.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login/oauth2/code/github")
    public String GithubLogin(){
        
    }

}
