package com.lrm.JPAservice.impl;

import com.lrm.bean.Auth;
import com.lrm.JPAservice.api.logint;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class login implements logint {

    @Override
    public List<Auth> findAll() {
        return null;
    }

    @Override
    public List<Auth> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Auth> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Auth> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Auth auth) {

    }

    @Override
    public void deleteAll(Iterable<? extends Auth> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Auth> S save(S s) {
        return null;
    }

    @Override
    public <S extends Auth> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Auth> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Auth> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Auth> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Auth getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Auth> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Auth> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Auth> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Auth> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Auth> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Auth> boolean exists(Example<S> example) {
        return false;
    }
}
