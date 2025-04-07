package com.prueba.itx.domain.service;

import com.prueba.itx.application.usescases.PriceOutputPort;
import com.prueba.itx.domain.exception.NoPriceFoundException;
import com.prueba.itx.domain.model.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class PriceServiceTest {


    @Mock
    private PriceOutputPort priceOutputPort;

    @InjectMocks
    private PriceService priceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testGetPrice() {
        Price entity = new Price();

        entity.setProductId(35455L);
        entity.setChainId(1L);
        entity.setPrice(35.50);
        entity.setStartDate(LocalDateTime.parse("2020-06-14T00:00:00"));
        entity.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));
        entity.setPriority(1);
        entity.setCurrency("EUR");

        when(priceOutputPort.getPrice(anyLong(), anyLong(), any(LocalDateTime.class))).thenReturn(Optional.of(entity));
        Price price = priceService.getPrice(35455L, 1L, LocalDateTime.parse("2020-06-16T21:00:00"));
        assertEquals(1L, price.getChainId());
        assertEquals(35455L, price.getProductId());
        assertEquals(35.50, price.getPrice());

    }

    @Test
    void testGetPriceNoPriceFound() {
        when(priceOutputPort.getPrice(anyLong(), anyLong(), any(LocalDateTime.class))).thenReturn(Optional.empty());

        assertThrows(NoPriceFoundException.class, () -> {
            priceService.getPrice(35455L, 1L, LocalDateTime.parse("2020-06-16T21:00:00"));
        });
    }
    @Test
    void testGetPriceNull() {
        when(priceOutputPort.getPrice(anyLong(), anyLong(), any(LocalDateTime.class))).thenReturn(null);

        assertThrows(NullPointerException.class, () -> {
            priceService.getPrice(35455L, 1L, LocalDateTime.parse("2020-06-16T21:00:00"));
        });
    }

}