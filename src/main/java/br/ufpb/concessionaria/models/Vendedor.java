package br.ufpb.concessionaria.models;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tb_vendedor")
public class Vendedor extends Usuario{
    @Column(name = "salario")
    private String salario;

    @OneToMany(mappedBy = "id")
    @JoinColumn(name = "venda_id")
    private Collection<Venda> vendas;
    public Vendedor() {
        super();
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public Collection<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(Collection<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "salario='" + salario + '\'' +
                ", vendas=" + vendas +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
