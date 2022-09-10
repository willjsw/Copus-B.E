package com.copus.v1.domain.info;

import com.copus.v1.domain.enums.ConnectionType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "connection_id")
    private Long id;

    private String connectionEnd;
    private String connectionStart;
    @Enumerated(value = EnumType.STRING)
    private ConnectionType type;

    @ManyToOne
    @JoinColumn(name = "connection_info_id")
    private ConnectionInfo connectionInfo;

    public Connection(String connectionEnd, String connectionStart, ConnectionType type, ConnectionInfo connectionInfo) {
        this.connectionEnd = connectionEnd;
        this.connectionStart = connectionStart;
        this.type = type;
        this.connectionInfo = connectionInfo;
    }
}
