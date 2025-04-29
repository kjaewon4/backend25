package com.bu.backend.controller;

import com.bu.backend.BackEnd25Application;
import com.bu.backend.entity.EntityBoard;
import com.bu.backend.entity.EntityComment;
import com.bu.backend.entity.EntityUser;
import com.bu.backend.repository.CommentRepository;
import com.bu.backend.repository.RepoBoard;
import com.bu.backend.repository.RepoUser;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final RepoBoard repoBoard;
    private final CommentRepository commentRepo;

    @GetMapping("/test")
    public String test(Model m) {


        m.addAttribute("username", "나");
        return "temp";
    }

    @GetMapping("/test2")
    public String test2(Model m) {
        m.addAttribute("message", "배고파");
        m.addAttribute("currentDate", new java.util.Date());

        return "temp2";
    }

    @ResponseBody
    @GetMapping("/restTest")
    public ResponseEntity<String> restTest(
            @RequestParam String id,
            @RequestParam String pass
    ) {
        System.out.println(id + " " + pass);

        String db_pass = BackEnd25Application.db_list.get(id);

        System.out.println(db_pass);

        if(pass.equals(db_pass)) {
            return ResponseEntity.status(HttpStatus.OK).body("비밀번호 맞음");
        }else{
            if(db_pass == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("존재하지 않는 아이디");
            }

            if (!db_pass.equals(pass)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("비밀번호 틀림");
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("꺼져");
    }

    @GetMapping("/sign")
    public String loginForm() {
        return "sign";
    }

    @ResponseBody
    @GetMapping("/dummy")
    public String dummy(Model m) {
        for (int i=0; i<20; i++) {
            repoBoard.save(
                    new EntityBoard("aaaa",
                    "이충인" + String.valueOf((i)),
                    LocalDateTime.now()
            ));
        }
        return "20개 만들었음";
    }


    @GetMapping("/board")
    public String board(
            @RequestParam(value="page", defaultValue = "0") int page,
            @RequestParam(value="size", defaultValue = "15") int size,
            Model model) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<EntityBoard> postsPage = repoBoard.findAll(pageable);

        List<EntityBoard> list = repoBoard.findAll();

        model.addAttribute("postsPage", postsPage);

        return "board";
    }

    // create
    @PostMapping("/createBoard")
    public String createBoard(@RequestParam String title,
                              @RequestParam String content,
                              HttpSession session) {

        EntityUser loginUser = (EntityUser) session.getAttribute("loginUser");
        if(loginUser == null) {
            return "redirect:/login";
        }

        EntityBoard board = new EntityBoard();
        board.setTitle(title);
        board.setWriter(loginUser.getUserid());
        board.setContent(content);
        board.setCreation(LocalDateTime.now()); // 작성일 설정 (필드 있다면)

        repoBoard.save(board);

        return "redirect:/board"; // 저장 후 목록 페이지로 이동
    }



    // delete
    @PostMapping("/post/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        repoBoard.deleteById(id);
        return "redirect:/board";
    }


    // update
    @PostMapping("/updateBoard")
    public String updateBoard(@RequestParam Long id,
                              @RequestParam String title,
                              @RequestParam String writer,
                              @RequestParam String content) {
        EntityBoard board = repoBoard.findById(id).orElseThrow();
        board.setTitle(title);
        board.setWriter(writer);
        board.setContent(content);
        repoBoard.save(board);

        return "redirect:/board"; // ✅ 수정 후 목록 리다이렉트
    }


    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        EntityBoard post = repoBoard.findById(id).orElseThrow();
        List<EntityComment> comments = commentRepo.findByBoardIdOrderByCreatedAtDesc(id);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        return "post-detail";
    }





}
