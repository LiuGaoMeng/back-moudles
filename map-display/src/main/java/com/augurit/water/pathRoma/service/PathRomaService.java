package com.augurit.water.pathRoma.service;

import com.augurit.agcloud.framework.ui.result.ResultForm;
import com.augurit.water.pathRoma.domain.PathRoma;

import java.util.Map;

public interface PathRomaService {
    ResultForm save(PathRoma pathRoma);

    PathRoma getById(Integer id);

    Map<String, Object> list(int pageNum, int pageSize);
}
