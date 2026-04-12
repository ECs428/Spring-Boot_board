package com.example.board2026.Controller;

import com.example.board2026.dto.BoardDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board") // "/board"로 시작하는 주소를 컨트롤러가 먼저 읽음
public class  BoardController {
    @GetMapping("/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO) {
        System.out.println("boardDTP = " + boardDTO);
        return null;
    }
}
