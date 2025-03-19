package com.artha.angular_pos_backend.service;

import com.artha.angular_pos_backend.dto.responseDto.ResponseReportDto;


public interface ReportService {


    ResponseReportDto getChartData(int year);

}
