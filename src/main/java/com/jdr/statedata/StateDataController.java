package com.jdr.statedata;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateDataController {

    @RequestMapping("/districts")
    public District[] collectUSDIstrictData(){
        ReadExcel reade = new ReadExcel();
        District[] districts = reade.getDistrictData();
        return  districts;

    }
}
