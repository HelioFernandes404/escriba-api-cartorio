package org.helio.cartorioapi.services;
import org.helio.cartorioapi.dto.SituacaosDTO;
import org.helio.cartorioapi.entidades.Situacaos;
import org.helio.cartorioapi.repositorios.SituacaoRepository;
import org.helio.cartorioapi.services.exceptions.DatabaseException;
import org.helio.cartorioapi.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SituacaosServices {

    @Autowired
    private SituacaoRepository repository;

    @Transactional(readOnly = true)
    public SituacaosDTO findById(String id) {
        Situacaos situacaos = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new SituacaosDTO(situacaos);
    }

    @Transactional
    public SituacaosDTO insert(SituacaosDTO dto) {
        Situacaos entity = new Situacaos();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new SituacaosDTO(entity);
    }

    private void copyDtoToEntity(SituacaosDTO dto, Situacaos entity) {
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(String id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial Nome já informado no registro com código" + id);
        }
    }
}
