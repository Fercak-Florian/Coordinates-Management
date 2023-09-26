package com.crystalfinance.api.service;

import com.crystalfinance.api.model.Coordinates;
import com.crystalfinance.api.repository.CoordinatesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DistanceCalculateServiceTest {

    private DistanceCalculateService distanceCalculateService;

    @Mock
    private CoordinatesRepository coordinatesRepository;

    @BeforeEach
    public void init() {
        distanceCalculateService = new DistanceCalculateService(coordinatesRepository);
    }

    @Test
    @DisplayName("calculateDistance should return 17 Km")
    public void calculateDistanceShouldReturnSevenTeenKm() {
        /*ARRANGE*/
        
        String idOne = "aaa";
        String idTwo = "bbb";

        Coordinates coordinatesOne = new Coordinates("aaa", "Avoriaz", 46.200000, 6.766667);
        Coordinates coordinatesTwo = new Coordinates("bbb", "Taninges", 46.1075116, 6.5913801);

        Optional<Coordinates> optionalCoordinatesOne = Optional.of(coordinatesOne);
        Optional<Coordinates> optionalCoordinatesTwo = Optional.of(coordinatesTwo);

        when(coordinatesRepository.findById(idOne)).thenReturn(optionalCoordinatesOne);
        when(coordinatesRepository.findById(idTwo)).thenReturn(optionalCoordinatesTwo);

        /*ACT*/
        long result = distanceCalculateService.calculateDistance(idOne, idTwo);

        /*ASSERT*/
        assertThat(result).isEqualTo(17);
        verify(coordinatesRepository).findById(idOne);
        verify(coordinatesRepository).findById(idTwo);
    }
}
