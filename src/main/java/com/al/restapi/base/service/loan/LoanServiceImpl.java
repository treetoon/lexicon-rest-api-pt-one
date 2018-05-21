package com.al.restapi.base.service.loan;

import com.al.restapi.base.model.FilmEntity;
import com.al.restapi.base.model.LoanEntity;
import com.al.restapi.base.model.MemberEntity;
import com.al.restapi.base.repository.FilmRepository;
import com.al.restapi.base.repository.LoanRepository;
import com.al.restapi.base.repository.MemberRepository;
import com.al.restapi.base.service.film.FilmNotFoundException;
import com.al.restapi.base.service.member.MemberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {
    private LoanRepository loanRepository;

    private MemberRepository memberRepository;
    private FilmRepository filmRepository;

    @Autowired
    public LoanServiceImpl(MemberRepository memberRepository,
                           LoanRepository loanRepository,
                           FilmRepository filmRepository) {
        this.memberRepository = memberRepository;
        this.loanRepository = loanRepository;
        this.filmRepository = filmRepository;
    }

    @Override
    public List<LoanEntity> findLoans() throws LoanNotFoundException {
        if (loanRepository.findAll().isEmpty()) {
            throw new LoanNotFoundException("Loan list is empty...");
        } else {
            return loanRepository.findAll();
        }
    }

    @Override
    public Optional<LoanEntity> findLoanById(Long id) throws LoanNotFoundException {
        if (loanRepository.findById(id).isPresent())
            return loanRepository.findById(id);
        else
            throw new LoanNotFoundException("Loan id is out of range...");
    }

    @Override
    public Optional<LoanEntity> createLoan(Long memberId, List<FilmEntity> filmList) throws Exception {

        //if input vars exists
        if(memberId != null && filmList != null) {

            LoanEntity loan = new LoanEntity();

            //add films to loan
            if (!filmList.isEmpty()) {
                List<FilmEntity> temp = new ArrayList<>();

                for (FilmEntity film : filmList) {

                    //if film exists and film is not loaned already
                    if (filmRepository.findById(film.getFilmId()).isPresent()
                            && !filmRepository.findById(film.getFilmId()).get().getLoaned())
                    {
                        temp.add(filmRepository.findById(film.getFilmId()).get());
                    }else {
                        throw new FilmNotFoundException("Film in list is already loaned or could not be found...");
                    }
                }

                //set films as loaned
                for (FilmEntity film : temp){
                    film.setLoaned(true);
                }

                loan.setFilmList(temp); //save film list in loan
            } else {
                throw new FilmNotFoundException("Films could not be loaned...");
            }

            //if id of object matches in repo, assume equal; i.e, no field-by-field comparison
            //add member to loan
            if (memberRepository.findById(memberId).isPresent()) {
                MemberEntity temp = memberRepository.findById(memberId).get();
                loan.setMember(temp);
            } else {
                throw new MemberNotFoundException("Could not find member...");
            }

            return Optional.of(loanRepository.save(loan));
        }else{
            throw new Exception("Null found in member id or film list...");
        }
    }
}
