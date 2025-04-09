package com.parZival26.holiday_api_springboot.application.service;

import com.parZival26.holiday_api_springboot.application.mapper.FestivoMapper;
import com.parZival26.holiday_api_springboot.domain.model.Festivo;
import com.parZival26.holiday_api_springboot.domain.repository.FestivoRepository;
import com.parZival26.holiday_api_springboot.domain.repository.TipoRepository;
import com.parZival26.holiday_api_springboot.domain.service.FestivoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class FestivoServiceImpl implements FestivoService {
    private final FestivoRepository festivoRepository;
    private final TipoRepository tipoRepository;
    private final FestivoMapper festivoMapper;

    public FestivoServiceImpl(FestivoRepository festivoRepository,
                              TipoRepository tipoRepository,
                              FestivoMapper festivoMapper) {
        this.festivoRepository = festivoRepository;
        this.tipoRepository = tipoRepository;
        this.festivoMapper = festivoMapper;
    }

    @Override
    public Optional<Festivo> esFestivo(int anio, int mes, int dia, Long idPais) {

        List<Festivo> festivosPais = festivoRepository.findByPais(idPais);

        LocalDate fechaConsulta = LocalDate.of(anio, mes, dia);

        LocalDate domingoPascua = calcularDomingoPascua(anio);

        for (Festivo festivo : festivosPais) {
            Long idTipo = festivo.getIdTipo();

            if (idTipo == 1L) {
                if (festivo.getMes() == mes && festivo.getDia() == dia) {
                    return Optional.of(festivo);
                }
            } else if (idTipo == 2L) {
                LocalDate fechaFestivo = LocalDate.of(anio, festivo.getMes(), festivo.getDia());
                LocalDate fechaLunes = trasladarAlSiguienteLunes(fechaFestivo);

                if (fechaLunes.equals(fechaConsulta)) {
                    return Optional.of(festivo);
                }
            } else if (idTipo == 3L) {
                if (festivo.getDiasPascua() != null) {
                    LocalDate fechaFestivo = domingoPascua.plusDays(festivo.getDiasPascua());

                    if (fechaFestivo.equals(fechaConsulta)) {
                        return Optional.of(festivo);
                    }
                }
            } else if (idTipo == 4L) {
                if (festivo.getDiasPascua() != null) {
                    LocalDate fechaFestivo = domingoPascua.plusDays(festivo.getDiasPascua());
                    LocalDate fechaLunes = trasladarAlSiguienteLunes(fechaFestivo);

                    if (fechaLunes.equals(fechaConsulta)) {
                        return Optional.of(festivo);
                    }
                }
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Festivo> listarFestivosPorPaisYAño(int anio, Long idPais) {
        return List.of();
    }

    private LocalDate trasladarAlSiguienteLunes(LocalDate fecha) {
        if (fecha.getDayOfWeek() == DayOfWeek.MONDAY) {
            return fecha;
        }

        int diasHastaLunes = DayOfWeek.MONDAY.getValue() - fecha.getDayOfWeek().getValue();
        if (diasHastaLunes <= 0) {
            diasHastaLunes += 7;
        }

        return fecha.plusDays(diasHastaLunes);
    }

    private LocalDate calcularDomingoPascua(int anio) {
        int a = anio % 19;
        int b = anio % 4;
        int c = anio % 7;
        int d = (19 * a + 24) % 30;
        int dias = d + (2 * b + 4 * c + 6 * d + 5) % 7;

        LocalDate domingoRamos = LocalDate.of(anio, 3, 15).plusDays(dias);

        return domingoRamos.plusDays(7);
    }
}
