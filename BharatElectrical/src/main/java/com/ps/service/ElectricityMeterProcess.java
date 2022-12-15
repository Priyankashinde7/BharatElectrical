package com.ps.service;

import com.ps.domain.MeterDTO;
import com.ps.entity.MeterBill;

public interface ElectricityMeterProcess {
	abstract MeterBill meterReading(MeterDTO dt);
}

