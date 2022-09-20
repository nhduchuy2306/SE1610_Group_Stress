/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stress.dao;

import java.util.List;

/**
 *
 * @author Huy
 */
public interface DAO<T> {
    // C R U D
    boolean create(T data);
    List<T> getAll();
    T getByID(String id);
    
}
