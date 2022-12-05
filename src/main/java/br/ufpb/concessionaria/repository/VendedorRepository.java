package br.ufpb.concessionaria.repository;

import br.ufpb.concessionaria.models.Usuario;
import br.ufpb.concessionaria.models.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

}
