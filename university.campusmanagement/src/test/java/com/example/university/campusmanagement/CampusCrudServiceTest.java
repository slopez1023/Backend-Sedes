package com.example.university.campusmanagement;

import com.example.university.campusmanagement.model.Campus;
import com.example.university.campusmanagement.repository.CampusRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CampusCrudServiceTest {

    @InjectMocks
    private com.example.university.campusmanagement.service.CampusService campusCrudService;

    @Mock
    private CampusRepository campusRepository;

    private Campus campus;

    @BeforeEach
    public void setUp() {
        campus = new Campus();
        campus.setId("1");
        campus.setName("Campus Central");
        campus.setAddress("Ciudad Principal");
        campus.setActive(true);
    }

    @Test
    public void testCreate() {
        when(campusRepository.save(any(Campus.class))).thenReturn(campus);

        Object result = campusCrudService.create(campus);
        assertNotNull(result);
        assertEquals(campus, result);
        verify(campusRepository, times(1)).save(campus);
    }

    @Test
    public void testUpdate() {
        when(campusRepository.save(any(Campus.class))).thenReturn(campus);

        Object result = campusCrudService.update("1", campus);
        assertNotNull(result);
        assertEquals(campus, result);
        verify(campusRepository, times(1)).save(campus);
    }

    @Test
    public void testFindById() {
        when(campusRepository.findById("1")).thenReturn(Optional.of(campus));

        Object result = campusCrudService.findById("1");
        assertNotNull(result);
        assertEquals(campus, result);
        verify(campusRepository, times(1)).findById("1");
    }

    @Test
    public void testFindAll() {
        List<Campus> campuses = Arrays.asList(campus);
        when(campusRepository.findAll()).thenReturn(campuses);

        List<Object> result = campusCrudService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(campuses, result);
        verify(campusRepository, times(1)).findAll();
    }

    @Test
    public void testDelete() {
        when(campusRepository.findById("1")).thenReturn(Optional.of(campus));
        doNothing().when(campusRepository).deleteById("1");

        campusCrudService.delete("1");
        verify(campusRepository, times(1)).deleteById("1");
    }
}
