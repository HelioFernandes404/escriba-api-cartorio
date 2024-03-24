package org.helio.cartorioapi.services;

import org.helio.cartorioapi.dto.*;
import org.helio.cartorioapi.dto.CartoriosDTO;
import org.helio.cartorioapi.entidades.Atribuicaos;
import org.helio.cartorioapi.entidades.Cartorios;
import org.helio.cartorioapi.entidades.Cartorios;
import org.helio.cartorioapi.entidades.Situacaos;
import org.helio.cartorioapi.repositorios.AtribuicaoRepository;
import org.helio.cartorioapi.repositorios.CartoriosRepository;
import org.helio.cartorioapi.repositorios.SituacaoRepository;
import org.helio.cartorioapi.services.exceptions.DatabaseException;
import org.helio.cartorioapi.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartoriosServices {

    @Autowired
    private CartoriosRepository cartoriosRepository;
    @Autowired
    private AtribuicaoRepository atribuicaoRepository;
    @Autowired
    private SituacaoRepository situacaoRepository;

    @Transactional(readOnly = true)
    public Page<CartoriosMinDTO> findAll(Pageable pageable) {
        Page<Cartorios> result = cartoriosRepository.findAllBy(pageable);
        return result.map(x -> new CartoriosMinDTO(x));
    }

    @Transactional(readOnly = true)
    public Cartorios findById(Integer id) {
        Cartorios entity = cartoriosRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return entity;
    }

    @Transactional
    public CartoriosDTO insert(CartoriosDTO dto) {
        Cartorios entity = new Cartorios();
        copyDtoToEntity(dto, entity);
        entity = cartoriosRepository.save(entity);
        return new CartoriosDTO(entity);
    }


    @Transactional
    public CartoriosDTO update(Integer id, CartoriosDTO dto) {
        try {
            Cartorios entity = cartoriosRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = cartoriosRepository.save(entity);
            return new CartoriosDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Integer id) {
        try {
            cartoriosRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Registro utilizado em outro cadastro");
        }
    }


    private void copyDtoToEntity(CartoriosDTO dto, Cartorios entity) {
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setObservacao(dto.getObservacao());


        if (dto.getSituacao() != null) {
            Situacaos entitySituacaos = situacaoRepository.getReferenceById(dto.getSituacao().getId());
            entity.setSituacao(entitySituacaos);
        } else {
            Situacaos defaultSituacao = new Situacaos("SIT_BLOQUEADO", "Bloqueado", null);
            entity.setSituacao(defaultSituacao);
        }

        if (dto.getAtribuicoes() != null) {
            List<Atribuicaos> list = new ArrayList<>();
            for (AtribuicaosDTO atribuicaoDTO : dto.getAtribuicoes()) {
                Atribuicaos atribuicao = atribuicaoRepository.getReferenceById(atribuicaoDTO.getId());

                list.add(atribuicao);
            }
            entity.setAtribuicoes(list);
        } else {
            //Atribuicaos defaultAtribuicaos = new Atribuicaos();
            //entity.setAtribuicoes();
            entity.setAtribuicoes(new ArrayList<>());
        }
    }



    private Atribuicaos convertAtribuicaosDTOToAtribuicaos(AtribuicaosDTO atribuicaosDTO) {
        if (atribuicaosDTO == null) {
            return null;
        }
        Atribuicaos atribuicao = new Atribuicaos();
        // Copie os campos do DTO para a entidade aqui
        // Exemplo: atribuicao.setId(atribuicaosDTO.getId());
        atribuicao.setId(atribuicaosDTO.getId());
        atribuicao.setNome(atribuicaosDTO.getNome());
        atribuicao.setSituacao(atribuicao.isSituacao());
        return atribuicao;
    }

}
