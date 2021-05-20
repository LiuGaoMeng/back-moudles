package com.augurit.water.pathRoma.controller;

import com.augurit.agcloud.framework.ui.result.ResultForm;
import com.augurit.water.pathRoma.domain.PathRoma;
import com.augurit.water.pathRoma.service.PathRomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("pathRomaRestController")
@RequestMapping("/pathRoma")
public class PathRomaController {
    @Autowired
    private PathRomaService pathRomaService;
    
    @RequestMapping("/list")
    public Map<String, Object> list(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "99999999") int pageSize){
        return pathRomaService.list(pageNum,pageSize);

    }
    @RequestMapping("/save")
    public ResultForm save(@RequestBody PathRoma pathRoma){
        return pathRomaService.save(pathRoma);
    }
    @RequestMapping("/getById")
    public PathRoma getById(@RequestParam("id") Integer id){
        return pathRomaService.getById(id);
    }
}
