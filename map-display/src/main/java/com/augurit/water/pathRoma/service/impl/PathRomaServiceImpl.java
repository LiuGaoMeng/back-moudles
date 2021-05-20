package com.augurit.water.pathRoma.service.impl;

import com.augurit.agcloud.framework.ui.result.ContentResultForm;
import com.augurit.agcloud.framework.ui.result.ResultForm;
import com.augurit.water.pathRoma.domain.PathRoma;
import com.augurit.water.pathRoma.mapper.PathRomaMapper;
import com.augurit.water.pathRoma.service.PathRomaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PathRomaServiceImpl implements PathRomaService {
    @Autowired
    private PathRomaMapper pathRomaMapper;
    @Override
    public ResultForm save(PathRoma pathRoma) {
        if (pathRoma.getId()==null){
            int addFalg=pathRomaMapper.save(pathRoma);
            if (addFalg>0){
                return new ContentResultForm<>(true,"新增成功");
            }else{
                return new ContentResultForm<>(false,"新增失败！");
            }
        }
        else{
            return new ContentResultForm<>(true,"这里是修改！");
        }
    }

    @Override
    public PathRoma getById(Integer id) {
        PathRoma pathRoma=pathRomaMapper.getById(id);
        return pathRoma;
    }

    @Override
    public Map<String, Object> list(int pageNum, int pageSize) {

        Map<String,Object> resultMap=new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        List<PathRoma> list=pathRomaMapper.list();
        PageInfo<PathRoma> pageList=new PageInfo<>(list);
        resultMap.put("data",pageList.getList());
        resultMap.put("total",pageList.getTotal());
        return resultMap;
    }
}
