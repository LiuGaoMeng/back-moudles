package com.augurit.water.Address.controller;

import com.augurit.water.Address.domain.Address;
import com.augurit.water.Address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("AddressRestController")
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @RequestMapping("/getAddrName")
    public List<Address> getAddrName(@RequestBody List<Address> addresses){
        return addressService.getAddrName(addresses);
    }
    @RequestMapping("/getAddrName2")
    public String getAddrName2(@RequestParam("add") String addresses){
        return "hello";
    }

}
