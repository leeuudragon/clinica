package com.br.clinica.config.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class Mapper {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public <S, D> D map(S source, Class<D> destinationClass) {
        return modelMapper().map(source, destinationClass);
    }

    public <S, D> List<D> mapList(List<S> sourceList, Class<D> destinationClass) {
        return sourceList.stream()
                .map(source -> modelMapper().map(source, destinationClass))
                .collect(Collectors.toList());
    }
}
