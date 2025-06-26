package com.green.memoserver;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // final이 붙은 멤버필드한테 생성자를 자동으로 만들어 객체의 주소값을 담겠다는 의미
public class MemoService {
  private final MemoMapper memoMapper;
  private int a;// 객체 주소값을 담을 수 있는 공간


}
