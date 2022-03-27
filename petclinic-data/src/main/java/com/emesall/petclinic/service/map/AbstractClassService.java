package com.emesall.petclinic.service.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.emesall.petclinic.model.BaseEntity;

public abstract class AbstractClassService<T extends BaseEntity, ID>{

	protected Map<Long, T> map = new HashMap<>();

	Set<T> findAll() {
		return new HashSet<>(map.values());
	}

	T findById(ID id) {
		return map.get(id);
	}

	T save(T object) {

		if (object != null) {
			if (object.getId() == null) {
				object.setId(getNextId());
			}

			map.put(object.getId(), object);
		} else {
			throw new RuntimeException("Object cannot be null");
		}

		return object;
	}

	private Long getNextId() {

		if (map.isEmpty())
	        return 1L;
	    else
	        return Collections.max(map.keySet()) + 1;

	}

	void deleteById(ID id) {
		map.remove(id);

	}

	void delete(T object) {
		map.values().removeIf(value -> value.equals(object));
	}

}