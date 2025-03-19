package com.artha.angular_pos_backend.service.impl;

import com.artha.angular_pos_backend.dto.responseDto.ResponseReportDto;
import com.artha.angular_pos_backend.entity.PlaceOrder;
import com.artha.angular_pos_backend.repository.PlaceOrderRepo;
import com.artha.angular_pos_backend.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final PlaceOrderRepo placeOrderRepo;
    @Override
    public ResponseReportDto getChartData(int year) {
if(year==0){
    throw new RuntimeException("Year Not Found!");
}
// Fetch all orders for the specified year
        List<PlaceOrder> yearOrders = placeOrderRepo.findByYear(year);

        // Group the orders by month and count them
        Map<Integer, Long> monthlyOrderCounts = yearOrders.stream()
                .collect(Collectors.groupingBy(
                        order -> getMonthFromDate(order.getDate()),
                        Collectors.counting()
                ));

        // Create and populate the DTO with monthly order counts
        ResponseReportDto reportDTO = new ResponseReportDto();
        reportDTO.setYear(year);

        // Set order counts for each month (default to 0 if no data exists)
        reportDTO.setJan(monthlyOrderCounts.getOrDefault(0, 0L).intValue());
        reportDTO.setFeb(monthlyOrderCounts.getOrDefault(1, 0L).intValue());
        reportDTO.setMar(monthlyOrderCounts.getOrDefault(2, 0L).intValue());
        reportDTO.setApr(monthlyOrderCounts.getOrDefault(3, 0L).intValue());
        reportDTO.setMay(monthlyOrderCounts.getOrDefault(4, 0L).intValue());
        reportDTO.setJun(monthlyOrderCounts.getOrDefault(5, 0L).intValue());
        reportDTO.setJul(monthlyOrderCounts.getOrDefault(6, 0L).intValue());
        reportDTO.setAug(monthlyOrderCounts.getOrDefault(7, 0L).intValue());
        reportDTO.setSep(monthlyOrderCounts.getOrDefault(8, 0L).intValue());
        reportDTO.setOct(monthlyOrderCounts.getOrDefault(9, 0L).intValue());
        reportDTO.setNov(monthlyOrderCounts.getOrDefault(10, 0L).intValue());
        reportDTO.setDec(monthlyOrderCounts.getOrDefault(11, 0L).intValue());

        return reportDTO;
    }

    /**
     * Helper method to extract month (0-11) from a Date
     */
    private int getMonthFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }
}
