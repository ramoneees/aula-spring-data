package com.minhaapi.aula03.repository;

import com.minhaapi.aula03.dao.ClienteDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteDAO, Long> {
    public ClienteDAO findByNome(String nome);
}
