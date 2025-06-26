package com.green.memoserver;

import com.green.memoserver.model.MemoPostReq;
import com.green.memoserver.model.MemoPutReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController // 응답과 요청을 다 할 수 있는 놈으로 승격
@RequiredArgsConstructor
@Slf4j // sout 대신 log.info("req={}", req);
@RequestMapping("api/memo")// 공통URL일떄 형식 지정

public class MemoController {
  private final MemoService memoService;

  // Create (post) /api/memo
  @PostMapping
  public String postMemo(@RequestBody MemoPostReq req){ // RequestBody를 쓰지 않으면 기본적으로 ModelAttribute가 자동으로 붙어 html의 form태그를 통해 넘어오는 정보로 명시하게 됨
    log.info("req={}", req);
    return "저장성공";
  }

  // Read (get) /api/memo
  @GetMapping
  public String getMemo(@RequestParam String search){ // 변수명이 쿼리스트링의 key명과 같아야 value가 넘어옴
//    public String getMemo(@RequestParam(name="search_text", required=false) String searchText) key명이 _인데 카멜케이스로 하고싶다면 저렇게 쓰기/ 기본적으로 required가 true여서 값이 안넘어오면 에러터지니까 false로 바꾸면 에러는 안터짐 그냥 값이 안넘어옴
    log.info("search={}", search);
    return "메모리스트";
  }

  // Read (put) 주소값 겹칠때의 pathvariable
  @GetMapping("{id}")
  public String getMemoById(@PathVariable int id){
    log.info("id={}", id);
    return "메모하나";
  }

  @PutMapping
  public String putMemo(@RequestBody MemoPutReq req){
    log.info("req={}", req.getMemoId());
    return "수정완료";
  }

  // Delete (delete)
  @DeleteMapping
  public String deleteMemo(@RequestParam(name = "memo_id") String memoId){
    log.info("memoId={}", memoId);
    return "삭제완료";
  }
}
