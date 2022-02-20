package com.isi.formation.mappers;

import com.isi.formation.domain.Formateur;
import com.isi.formation.web.models.FormateurDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface FormateurMapper {

    Formateur formateurDtoToFormateur(FormateurDto formateurDto);

    FormateurDto formateurToFormateurDto(Formateur formateur);

}
