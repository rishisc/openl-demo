package com.test.olingodemo.rule;

import org.openl.generated.beans.PaygridData;

public interface IRule {
    //String getEmpType(String positionSubType, String employeeSubGroup, String jobType);
    PaygridData MphasisPayGrid(String country, String compFrequency, String currencyCd, Integer level, String businessUnit, String offerJobCd);
}
