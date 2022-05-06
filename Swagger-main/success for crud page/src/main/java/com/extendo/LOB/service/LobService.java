package com.extendo.LOB.service;

import com.extendo.LOB.ErrorResponse.RecordNotFoundException;
import com.extendo.LOB.entity.Lob;
import com.extendo.LOB.repository.LobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class LobService {

    @Autowired
    private LobRepository repository;

    public static void addLob(Lob lob) {
       // return service.saveLob(lob);
    }

    public List<Lob> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)
    {

//        List<Lob> list = new ArrayList<Lob>();
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Lob> pagedResult = repository.findAll(paging);



//      return  list=pagedResult.getContent();


        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Lob>();
        }
    }

    public Lob getEmployeeById(String id) throws RecordNotFoundException
    {
        Optional<Lob> employee = repository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }


    public Lob saveLob(Lob lob){
        return repository.save(lob);
    }
    public List<Lob> saveLobs(List<Lob> lobs){
        return (List<Lob>) repository.saveAll(lobs);
    }
    public List<Lob> getLobs(){
        return (List<Lob>) repository.findAll();
    }
    public Lob getLobByLOBCode(String lobCode){
        return repository.findByLobCode(lobCode);
    }
    public Lob getLobByLobDescription(String lobDescription){
        return repository.findByLobDescription(lobDescription);
    }
    public Lob getLobByLobShortDescription(String lobShortDescription){
        return repository.findByLobShortDescription(lobShortDescription);
    }
    public Lob getLobByLobUrl(String lobUrl){
        return repository.findByLobUrl(lobUrl);
    }
    public Lob getLobByLobDescriptionByLink(String lobDescriptionByLink){
        return repository.findByLobDescriptionByLink(lobDescriptionByLink);
    }
    public Lob getLobByLobEffectiveFromDate(Date lobEffectiveFromDate){
        return repository.findByLobEffectiveFromDate(lobEffectiveFromDate);
    }
    public Lob getLobByLobEffectiveTill(Date lobEffectiveTill){
        return repository.findByLobEffectiveTill(lobEffectiveTill);
    }
    public String deleteLob(String lobCode){
        repository.deleteByLobCode(lobCode);
        return "LOBCode removed !!"+lobCode;
    }
    public Lob updateLob(Lob lob){
        Lob existingLob= repository.findByLobCode(lob.getLobCode()).orElse(null);
        existingLob.setLobDescription((String)lob.getLobDescription());
        existingLob.setLobShortDescription((String)lob.getLobShortDescription());
        existingLob.setLobUrl((String)lob.getLobUrl());
        existingLob.setLobDescriptionByLink((String)lob.getLobDescriptionByLink());
        existingLob.setLobEffectiveFromDate((Date)lob.getLobEffectiveFromDate());
        existingLob.setLobEffectiveTill((Date)lob.getLobEffectiveTill());
        return repository.save(existingLob);
       //existingLob.setLobShortDescription((String) lob.getLobShortDescription());

    }




}
