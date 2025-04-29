//package com.bu.backend.controller;
//
//import com.bu.backend.BackEnd25Application;
//import com.bu.backend.entity.EntityUser;
//import com.bu.backend.repository.RepoUser;
//import com.bu.backend.dto.UserDTO;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@Controller
//public class RestMainController {
//    private final RepoUser repoUser;
//
//    @PostMapping("/Register")
//    public String register(UserDTO dto, RedirectAttributes redirectAttributes) {
//        EntityUser user =new EntityUser(0, dto.getId(), dto.getPass());
//        repoUser.save(user);
//        if (BackEnd25Application.db_list.containsKey(dto.getId())) {
//            redirectAttributes.addFlashAttribute("error", "존재하는 아이디입니다.");
//            return "redirect:/sign"; // 다시 가입 폼으로
//        } else {
//            BackEnd25Application.db_list.put(dto.getId(), dto.getPass());
//            redirectAttributes.addFlashAttribute("success", "가입이 완료되었습니다!");
//            return "redirect:/sign"; // sign.html로 리다이렉트
//        }
//    }
//
////    @PostMapping("/Register")
////    public ResponseEntity<String> Register(UserDTO dto) {
////        if (BackEnd25Application.db_list.containsValue(dto.getId())) {
////            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("존재하는 아이디");
////        }else {
////            BackEnd25Application.db_list.put(dto.getId(), dto.getPass());
////            return ResponseEntity.status(HttpStatus.OK).body("가입 완료");
////
////        }
////    }
//
//    @PostMapping("/Login")
//    public ResponseEntity<String> Login(UserDTO dto) {
//
//        Optional<EntityUser> user = repoUser.findById(1);
//
//        if (!user.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.OK).body("로그인");
//        }else {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("꺼져");
//        }
////        switch (dto.isLogin()){
////            case ok :
////                return ResponseEntity.status(HttpStatus.OK).body("비밀번호 맞음");
////            case idError:
////                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("존재하지 않는 아이디");
////            case passError:
////                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("비밀번호 틀림");
////
////            case none:
////                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("꺼져");
////            default:
////                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("꺼져");
////        }
//    }
//}
