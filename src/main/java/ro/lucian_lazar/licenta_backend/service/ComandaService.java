package ro.lucian_lazar.licenta_backend.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.lucian_lazar.licenta_backend.dto.ComandaDto;
import ro.lucian_lazar.licenta_backend.dto.DetaliuComandaDto;
import ro.lucian_lazar.licenta_backend.entity.Comanda;
import ro.lucian_lazar.licenta_backend.entity.DetaliuComanda;
import ro.lucian_lazar.licenta_backend.entity.Produs;
import ro.lucian_lazar.licenta_backend.entity.User;
import ro.lucian_lazar.licenta_backend.mapper.ComandaMapper;
import ro.lucian_lazar.licenta_backend.repository.ComandaRepository;
import ro.lucian_lazar.licenta_backend.repository.DetaliuComandaRepository;
import ro.lucian_lazar.licenta_backend.repository.ProdusRepository;
import ro.lucian_lazar.licenta_backend.repository.UserRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComandaService {

    private final ComandaRepository comandaRepository;
    private final UserRepository userRepository;
    private final ProdusRepository produsRepository;
    private final DetaliuComandaRepository detaliuComandaRepository;
    private final ComandaMapper comandaMapper;


    public ComandaService(ComandaRepository comandaRepository, UserRepository userRepository, ProdusRepository produsRepository, DetaliuComandaRepository detaliuComandaRepository, ComandaMapper comandaMapper) {
        this.comandaRepository = comandaRepository;
        this.userRepository = userRepository;
        this.produsRepository = produsRepository;
        this.detaliuComandaRepository = detaliuComandaRepository;
        this.comandaMapper = comandaMapper;
    }

    public List<Comanda> getAllComenzi() {
        return comandaRepository.findAll();
    }

    @Transactional
    public ComandaDto plaseazaComanda(String userEmail, List<DetaliuComandaDto> detaliiComandaDto) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Comanda comanda = new Comanda();
        comanda.setUtilizator(user);
        comanda.setStatus("Plasata");

        List<DetaliuComanda> detalii = detaliiComandaDto.stream()
                .map(dto -> {
                    Produs produs = produsRepository.findById(dto.getIdProdus())
                            .orElseThrow(() -> new RuntimeException("Product not found with id: " + dto.getIdProdus()));
                    if (produs.getStoc() < dto.getCantitate()) {
                        throw new RuntimeException("Stoc insuficient pentru " + produs.getDenumire());
                    }
                    produs.setStoc(produs.getStoc() - dto.getCantitate());
                    // The updated product will be saved by the cascade from the order save.

                    DetaliuComanda detaliu = new DetaliuComanda();
                    detaliu.setComanda(comanda);
                    detaliu.setProdus(produs);
                    detaliu.setCantitate(dto.getCantitate());
                    detaliu.setPret_unitar(produs.getPret());
                    return detaliu;
                })
                .collect(Collectors.toList());

        BigDecimal total = detalii.stream()
                .map(d -> d.getPret_unitar().multiply(new BigDecimal(d.getCantitate())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        comanda.setTotal(total);
        comanda.setDetaliiComanda(detalii);

        Comanda comandaSalvata = comandaRepository.save(comanda);

        return comandaMapper.toDto(comandaSalvata);
    }
} 