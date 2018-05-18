package com.al.restapi.base.service.member;

import com.al.restapi.base.model.MemberEntity;
import com.al.restapi.base.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository repo;

    @Autowired
    public MemberServiceImpl(MemberRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<MemberEntity> findMembers(String name) throws MemberNotFoundException {
        if (name != null) {
            if (repo.findByName(name).isEmpty()) {
                throw new MemberNotFoundException("Name (" + name +
                        "), search could not find any results...");
            } else {
                return repo.findByName(name);
            }
        } else {
            if (repo.findAll().isEmpty()) {
                throw new MemberNotFoundException("Member list is empty...");
            } else {
                return repo.findAll();
            }
        }
    }

    @Override
    public Optional<MemberEntity> findMemberById(Long id) throws MemberNotFoundException {
        if (repo.findById(id).isPresent())
            return repo.findById(id);
        else
            throw new MemberNotFoundException("Member id is out of range...");
    }

    @Override
    public List<MemberEntity> saveMember(List<MemberEntity> member) throws MemberNotFoundException {
        if(!repo.saveAll(member).isEmpty())
            return repo.saveAll(member);
        else
            throw new MemberNotFoundException("No members in the list...");
    }

    @Override
    public Optional<MemberEntity> updateMemberById(Long id, MemberEntity newMember) throws MemberNotFoundException {
        Optional<MemberEntity> currentMember = repo.findById(id);

        if(currentMember.isPresent() && newMember != null){
            currentMember.get().setName(newMember.getName());
            currentMember.get().setAddress(newMember.getAddress());

            repo.save(currentMember.get());
            return currentMember; //returns updated film
        }else{
            throw new MemberNotFoundException("Could not update member...");
        }
    }

    @Override
    public void deleteMemberById(Long id){
        repo.deleteById(id);
    }
}