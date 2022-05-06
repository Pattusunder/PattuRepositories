package com.extendo.LOB.repository;

import com.extendo.LOB.entity.Lob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.Optional;

public interface LobRepository extends JpaRepository<Lob,String> {


    Lob findByLobCode(String lobCode);

    Lob findByLobDescription(String lobDescription);

    Lob findByLobShortDescription(String lobShortDescription);

    Lob findByLobUrl(String lobUrl);

    Lob findByLobDescriptionByLink(String lobDescriptionByLink);

    Lob findByLobEffectiveFromDate(Date lobEffectiveFromDate);

    Lob findByLobEffectiveTill(Date lobEffectiveTill);

    String deleteByLobCode(String lobCode);


}
