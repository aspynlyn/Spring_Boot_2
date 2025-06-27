package com.green.memoserver;

import com.green.memoserver.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemoMapper {
  int save(MemoPostReq p);
  List<MemoGetRes> findAll(MemoGetReq p);
  MemoGetOneRes findById(int id);
  int deleteById(int id);
  int modify(MemoPutReq id);

  // insert update delete는 무조건 int(영향받은 행 기준이므로)
}
