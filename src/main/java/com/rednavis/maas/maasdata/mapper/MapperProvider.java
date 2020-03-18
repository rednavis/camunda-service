package com.rednavis.maas.maasdata.mapper;

import lombok.experimental.UtilityClass;
import org.mapstruct.factory.Mappers;

@UtilityClass
public class MapperProvider {

  public static final BookMapper BOOK_MAPPER = Mappers.getMapper(BookMapper.class);
}
