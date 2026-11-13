package com.example.rsss_stanle_reyes_cc7.service;

import com.example.rsss_stanle_reyes_cc7.controller.dto.FinalizarOrdenDTO;
import com.example.rsss_stanle_reyes_cc7.controller.dto.OrdenServicioDTO;
import com.example.rsss_stanle_reyes_cc7.controller.dto.DesactivarVheiculoDTO;
import com.example.rsss_stanle_reyes_cc7.controller.dto.VheiculoDTO;
import com.example.rsss_stanle_reyes_cc7.model.EnumEstado;
import com.example.rsss_stanle_reyes_cc7.model.OrdenServicio;
import com.example.rsss_stanle_reyes_cc7.model.Vheiculo;
import com.example.rsss_stanle_reyes_cc7.repository.OrdenServicioRepository;
import com.example.rsss_stanle_reyes_cc7.repository.VheiculoRepository;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private final OrdenServicioRepository ordenServicioRepository;
    private final VheiculoRepository vheiculoRepository;


    public MyService(VheiculoRepository vheiculoRepository, OrdenServicioRepository ordenServicioRepository) {
        this.vheiculoRepository = vheiculoRepository;
        this.ordenServicioRepository = ordenServicioRepository;
    }

    //Vheiculo = Curso, Orden = Inscripcion


    //CrearOrdenServicio
    public OrdenServicio crearOrdenServicio
        (OrdenServicioDTO payload){

        Vheiculo vheiculo = vheiculoRepository.findById(payload.getVheiculo_id())
                .orElseThrow(
                        ()-> new RuntimeException("El vheiculo no exite")
                );

        if (vheiculo.isActivo()){
            throw new RuntimeException("El vheiculo debe estar activo");
        }

        //Comprobar que el vehículo no tenga otra orden en estado RECIBIDA o EN_REPARACION
        if ((payload.getEstado() == EnumEstado.EN_REPARACION) || (payload.getEstado() == EnumEstado.RECIBIDA)) {
            throw new RuntimeException("El vehículo ya tiene otra orden en estado RECIBIDA o EN_REPARACION");
        }

        OrdenServicio nuevaOrden = new OrdenServicio();
        nuevaOrden.setVehiculo(vheiculo);
        nuevaOrden.setEstado(EnumEstado.RECIBIDA);
        nuevaOrden.setCosto(0.0);
        nuevaOrden.setDescripcion(payload.getDescripcion());
        nuevaOrden.setTipo(payload.getTipo());

        return ordenServicioRepository.save(nuevaOrden);
    }


    //Finalizar una orden
    public OrdenServicio finalizarOrden(FinalizarOrdenDTO payload){
        OrdenServicio orden = ordenServicioRepository.findById(payload.getOrden_id())
                .orElseThrow(
                        ()-> new RuntimeException("La orden no existe")
                );
        if (payload.getEstado() != EnumEstado.EN_REPARACION){
            throw new RuntimeException("El estado debe ser: EN_REPARACION");
        }

        OrdenServicio terminarOrden = new OrdenServicio();
        terminarOrden.setEstado(EnumEstado.FINALIZADA);
        return ordenServicioRepository.save(terminarOrden);
    }


    /*
    Desactivar vehículo — 10 puntos
     */
    public Vheiculo desactivarVheiculo(DesactivarVheiculoDTO payload){
        Vheiculo vheiculo = vheiculoRepository.findById(payload.getVheiculo_id())
                .orElseThrow(
                        ()-> new RuntimeException("El vheiculo no existe")
                );
        if (payload.getEstado() == EnumEstado.RECIBIDA || payload.getEstado() == EnumEstado.EN_REPARACION){
            throw new RuntimeException("El estado debe ser: FINALIZADA o CANCELADA");
        }

        Vheiculo desactivarVheiculo = new Vheiculo();
        desactivarVheiculo.setActivo(false);
        return vheiculoRepository.save(desactivarVheiculo);
    }

    /*
    Registrar vehículo — 10 puntos
     */

    public Vheiculo registrarVheiculo(VheiculoDTO payload){
        Vheiculo vheiculo = vheiculoRepository.findById(payload.getVheiculo_id())
                .orElseThrow(
                        ()-> new RuntimeException("El vheiculo no existe")
                );

        Vheiculo registrar = new Vheiculo();
        registrar.setActivo(true);
        registrar.setPlaca(payload.getPlaca());
        registrar.setMarca(payload.getMarca());
        registrar.setModelo(payload.getModelo());
        registrar.setPropietario(payload.getPropietario());
        return vheiculoRepository.save(registrar);
    }

}