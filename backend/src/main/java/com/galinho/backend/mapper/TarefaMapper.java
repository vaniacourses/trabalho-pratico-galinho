package com.galinho.backend.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassMapping;

import com.galinho.backend.dto.TarefaAdicionalDto;
import com.galinho.backend.dto.TarefaDto;
import com.galinho.backend.dto.TarefaSimplesDto;
import com.galinho.backend.model.Servicos.Tarefa.TarefaAdicional;
import com.galinho.backend.model.Servicos.Tarefa.TarefaEntity;
import com.galinho.backend.model.Servicos.Tarefa.TarefaSimples;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

    @SubclassMapping(source = TarefaSimples.class, target = TarefaSimplesDto.class)
    @SubclassMapping(source = TarefaAdicional.class, target = TarefaAdicionalDto.class)
    TarefaDto toTarefaDto(TarefaEntity tarefa);

    TarefaSimplesDto toTarefaDto(TarefaSimples tarefa);

    @Mapping(source = "tarefaDecorada", target = "tarefa")
    TarefaAdicionalDto toTarefaDto(TarefaAdicional tarefa);

}
