package com.al.restapi.base.service.member;

import com.al.restapi.base.model.MemberEntity;

import java.util.List;

public interface MemberService {
    List<MemberEntity> findMembers(String title) throws MemberNotFoundException;

}
