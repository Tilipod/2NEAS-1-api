package ru.tilipod.feign.scheduler;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "${feign.client.config.scheduler.name}")
public interface SchedulerFeign extends SchedulerApi {

}
