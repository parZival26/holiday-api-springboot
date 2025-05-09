package com.presentation.api.controller;

import com.application.dto.CreatePaisDTO;
import com.application.dto.PaisDTO;
import com.application.dto.UpdatePaisDTO;
import com.application.mapper.PaisMapper;
import com.application.usecase.*;
import com.domain.model.Pais;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pais")
public class PaisController {
    private static final Logger logger = LoggerFactory.getLogger(PaisController.class);
    private final CrearPaisUseCase crearPaisUseCase;
    private final ListarPaisesuseCase listarPaisesuseCase;
    private final ActualizarPaisUseCase actualizarPaisUseCase;
    private final ObtenerPaisIdUseCase obtenerPaisIdUseCase;
    private final EliminarPaisUseCase eliminarPaisUseCase;
    private final PaisMapper paisMapper;


    public PaisController(CrearPaisUseCase crearPaisUseCase, ListarPaisesuseCase listarPaisesuseCase, ActualizarPaisUseCase actualizarPaisUseCase, ObtenerPaisIdUseCase obtenerPaisIdUseCase, EliminarPaisUseCase eliminarPaisUseCase, PaisMapper paisMapper) {
        this.crearPaisUseCase = crearPaisUseCase;
        this.listarPaisesuseCase = listarPaisesuseCase;
        this.actualizarPaisUseCase = actualizarPaisUseCase;
        this.obtenerPaisIdUseCase = obtenerPaisIdUseCase;
        this.eliminarPaisUseCase = eliminarPaisUseCase;
        this.paisMapper = paisMapper;
    }

    @PostMapping()
    public ResponseEntity<PaisDTO> crearPais(@Valid @RequestBody CreatePaisDTO createPaisDTO) {
        logger.info("Attempting to create Pais with name: {}", createPaisDTO.getNombre());
        Pais paisModel = crearPaisUseCase.ejecutar(createPaisDTO);
        PaisDTO paisResponseDTO = paisMapper.toDto(paisModel);
        logger.info("Successfully created Pais with ID: {} and name: {}", paisResponseDTO.getId(),
                paisResponseDTO.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(paisResponseDTO);
    }

    @GetMapping()
    public  ResponseEntity<List<PaisDTO>> listarPaises() {
        logger.info("Attempting to list all Paises");
        List<PaisDTO> paises = listarPaisesuseCase.ejecutar();
        logger.info("Successfully retrieved {} Paises", paises.size());
        return ResponseEntity.ok(paises);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PaisDTO>> obtenerPaisPorId(@PathVariable Long id) {
        logger.info("Attempting to retrieve Pais with ID: {}", id);
        Optional<PaisDTO> paisResponseDTO = obtenerPaisIdUseCase.ejecutar(id);
        if (paisResponseDTO.isPresent()) {
            logger.info("Successfully retrieved Pais with ID: {} and name: {}", paisResponseDTO.get().getId(),
                    paisResponseDTO.get().getNombre());
            return ResponseEntity.ok(paisResponseDTO);
        } else {
            logger.warn("Pais with ID: {} not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.empty());
        }
    }

    @PatchMapping()
    public ResponseEntity<PaisDTO> actualizarPais(
            @Valid @RequestBody UpdatePaisDTO updatePaisDTO) {
        logger.info("Attempting to update Pais with ID: {}", updatePaisDTO.getId());
        PaisDTO paisResponseDTO = actualizarPaisUseCase.ejecutar(updatePaisDTO);
        logger.info("Successfully updated Pais with ID: {} and name: {}", paisResponseDTO.getId(),
                paisResponseDTO.getNombre());
        return ResponseEntity.ok(paisResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPais(@PathVariable Long id) {
        logger.info("Attempting to delete Pais with ID: {}", id);
        eliminarPaisUseCase.ejecutar(id);
        logger.info("Successfully deleted Pais with ID: {}", id);
        return ResponseEntity.ok("Pais with ID " + id + " successfully deleted");
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
            logger.warn("Validation error for field '{}': {}", fieldName, errorMessage);
        });
        return errors;
    }
}
