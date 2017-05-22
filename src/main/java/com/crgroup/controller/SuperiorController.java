package com.crgroup.controller;

import com.crgroup.model.Superior;
import com.crgroup.repository.SuperiorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class SuperiorController {

    @Autowired
    private SuperiorRepository superiorRepository;

    @RequestMapping(value = "superiors", method = RequestMethod.GET)
    public List<Superior> list() {
        return superiorRepository.findAll();
    }

    @RequestMapping(value = "superiors", method = RequestMethod.POST)
    public Superior create(@RequestBody Superior superior) {
        return superiorRepository.saveAndFlush(superior);
    }

    @RequestMapping(value = "superiors/{id}", method = RequestMethod.GET)
    public Superior get(@PathVariable Long id) {
        return superiorRepository.findOne(id);
    }

    @RequestMapping(value = "superiors/{id}", method = RequestMethod.PUT)
    public Superior update(@PathVariable Long id, @RequestBody Superior superior) {
        Superior existingSuperior = superiorRepository.findOne(id);
        BeanUtils.copyProperties(superior, existingSuperior);
        return superiorRepository.saveAndFlush(existingSuperior);
    }

    @RequestMapping(value = "superiors/{id}", method = RequestMethod.DELETE)
    public Superior delete(@PathVariable Long id) {
        Superior existingSuperior = superiorRepository.findOne(id);
        superiorRepository.delete(existingSuperior);
        return existingSuperior;
    }
}
