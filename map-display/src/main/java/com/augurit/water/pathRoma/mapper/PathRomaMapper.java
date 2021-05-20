package com.augurit.water.pathRoma.mapper;

import com.augurit.water.pathRoma.domain.PathRoma;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PathRomaMapper {
    int save(PathRoma pathRoma);

    PathRoma getById(@Param("id") Integer id);

    List<PathRoma> list();
}
