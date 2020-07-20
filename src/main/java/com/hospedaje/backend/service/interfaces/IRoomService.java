/**
 * 
 */
package com.hospedaje.backend.service.interfaces;

import java.util.List;

import com.hospedaje.backend.model.Room;

/**
 * @author rafael
 *
 */
public interface IRoomService {

	public List<Room> findAll();

	public Room findById(Long id);

	public void create(Room room);

	public void update(Room room);

	public void deleteById(Long id);
}
