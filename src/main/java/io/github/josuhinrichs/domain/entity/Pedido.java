package io.github.josuhinrichs.domain.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido") //pode-se definir um schema também
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne //annotation de relacionamento do BD
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column( name = "data_pedido" )
    private LocalDate dataPedido;   //LocalDate é a melhor para datas

    @Column( name = "total", precision = 20, scale = 2 )
    private BigDecimal total;

    @OneToMany(mappedBy = "pedido")
    @ToString.Exclude
    private List<ItemPedido> itens;

    public List<ItemPedido> getItens(){
        if(this.itens == null){
            this.itens = new ArrayList<>();
        }
        return this.itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pedido pedido = (Pedido) o;
        return id != null && Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
