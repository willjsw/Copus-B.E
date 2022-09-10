package com.copus.v1.domain.info;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 연계 정보
 */
@Entity
@Getter
@NoArgsConstructor
public class ConnectionInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "connection_info_id")
    private Long id;

    @OneToMany(mappedBy = "connectionInfo")
    private List<Connection> connections = new ArrayList<>();
}