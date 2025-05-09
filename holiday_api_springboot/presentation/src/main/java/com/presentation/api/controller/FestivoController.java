package com.presentation.api.controller;

import com.application.dto.CreateFestivoDTO;
import com.application.dto.FestivoFechaDTO;
import com.application.dto.UpdateFestivoDto;
import com.application.usecase.*;
import com.domain.model.Festivo;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/festivos")
public class FestivoController {
    private final static Logger logger = LoggerFactory.getLogger(FestivoController.class);

    private final VerificarFestivoUseCase verificarFestivoUseCase;
    private final ListarFestivosUseCase listarFestivosUseCase;
    private final CreateFestivoUseCase createFestivoUseCase;
    private final ActualizarFestivoUseCase actualizarFestivoUseCase;
    private final EliminarFestivoUseCase eliminarFestivoUseCase;
    private final ObtenerFestivoIdUseCase obtenerFestivoIdUseCase;

    public FestivoController(VerificarFestivoUseCase verificarFestivoUseCase,
                             ListarFestivosUseCase listarFestivosUseCase, CreateFestivoUseCase createFestivoUseCase, ActualizarFestivoUseCase actualizarFestivoUseCase, EliminarFestivoUseCase eliminarFestivoUseCase, ObtenerFestivoIdUseCase obtenerFestivoIdUseCase) {
        this.verificarFestivoUseCase = verificarFestivoUseCase;
        this.listarFestivosUseCase = listarFestivosUseCase;
        this.createFestivoUseCase = createFestivoUseCase;
        this.actualizarFestivoUseCase = actualizarFestivoUseCase;
        this.eliminarFestivoUseCase = eliminarFestivoUseCase;
        this.obtenerFestivoIdUseCase = obtenerFestivoIdUseCase;
    }

    @GetMapping("/{pais}/{anio}")
    public ResponseEntity<List<FestivoFechaDTO>> listaFestivcs(
            @PathVariable("pais") Long idPais,
            @PathVariable int anio) {
        List<FestivoFechaDTO> lista = listarFestivosUseCase.ejecutar(anio, idPais);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{pais}/{anio}/{mes}/{dia}")
    public ResponseEntity<String> validarFestivo(
            @PathVariable("pais") Long idPais,
            @PathVariable int anio,
            @PathVariable int mes,
            @PathVariable int dia) {

        // Validación de fecha básica
        if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {
            return ResponseEntity.badRequest().body("Fecha No Válida");
        }

        return verificarFestivoUseCase.ejecutar(anio, mes, dia, idPais)
                ? ResponseEntity.ok("Es festivo")
                : ResponseEntity.ok("No es festivo");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Festivo> obtenerFestivo(@PathVariable Long id) {
        return ResponseEntity.ok(obtenerFestivoIdUseCase.ejecutar(id));
    }

    @PostMapping()
    public ResponseEntity<Festivo> crearFestivo(@Valid  @RequestBody CreateFestivoDTO festivoDTO) {
        Festivo festivo = createFestivoUseCase.ejecutar(festivoDTO);
        return ResponseEntity.status(201).body(festivo);
    }

    @PatchMapping()
    public ResponseEntity<Festivo> actualizarFestivo(@Valid @RequestBody UpdateFestivoDto festivo) {
        return ResponseEntity.status(200).body(actualizarFestivoUseCase.ejecutar(festivo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarFestivo(@PathVariable Long id) {
        eliminarFestivoUseCase.ejecutar(id);
        return ResponseEntity.status(200).body("Festivo with ID " + id + " deleted successfully");
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
