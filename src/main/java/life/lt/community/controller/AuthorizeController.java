package life.lt.community.controller;

import life.lt.community.Provide.GithubProvide;
import life.lt.community.dto.AccessTokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvide githubProvide;

    @Value("${github.client.client_id}")
    private String client_id;
    @Value("${github.client.Client_secret}")
    private String Client_secret;
    @Value("${github.client.Redirect_uri}")
    private String Redirect_uri;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setClient_id(client_id);
        accessTokenDto.setClient_secret(Client_secret);
        accessTokenDto.setRedirect_uri(Redirect_uri);
        accessTokenDto.setState(state);
        String accessToken = githubProvide.getAccessToken(accessTokenDto);
        githubProvide.getUser(accessToken);
        return "index";
    }
}
