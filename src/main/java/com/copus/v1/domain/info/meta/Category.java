package com.copus.v1.domain.info.meta;

import com.copus.v1.domain.enums.CategoryType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private CategoryType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_info_id")
    private CategoryInfo categoryInfo;

    @OneToMany(mappedBy = "category")
    private List<CategoryBody> categoryBodies = new ArrayList<>();


    public Category(CategoryType type, CategoryInfo categoryInfo) {
        this.type = type;
        this.categoryInfo = categoryInfo;
    }

}
