package com.chiku.dist.dmsrest.typelist;

import javax.persistence.*;

@Entity
@Table
public class Type {
    @javax.persistence.Id
    @SequenceGenerator(name = "type_sequence", sequenceName = "type_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "type_sequence")
    private Long Id;

}
