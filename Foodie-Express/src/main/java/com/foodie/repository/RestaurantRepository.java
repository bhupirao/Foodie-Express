package com.foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodie.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	
//	@Query("from restaurant where address_address_id = (select address_id from address a where a.area = :area OR a.building_name = :building_name OR a.city = :city OR a.country = :country OR a.pincode = :pincode OR a.state = :state OR a.street_no = :street_no)")
//	public List<Restaurant> getRestaurantByLocation(@Param("area") String area, @Param("building_name") String building_name, @Param("city") String city, @Param("country") String country, @Param("pincode") String pincode, @Param("state") String state, @Param("street_no") Integer street_no);



}
