package com.green.memoserver.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemoGetReq {
  private String searchText;
  private Integer page;
}
