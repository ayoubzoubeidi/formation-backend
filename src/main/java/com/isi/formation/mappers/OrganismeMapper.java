package com.isi.formation.mappers;

import com.isi.formation.domain.Organisme;
import com.isi.formation.web.models.OrganismeDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class, FormationMapper.class, FormateurMapper.class})
public interface OrganismeMapper {

    Organisme organismeDtoToOrganisme(OrganismeDto organismeDto);

    OrganismeDto organismeToOrganismeDto(Organisme organisme);

}
