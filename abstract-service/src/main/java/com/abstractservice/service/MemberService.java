package com.abstractservice.service;

import com.abstractservice.entity.Member;
import java.util.List;

public interface MemberService {

  Member findById(Long id);

  List<Member> findAll();

  Member save(String name);
}
