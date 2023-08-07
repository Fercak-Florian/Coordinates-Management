package com.crystalfinance.api.repository;
import com.crystalfinance.api.model.Coordinates;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinatesRepository extends MongoRepository<Coordinates, String> {
}
