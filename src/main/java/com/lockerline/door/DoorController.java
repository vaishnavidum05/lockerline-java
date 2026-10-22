package com.lockerline.door;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** HTTP endpoints for the locker wall and an individual door. */
@RestController
@RequestMapping("/towers/{tower}/doors")
public class DoorController {

    private final DoorService service;

    public DoorController(DoorService service) {
        this.service = service;
    }
    @GetMapping
    public WallView wall(
            @PathVariable String tower,
            @RequestParam(required = false) SizeClass size,
            @RequestParam(required = false) DoorState state) {
        return service.wall(tower, size, state);
    }
    @GetMapping("/{no}")
    public DoorDetail door(
            @PathVariable String tower,
            @PathVariable String no) {
        return service.door(tower, no);
    }
}
