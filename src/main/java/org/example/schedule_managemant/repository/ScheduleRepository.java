package org.example.schedule_managemant.repository;

import org.example.schedule_managemant.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
