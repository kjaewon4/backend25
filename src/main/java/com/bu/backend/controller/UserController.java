package com.bu.backend.controller;

import com.bu.backend.dto.UserDTO;
import com.bu.backend.entity.EntityBoard;
import com.bu.backend.entity.EntityComment;
import com.bu.backend.entity.EntityUser;
import com.bu.backend.repository.CommentRepository;
import com.bu.backend.repository.RepoBoard;
import com.bu.backend.repository.RepoUser;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final RepoUser repoUser;
    private final RepoBoard repoBoard;
    private final CommentRepository repoComment;

    @PostMapping("/signup")
    public String signup(@RequestParam String userid,
                         @RequestParam String usernickname,
                         @RequestParam String username,
                         @RequestParam String userpass,

                         Model model) {

        Optional<EntityUser> existing = repoUser.findByUserid(userid);
        if (existing.isPresent()) {
            model.addAttribute("error", "이미 존재하는 아이디입니다.");
            return "signup"; // 다시 회원가입 폼으로
        }

        EntityUser user = new EntityUser(userid, usernickname, username, userpass);
        repoUser.save(user);
        return "redirect:/login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String userid,
                        @RequestParam String userpass,
                        HttpSession session,
                        Model model) {

        Optional<EntityUser> result = repoUser.findByUseridAndUserpass(userid, userpass);
        if (result.isPresent()) {
            session.setAttribute("loginUser", result.get());  // ✅ 세션에 저장
            return "redirect:/board";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
            return "login"; // 다시 로그인 폼
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/board";
    }


    // 로그인 폼 화면 보여주기
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // templates/login.html 렌더링
    }

    // 회원가입 폼 화면 보여주기
    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup"; // templates/signup.html 렌더링
    }

    @GetMapping("/mypage")
    public String showMyPage(Model model, HttpSession session) {
        EntityUser loginUser = (EntityUser) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "redirect:/login";
        }

        Optional<EntityUser> userInfo = repoUser.findByUserid(loginUser.getUserid());
        userInfo.ifPresent(entityUser -> model.addAttribute("user", entityUser));

        List<EntityBoard> posts = repoBoard.findByWriterOrderByCreationDesc(loginUser.getUserid());
        model.addAttribute("posts", posts);

        List<EntityComment> comments = repoComment.findByWriterOrderByCreatedAtDesc(loginUser.getUserid());
        model.addAttribute("comments", comments);
        return "mypage";
    }

}
