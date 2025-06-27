package com.green.memoserver;

import com.green.memoserver.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // final이 붙은 멤버필드한테 생성자를 자동으로 만들어 객체의 주소값을 담겠다는 의미
public class MemoService {
  private final MemoMapper memoMapper;

  public int save(MemoPostReq p){// 객체 주소값을 담을 수 있는 공간
      return memoMapper.save(p);
  }
  public List<MemoGetRes> findAll(MemoGetReq p){
    return memoMapper.findAll(p);
  }
  public MemoGetOneRes findById(int id){
    return memoMapper.findById(id);
  }
  public int deleteById(int id){
    return memoMapper.deleteById(id);
  }
  public int modify(MemoPutReq id){
    return memoMapper.modify(id);
  }



}
