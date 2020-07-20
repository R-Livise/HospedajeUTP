/**
 * 
 */
package com.hospedaje.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospedaje.backend.model.Room;
import com.hospedaje.backend.repository.IRoomRepository;
import com.hospedaje.backend.service.interfaces.IRoomService;

/**
 * @author rafael
 *
 */
@Service
@Transactional
public class RoomService implements IRoomService{

	@Autowired
	public IRoomRepository _roomRepository;

	@Override
	public List<Room> findAll() {
		
		return _roomRepository.findAll();
	}

	@Override
	public Room findById(Long id) {

		return _roomRepository.findByID(id);
	}

	@Override
	public void create(Room room) {
		
		_roomRepository.save(room);
		
	}

	@Override
	public void update(Room room) {
		
		_roomRepository.save(room);
		
	}

	@Override
	public void deleteById(Long id) {
		
		Room room = _roomRepository.findByID(id);
		_roomRepository.delete(room);
		
	}
}
