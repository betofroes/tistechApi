package com.prova.tistech.api.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.tistech.api.base.resource.BaseResource;
import com.prova.tistech.api.entities.Room;
import com.prova.tistech.api.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomResource extends BaseResource<Room, RoomService>{

}
