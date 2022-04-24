package com.isi.formation.mappers;

import com.isi.formation.domain.Domaine;
import com.isi.formation.web.models.DomaineDto;
import org.mapstruct.Mapper;

@Mapper
public interface DomaineMapper {

    Domaine domaineDtoToDomaine(DomaineDto domaineDto);

    DomaineDto domaineToDomaineDto(Domaine domaine);

}
