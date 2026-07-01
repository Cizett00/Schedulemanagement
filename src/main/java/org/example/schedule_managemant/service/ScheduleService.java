package org.example.schedule_managemant.service;

import lombok.RequiredArgsConstructor;
import org.example.schedule_managemant.dto.*;
import org.example.schedule_managemant.entity.Schedule;
import org.example.schedule_managemant.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService{

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreateScheduleResponseDto createSchedule(CreateScheduleRequestDto requestDto){
        Schedule schedule = new Schedule(
                requestDto.getTitle(),
                requestDto.getContents(),
                requestDto.getName(),
                requestDto.getPassword()
        );
        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponseDto(
                saveSchedule.getId(),
                saveSchedule.getTitle(),
                saveSchedule.getContents(),
                saveSchedule.getName(),
                saveSchedule.getCreatedAt(),
                saveSchedule.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public GetScheduleResponseDto getOne(Long scheduleId){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                ()-> new IllegalStateException("없는 일정입니다")
        );
        return new GetScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }
//
//    @Transactional(readOnly = true)
//    public List<GetScheduleResponseDto> getAll(String name){
//        List<Schedule> schedules = scheduleRepository.findAll();
//
//        List<GetScheduleResponseDto> dtos = new ArrayList<>();
//
//        for (Schedule schedule : schedules) {
//            GetScheduleResponseDto dto = new GetScheduleResponseDto(
//                    schedule.getId(),
//                    schedule.getTitle(),
//                    schedule.getContents(),
//                    schedule.getName(),
//                    schedule.getCreatedAt(),
//                    schedule.getModifiedAt()
//            );
//            dtos.add(dto);
//        }
//        return dtos;
//    }
    @Transactional(readOnly = true)
    public List<GetScheduleResponseDto> getSchedule(String name){
        List<Schedule> schedules = scheduleRepository.findAll();
        List<GetScheduleResponseDto> dtos = new ArrayList<>();

        if(name != null) {
            for (Schedule schedule : schedules) {
                if (name.equals(schedule.getName())) {
                    GetScheduleResponseDto dto = new GetScheduleResponseDto(
                            schedule.getId(),
                            schedule.getTitle(),
                            schedule.getContents(),
                            schedule.getName(),
                            schedule.getCreatedAt(),
                            schedule.getModifiedAt()
                    );
                    dtos.add(dto);
                }
            }
        } else{
            for (Schedule schedule : schedules) {
                GetScheduleResponseDto dto = new GetScheduleResponseDto(
                        schedule.getId(),
                        schedule.getTitle(),
                        schedule.getContents(),
                        schedule.getName(),
                        schedule.getCreatedAt(),
                        schedule.getModifiedAt()
                );
                dtos.add(dto);
            }
        }
        dtos.sort((dto1, dto2) ->
                dto2.getModified().compareTo(dto1.getModified())
        );
        return dtos;
    }

    @Transactional
    public UpdateScheduleResponseDto update(Long scheduleId, UpdateScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                ()-> new IllegalStateException("없는 일정입니다")
        );
        if (!schedule.getPassword().equals(requestDto.getPassword())){
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
        schedule.update(
                requestDto.getTitle(),
                requestDto.getName()
        );

        return new UpdateScheduleResponseDto(
                schedule.getTitle(),
                schedule.getName(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public void delete(Long scheduleId, DeleteScheduleRequestDto requestDto){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                ()-> new IllegalStateException("없는 일정입니다")
        );
        if (!schedule.getPassword().equals(requestDto.getPassword())){
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
        scheduleRepository.deleteById(scheduleId);
    }
}
