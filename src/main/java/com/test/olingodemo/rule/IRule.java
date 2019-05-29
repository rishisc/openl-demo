package com.test.olingodemo.rule;

import com.test.olingodemo.vo.PaygridData;

public interface IRule {
    //String getEmpType(String positionSubType, String employeeSubGroup, String jobType);
    PaygridData MphasisPayGrid(String country, String compFrequency, String currencyCd, Integer level, String businessUnit, String offerJobCd);
}
