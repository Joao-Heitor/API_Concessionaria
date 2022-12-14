package br.ufpb.concessionaria.service;

import br.ufpb.concessionaria.exception.ItemNotFoundException;
import br.ufpb.concessionaria.models.Veiculo;
import br.ufpb.concessionaria.models.Venda;
import br.ufpb.concessionaria.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo createVeiculo(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listVeiculos(){
        return veiculoRepository.findAll();
    }

    public Veiculo getVeiculo(Long veiculoId){
        Optional<Veiculo> optionalVeiculo = veiculoRepository.findById(veiculoId);
        if (optionalVeiculo.isPresent()){
            return veiculoRepository.getReferenceById(veiculoId);
        }
        else {
            throw new ItemNotFoundException("Veículo " + veiculoId + " Não existe!");
        }
    }
    public Veiculo updateVeiculo(Long veiculoId, Veiculo veiculo){
        Optional<Veiculo> optionalVeiculo = veiculoRepository.findById(veiculoId);
        if (optionalVeiculo.isPresent()){
            Veiculo toUpdate = optionalVeiculo.get();
            toUpdate.setChassi(veiculo.getChassi());
            toUpdate.setModelo(veiculo.getModelo());
            toUpdate.setNome(veiculo.getNome());
            toUpdate.setAno(veiculo.getAno());
            toUpdate.setCor(veiculo.getCor());
            return toUpdate;
        }
        else {
            throw new ItemNotFoundException("Veículo " + veiculoId + " Não existe!");
        }
    }


    public void deleteVeiculo(Long veiculoId){
        Optional<Veiculo> optionalVeiculo = veiculoRepository.findById(veiculoId);
        if (optionalVeiculo.isPresent()){
            veiculoRepository.deleteById(veiculoId);
        }
        else {
            throw new ItemNotFoundException("Veículo " + veiculoId + " Não existe!");
        }
    }
}
