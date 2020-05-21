package com.example.sensorbackend.controller;

import com.example.sensorbackend.entity.Sensor;
import com.example.sensorbackend.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensor")
public class SensorHandler {
    @Autowired
    private SensorRepository sensorRepository;

//    @GetMapping("/findAll/{page}/{size}")
//    public Page<Sensor> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
//        PageRequest request = PageRequest.of(page,size);
//        return sensorRepository.findAll(request);
//    }

    //查询全部
    @GetMapping("/findAll")
    public List<Sensor> findAll(){
        return sensorRepository.findAll();
    }

    //保存传感器信息
    @PostMapping("/save")
    public String save(@RequestBody Sensor sensor){
        Sensor result = sensorRepository.save(sensor);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    //根据id查询传感器
    @GetMapping("/findById/{id}")
    public Sensor findById(@PathVariable("id") Integer id){
        return sensorRepository.findById(id).get();
    }

    //更新传感器
    @PutMapping("/update")
    public String update(@RequestBody Sensor sensor){
        Sensor result = sensorRepository.save(sensor);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    //根据id删除传感器
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        sensorRepository.deleteById(id);
    }
}
