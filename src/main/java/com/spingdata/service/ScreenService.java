package com.sapient.service;

import com.sapient.entity.Movie;
import com.sapient.entity.Screen;

import java.util.List;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
public interface ScreenService {
    Screen get(UUID uuid) throws Exception;
    List<Screen> getAll();
    Screen save(Screen screen);
    Screen update(Screen screen);
    boolean delete(UUID id) throws Exception;
}
