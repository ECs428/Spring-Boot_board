package com.example.board2026.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
//    ”/” (루트 주소)로 들어오면 index 페이지를 보여주는 컨트롤러

    @GetMapping("/")    // 사용자가 브라우저에서 이렇게 접속하면 > http://localhost:8082/ 실행
    public String index() {
        return "index"; // index.html 파일을 찾아서 보여줘 >
    }
}
