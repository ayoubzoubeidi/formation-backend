package com.isi.formation.mappers;

import com.isi.formation.domain.Pays;
import com.isi.formation.web.models.PaysDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface PaysMapper {

    Pays paysDtoToPays(PaysDto paysDto);

    PaysDto paysToPaysDto(Pays pays);

}
