package com.makerwei.repository;

import com.makerwei.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by weixianbin on 16/10/23.
 */
public interface AdminRopo extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);
}
