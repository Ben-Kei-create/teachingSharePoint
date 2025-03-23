package com.myapp.teachingSharePoint.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.teachingSharePoint.bean.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
