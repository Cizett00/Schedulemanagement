package org.example.schedule_managemant.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedule_managemant.dto.*;
import org.example.schedule_managemant.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponseDto> CreateSchedule(@RequestBody CreateScheduleRequestDto requestDto){
        CreateScheduleResponseDto result = scheduleService.createSchedule(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetOneScheduleResponseDto> GetOneSchedule(@PathVariable Long scheduleId){
        GetOneScheduleResponseDto result = scheduleService.getOne(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/schedules")
    public ResponseEntity<List<GetOneScheduleResponseDto>> GetAllSchedule(){
        List<GetOneScheduleResponseDto> result = scheduleService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponseDto> update(
            @PathVariable Long scheduleId,
            @RequestBody UpdateScheduleRequestDto requestDto
            ){
        UpdateScheduleResponseDto result = scheduleService.update(scheduleId, requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/schedules/{scheduleId}")
    public ResponseEntity<Void> delete(@PathVariable Long scheduleId){
        scheduleService.delete(scheduleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
