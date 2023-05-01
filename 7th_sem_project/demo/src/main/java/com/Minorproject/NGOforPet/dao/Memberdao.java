/**
 * 
 */
package com.Minorproject.NGOforPet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Minorproject.NGOforPet.entities.volunteers;

/**
 * @author KIIT
 *
 */
public interface Memberdao extends JpaRepository<volunteers, Integer>{
  
}
