package com.addgate.calculator.repository;

import com.addgate.calculator.repository.entity.OperandoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataOperandoRepository extends JpaRepository<OperandoEntity, Long> {

    List<OperandoEntity> findByIdTransaction(String idTrasaction);

    void deleteByIdTransaction(String idTrasaction);

}
