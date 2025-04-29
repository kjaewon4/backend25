package com.bu.backend.controller;

import com.bu.backend.entity.EntityBoard;
import com.bu.backend.entity.EntityComment;
import com.bu.backend.entity.EntityUser;
import com.bu.backend.repository.CommentRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ConcreteProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class CommentController {
    private final CommentRepository commentRepo;

    @PostMapping("/comment")
    public String addComment(@RequestParam Long boardId,
                             @RequestParam String content,
                             HttpSession session) {
        EntityUser loginUser = (EntityUser) session.getAttribute("loginUser");
        if (loginUser == null) return "redirect:/login";

        EntityComment comment = new EntityComment();
        comment.setBoard(new EntityBoard(boardId));
        comment.setWriter(loginUser.getUserid());
        comment.setContent(content);
        commentRepo.save(comment);
        return "redirect:/post/" + boardId;
    }

    @PostMapping("/comment/delete")
    public String deleteComment(@RequestParam Long commentId,
                                @RequestParam Long boardId,
                                HttpSession session) {
        EntityUser loginUser = (EntityUser) session.getAttribute("loginUser");

        EntityComment comment = commentRepo.findById(commentId).orElseThrow();
        if (loginUser == null || !comment.getWriter().equals(loginUser.getUserid())) {
            return "redirect:/login";
        }

        commentRepo.deleteById(commentId);
        return "redirect:/post/" + boardId;
    }

}
