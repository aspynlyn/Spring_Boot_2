package com.green.memoserver;

import com.green.memoserver.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    int result = memoService.save(req);
    return result == 1 ? "success" : "fail";
  }

  // Read (get) /api/memo
  @GetMapping
   public List<MemoGetRes> getMemo(@ModelAttribute MemoGetReq req){// 변수명이 쿼리스트링의 key명과 같아야 value가 넘어옴
          //public String getMemo(@RequestParam(name="search_text", required=false) String searchText, @RequestParam(required = false) Integer page){ key명이 _인데 카멜케이스로 하고싶다면 저렇게 쓰기/ 기본적으로 required가 true여서 값이 안넘어오면 에러터지니까 false로 바꾸면 에러는 안터짐 그냥 값이 안넘어옴
          //log.info("search={}, page={}",  searchText, page);
//  MemoGetReq req = MemoGetReq.builder()
//                  .searchText(searchText)
//                  .page(page)
//                  .build();
//           ex).newparam();

  //memoService.getMemoList(searchText, page)
  // 받아야하는 데이터가 늘었을 떄 여기저기 수정할 곳이 많아지므로 객체화를 하나하나 해주면 req 자체를 바꾸지 않고 객체 하나하나만 추가하면 됨 즉 수정할 가능성이 많은 데이터는 객체로 보내는 게 효율적
    log.info("req={}", req);
  return memoService.findAll(req);
  }

  // Read (put) 주소값 겹칠때의 pathvariable
  @GetMapping("{id}")
  public MemoGetOneRes getMemoById(@PathVariable int id){
    log.info("id={}", id);
    return memoService.findById(id);
  }

  @PutMapping
  public String putMemo(@RequestBody MemoPutReq req){
    log.info("req={}", req.getMemoId());
    return "수정완료";
  }

  // Delete (delete)
  @DeleteMapping
  public int deleteMemo(@RequestParam int id){
    log.info("id={}", id);
    return memoService.deleteById(id);
  }
}
