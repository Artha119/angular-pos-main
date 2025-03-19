package com.artha.angular_pos_backend.api;

import com.artha.angular_pos_backend.dto.responseDto.ResponseReportDto;
import com.artha.angular_pos_backend.service.ReportService;
import com.artha.angular_pos_backend.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/report")
public class ReportController {
    private final ReportService reportService;
    @GetMapping("/{year}")
    public ResponseEntity<StandardResponse> getChartReport(@PathVariable int year){
        ResponseReportDto chartData = reportService.getChartData(year);
        return new ResponseEntity<>(
                new StandardResponse(200,"Chart Data",chartData), HttpStatus.OK
        );
    }
}
