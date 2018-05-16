package com.al.restapi.base.service.member;

import com.al.restapi.base.model.MemberEntity;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    List<MemberEntity> findMembers(String title) throws MemberNotFoundException;
    List<MemberEntity> saveMember(List<MemberEntity> memberEntity) throws MemberNotFoundException;
    Optional<MemberEntity> findMemberById(Long id) throws MemberNotFoundException;
    Optional<MemberEntity> updateMemberById(Long id, MemberEntity newMember) throws MemberNotFoundException;
    void deleteMemberById(Long id);
}
