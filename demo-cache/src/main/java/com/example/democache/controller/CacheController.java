package com.example.democache.controller;

import com.example.democache.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/cache")
@CacheConfig(cacheNames = "chache")
public class CacheController {
    HashMap<Integer,Student> hashMap;
     {
        hashMap = new LinkedHashMap<>();
        hashMap.put(1,new Student(1,"全栈学习笔记",20));
        hashMap.put(22,new Student(22,"studynote.cn",21));
    }
    @Autowired
    private CacheManager cacheManager;


    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/cacheAble")
    @Cacheable(value = "cache",key = "#root.args[0]",condition = "#id>20")
    public  Student cacheAble(@RequestParam Integer id) {
        Student student = (Student) hashMap.get(id);
        System.out.println("第一次调用了方法，添加缓存");
        return student;
    }

    /**
     *
     * @param student
     * @return
     */
    @PostMapping("/putCache")
    @CachePut(value = "cache",key = "#result.id")
    public Student putCache(@RequestBody Student student) {
        hashMap.replace(student.getId(),student);
        System.out.println("调用了方法，也更新了缓存");
        return student;
    }

    /**
     * 清除缓存
     * @param id
     */
    @CacheEvict(value = "cache",key = "#id",beforeInvocation = true,allEntries = false)
    @GetMapping("/cacheEvict")
    public void cacheEvict(@RequestParam Integer id) {
        hashMap.remove(id);
        System.out.println("缓存删除");
    }

    @Caching(
        cacheable = {
                @Cacheable(value = "cache",key = "#id"),
                @Cacheable(value = "cache1",key = "#id")
        },
        evict = {@CacheEvict(value = "cache2",key = "#id")}
    )
    @GetMapping("/caching")
    public Student caching(@RequestParam Integer id) {
        Student student = (Student)hashMap.get(id);
        System.out.println("新增缓存了，也删除了缓存，但是操作的cache不一样");
        return student;
    }
    @GetMapping("/get")
    public Student getCache(@RequestParam Integer id){
        Cache cache = cacheManager.getCache("cache");
        Cache.ValueWrapper student = cache.get(id);
        Object o = student.get();
        return (Student) o;
    }

}
