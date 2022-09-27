/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.stress.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Huy
 */
public interface DAO<T, ID> {
    List<T>getAll() throws SQLException;
    T getByID(ID id) throws SQLException;
    boolean update(ID id) throws SQLException;
    boolean delete(ID id) throws SQLException;
}
