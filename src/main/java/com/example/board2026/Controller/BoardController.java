package com.example.board2026.Controller;

import com.example.board2026.dto.BoardDTO;
import com.example.board2026.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor // 필요한 필드만 포함해서 생성자를 자동으로 만들어주는 Lombok 어노테이션
@RequestMapping("/board") // "/board"로 시작하는 주소를 컨트롤러가 먼저 읽음
public class BoardController {
    private final BoardService boardService; // 의존성 주입 (의존성 = 한 객체가 다른 객체를 필요로 하는 관계)

    @GetMapping("/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/save")
//    @ModelAttribute > form(사용자가 입력한 값들을 서버로 보내는 “묶음(전송 방식)”)을 객체로 받을 때
    public String save(@ModelAttribute BoardDTO boardDTO) {
        System.out.println("boardDTP = " + boardDTO);
        boardService.save(boardDTO);
        return "index";
    }

    @GetMapping("/")
    public String findAll(Model model) {
        // DB에서 전체 게시글 데이터를 가져와서 list.html에 보여준다.
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        // @PathVariable > URL 경로에서 값 꺼내는 것
        /*
            해당 게시글의 조회수를 하나 올리고
            게시글 데이터를 가져와서 detail.html에 출력
        */
        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "detail";
    }

    @GetMapping("update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("boardUpdate", boardDTO);
//        th:value="${boardUpdate.id} > thymeleaf 속성 > update.html
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
        BoardDTO board = boardService.update(boardDTO);
        model.addAttribute("board", board);
        return "detail";
//        return "redirect:/board/" + boardDTO.getId();
    }
}
