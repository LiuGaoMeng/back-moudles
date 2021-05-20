package com.augurit.water.Address.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.augurit.water.Address.domain.Address;
import com.augurit.water.Address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private RestTemplate restTemplate;
    
    @Override
    public List<Address> getAddrName(List<Address> addresses) {

        addresses.forEach((item)-> {
            Map<String,Object> resultMap=new HashMap<>();
            ResponseEntity<String> responseEntity=restTemplate.exchange(
                    "https://apis.map.qq.com/ws/geocoder/v1/?key=d84d6d83e0e51e481e50454ccbe8986b&get_poi=1&location="+item.getLat()+","+item.getLng(),
                    HttpMethod.GET, null, String.class, new Object[0]);
             resultMap= JSONObject.parseObject((String)responseEntity.getBody());
            String name=((JSONObject)resultMap.get("result")).get("address").toString();
            item.setAddrName(name);
        });
       return addresses;
    }
}
