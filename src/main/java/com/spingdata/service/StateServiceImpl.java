package com.spingdata.service;

import com.spingdata.entity.Screen;
import com.spingdata.repository.ScreenRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*
 * @project CasestudyApp
 * @author Kundan Kumar
 */
@Service
public class ScreenServiceImpl implements ScreenService{

    private ScreenRepository screenRepository;

    public ScreenServiceImpl(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    @Override
    public Screen get(UUID uuid) throws Exception {
        Optional<Screen>  screen=this.screenRepository.findById(uuid);
        if (screen.isPresent()){
            throw  new Exception("No Screen is available with this id") ;
        }
        return screen.get();
    }

    @Override
    public List<Screen> getAll() {
        List<Screen> list=new ArrayList<>();
        this.screenRepository.findAll().forEach(screen -> {
            list.add(screen);
        });
        return list;
    }

    @Override
    public Screen save(Screen screen) {
        return this.screenRepository.save(screen);
    }

    @Override
    public Screen update(Screen screen) {
        return this.screenRepository.save(screen);
    }

    @Override
    public boolean delete(UUID id) throws Exception {
        this.screenRepository.delete(this.get(id));
        return true;
    }
}
