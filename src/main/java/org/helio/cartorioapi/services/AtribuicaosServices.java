package org.helio.cartorioapi.services;
import org.helio.cartorioapi.dto.AtribuicaosDTO;
import org.helio.cartorioapi.dto.AtribuicaosDTO;
import org.helio.cartorioapi.dto.AtribuicaosMinDTO;
import org.helio.cartorioapi.entidades.Atribuicaos;
import org.helio.cartorioapi.repositorios.AtribuicaoRepository;
import org.helio.cartorioapi.repositorios.SituacaoRepository;
import org.helio.cartorioapi.services.exceptions.DatabaseException;
import org.helio.cartorioapi.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AtribuicaosServices {
    
    @Autowired
    private AtribuicaoRepository repository;

    @Transactional(readOnly = true)
    public Page<AtribuicaosMinDTO> findAll(Pageable pageable) {
        Page<Atribuicaos> result = repository.findAllBy(pageable);
        return result.map(x -> new AtribuicaosMinDTO(x));
    }

    @Transactional(readOnly = true)
    public AtribuicaosDTO findById(String id) {
        Atribuicaos entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new AtribuicaosDTO(entity);
    }

    @Transactional
    public AtribuicaosDTO insert(AtribuicaosDTO dto) {
        Atribuicaos entity = new Atribuicaos();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new AtribuicaosDTO(entity);
    }

    @Transactional
    public AtribuicaosDTO update(String id, AtribuicaosDTO dto) {
        try {
            Atribuicaos entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new AtribuicaosDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(String id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Registro utilizado em outro cadastro id: " + id);
        }
    }

    private void copyDtoToEntity(AtribuicaosDTO dto, Atribuicaos entity) {
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setSituacao(dto.isSituacao());
    }

}
