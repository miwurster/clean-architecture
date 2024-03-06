package io.miwurster.clean.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductSchema, String> {

}
