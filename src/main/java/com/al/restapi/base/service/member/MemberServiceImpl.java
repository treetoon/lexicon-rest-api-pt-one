package com.al.restapi.base.service.member;

import com.al.restapi.base.model.MemberEntity;
import com.al.restapi.base.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository repo;

    @Autowired
    public MemberServiceImpl(MemberRepository repo) {
        this.repo = repo;
    }


    public List<MemberEntity> findMembers(String title) throws MemberNotFoundException {
        if (title != null) {
            if (repo.findByGenre(title).isEmpty()) {
                throw new MemberNotFoundException("Genre (" + genre +
                        "), search could not find any results...");
            } else {
                return repo.findByGenre(genre);
            }
        } else {
            if (repo.findAll().isEmpty()) {
                throw new MemberNotFoundException("Film list is empty...");
            } else {
                return repo.findAll();
            }
        }
    }
}